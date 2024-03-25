package net.cosmosfury.divinefavours.block;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import com.simibubi.create.foundation.placement.IPlacementHelper;
import com.simibubi.create.foundation.placement.PlacementHelpers;
import com.simibubi.create.foundation.placement.PlacementOffset;
import net.cosmosfury.divinefavours.item.itemregistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

// add corner, place on inside of block
public class railingblock extends Block implements ProperWaterloggedBlock, IWrenchable {
    private final int placementHelperID;

    private static final VoxelShape VOXEL_NORTH = Block.box(
            0d, 0d, 0d,
            16d, 16d, 2d
    );
    private static final VoxelShape VOXEL_SOUTH = Block.box(
            0d, 0d, 14d,
            16d, 16d, 16d
    );
    private static final VoxelShape VOXEL_EAST = Block.box(
            14d, 0d, 0d,
            16d, 16d, 16d
    );
    private static final VoxelShape VOXEL_WEST = Block.box(
            0d, 0d, 0d,
            2d, 16d, 16d
    );

    public static final BooleanProperty NORTH_FENCE = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH_FENCE = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST_FENCE  = BlockStateProperties.EAST;
    public static final BooleanProperty WEST_FENCE  = BlockStateProperties.WEST;

    public railingblock(Properties props) {
        super(props);
        placementHelperID = PlacementHelpers.register(new RailingHelper());
        this.registerDefaultState(this.defaultBlockState()
                .setValue(NORTH_FENCE, false)
                .setValue(SOUTH_FENCE, false)
                .setValue(EAST_FENCE, false)
                .setValue(WEST_FENCE, false)
                .setValue(BlockStateProperties.WATERLOGGED, false)
        );
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction facing = ctx.getHorizontalDirection();
        FluidState fluid = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockState state = defaultBlockState()

                .setValue(NORTH_FENCE, (facing == Direction.NORTH))
                .setValue(SOUTH_FENCE, (facing == Direction.SOUTH))
                .setValue(EAST_FENCE, (facing == Direction.EAST))
                .setValue(WEST_FENCE, (facing == Direction.WEST))
                .setValue(BlockStateProperties.WATERLOGGED, fluid.getType() == Fluids.WATER);;

        // Use the getRotatedBlockState method to adjust the state based on the targeted face
        return getRotatedBlockState(state, facing);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(NORTH_FENCE);
        builder.add(SOUTH_FENCE);
        builder.add(EAST_FENCE);
        builder.add(WEST_FENCE);
        builder.add(BlockStateProperties.WATERLOGGED);
    }
    @Override
    public boolean canPlaceLiquid (BlockGetter world, BlockPos pos, BlockState state, Fluid fluid) {
        return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext ctx) {
        return getInteractionShape(state, reader, pos);
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        VoxelShape shape = Shapes.empty();
        if (state.getValue(NORTH_FENCE)) shape = Shapes.join(shape, VOXEL_NORTH, BooleanOp.OR);
        if (state.getValue(SOUTH_FENCE)) shape = Shapes.join(shape, VOXEL_SOUTH, BooleanOp.OR);
        if (state.getValue(EAST_FENCE)) shape = Shapes.join(shape, VOXEL_EAST, BooleanOp.OR);
        if (state.getValue(WEST_FENCE)) shape = Shapes.join(shape, VOXEL_WEST, BooleanOp.OR);

        return shape;
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        Direction face = hit.getDirection();
        IPlacementHelper helper = PlacementHelpers.get(placementHelperID);
        Item item = itemStack.getItem();
        BlockHitResult ray = new BlockHitResult(hit.getLocation(), face, pos, true);

        if (player == null) return InteractionResult.PASS;

        PlacementOffset offset = null;
        if (helper.matchesState(state)) {
            offset = helper.getOffset(player, world, state, pos, ray);
        }

        if (offset != null && offset.isSuccessful() && !player.isShiftKeyDown()) {
            state = offset.getGhostState();
            BlockPos offsetPos = offset.getBlockPos();
            BlockState newState = offset.getTransform().apply(state);
            world.setBlock(offsetPos, newState, 3);
            world.gameEvent(GameEvent.BLOCK_PLACE, offsetPos, GameEvent.Context.of(player, state));
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }

        return super.use(state, world, pos, player, hand, hit);
    }
    @Override
    public InteractionResult onSneakWrenched (BlockState state, UseOnContext context) {
        BlockPos pos   = context.getClickedPos();
        Vec3 subbox    = context.getClickLocation().subtract(pos.getCenter());
        Direction face = context.getClickedFace();
        Level level    = context.getLevel();
        Player player  = context.getPlayer();
        var x = subbox.x;
        var z = subbox.z;

        if (level instanceof ClientLevel) return InteractionResult.PASS;

        //check if the top face is wrenched, remove side
        if (face == Direction.UP) {
            boolean bottomleft = x < -z;
            boolean topleft = x < z;
            var dir = Direction.WEST;
            if (!bottomleft && topleft) dir = Direction.SOUTH;
            if (!bottomleft && !topleft) dir = Direction.EAST;
            if (bottomleft && !topleft) dir = Direction.NORTH;
            if (bottomleft && topleft) dir = Direction.WEST;

            //obscure edge case where a corner of the top face cannot be wrenched
            if (state.getValue(fromDirection(dir))) {
                state = state.setValue(fromDirection(dir), false);
                level.setBlock(pos, state, 3);
                playRemoveSound(level, pos);
                if (!player.getAbilities().instabuild) player.addItem(new ItemStack(state.getBlock().asItem()));
                return InteractionResult.SUCCESS;
            }
            else return InteractionResult.PASS;
        }

        //check for wrenching the inside faces
        if (x == 0.375 || x == -0.375 || z == 0.375 || z == -0.375) state = state.setValue(fromDirection(face.getOpposite()), false);

        //check for wrenching the outside faces
        if (x == 0.5 || x == -0.5 || z == 0.5 || z == -0.5) {
            if (!state.getValue(fromDirection(face))) {
                if (x >= 0.375) state = state.setValue(EAST_FENCE, false);
                if (x <= -0.375) state = state.setValue(WEST_FENCE, false);
                if (z <= -0.375) state = state.setValue(NORTH_FENCE, false);
                if (z >= 0.375) state = state.setValue(SOUTH_FENCE, false);
            }
            else state = state.setValue(fromDirection(face), false);
        }

        level.setBlock(pos, state, 3);
        playRemoveSound(level, pos);
        if (!player.getAbilities().instabuild) player.addItem(new ItemStack(state.getBlock().asItem()));
        return InteractionResult.SUCCESS;
    }


    private Direction getBlockFacing(BlockState state) {
        if (state.getValue(NORTH_FENCE)) return Direction.NORTH;
        if (state.getValue(SOUTH_FENCE)) return Direction.SOUTH;
        if (state.getValue(EAST_FENCE)) return Direction.EAST;
        if (state.getValue(WEST_FENCE)) return Direction.WEST;
        return Direction.NORTH; // Default facing
    }

    public static BooleanProperty fromDirection(Direction face) {
        return switch (face) {
            case SOUTH -> SOUTH_FENCE;
            case EAST -> EAST_FENCE;
            case WEST -> WEST_FENCE;
            default -> NORTH_FENCE;
        };
    }
    @Override
    public void neighborChanged(
            BlockState state, Level level, BlockPos pos,
            Block neighborBlock, BlockPos neighborPos, boolean movedByPiston
    ) {
        if (isEmpty(state)) level.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }

    public static boolean isEmpty (BlockState state) {
        boolean safe = false;
        for (Direction dir : BlockStateProperties.HORIZONTAL_FACING.getPossibleValues()) {
            safe |= state.getValue(fromDirection(dir));
        }
        return !safe;
    }

    // Add the getRotatedBlockState method
    public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) {
        if (targetedFace.getAxis() == Direction.Axis.Y) {
            int state =
                    (originalState.getValue(NORTH_FENCE) ? 8 : 0) +
                            (originalState.getValue(EAST_FENCE)  ? 4 : 0) +
                            (originalState.getValue(SOUTH_FENCE) ? 2 : 0) +
                            (originalState.getValue(WEST_FENCE)  ? 1 : 0);
            return originalState
                    .setValue(NORTH_FENCE, (state & 1) == 1)
                    .setValue(EAST_FENCE,  (state & 8) == 8)
                    .setValue(SOUTH_FENCE, (state & 4) == 4)
                    .setValue(WEST_FENCE,  (state & 2) == 2);
        }
        return originalState;
    }
    private static boolean isRailing(ItemStack itemStack) {
        return itemStack.getItem() instanceof BlockItem && ((BlockItem) itemStack.getItem()).getBlock() instanceof railingblock;
    }

    private static boolean isRailing(Block block) {
        return block instanceof railingblock;
    }

    @MethodsReturnNonnullByDefault
    public static class RailingHelper implements IPlacementHelper {
        @Override
        public Predicate<ItemStack> getItemPredicate () {
            return railingblock::isRailing;
        }


        @Override
        public Predicate<BlockState> getStatePredicate() {
            return state -> railingblock.isRailing(state.getBlock());
        }

        @Override
        public PlacementOffset getOffset (
                Player player, Level world, BlockState state, BlockPos pos, BlockHitResult ray
        ) {
            Direction face = ray.getDirection();
            BlockState adjacent = world.getBlockState(pos.relative(face));
            if (railingblock.isRailing(adjacent.getBlock())) {
                pos = pos.relative(face);
                state = adjacent;
            }

            boolean railMatchTest = player.isHolding(state.getBlock().asItem());

            if (!railingblock.isRailing(state.getBlock()) ||
                    (state.getValue(railingblock.NORTH_FENCE)
                            && state.getValue(railingblock.SOUTH_FENCE)
                            && state.getValue(railingblock.EAST_FENCE)
                            && state.getValue(railingblock.WEST_FENCE)) || !railMatchTest) {
                return PlacementOffset.fail();
            }

            List<Direction> dirs = IPlacementHelper.orderedByDistanceExceptAxis(
                    pos, ray.getLocation(), Direction.Axis.Y
            );
            for (Direction offset : dirs) {
                if (!state.getValue(railingblock.fromDirection(offset))) {
                    state = state.setValue(railingblock.fromDirection(offset), true);
                    break;
                }
            }

            BlockState finalState = state;
            return PlacementOffset.success(pos, newState -> finalState).withGhostState(finalState);
        }

    }

}
