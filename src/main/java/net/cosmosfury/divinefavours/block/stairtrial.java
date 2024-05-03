package net.cosmosfury.divinefavours.block;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class stairtrial extends StairBlock implements IWrenchable{
    public static final BooleanProperty RAILING_LEFT = BooleanProperty.create("railing_left");
    public static final BooleanProperty RAILING_RIGHT = BooleanProperty.create("railing_right");

    public stairtrial(BlockState pBaseState, Properties pProperties) {
        super(pBaseState, pProperties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .setValue(BlockStateProperties.WATERLOGGED, false)
                .setValue(RAILING_LEFT, false)
                .setValue(RAILING_RIGHT, false));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, HALF, SHAPE, WATERLOGGED, RAILING_LEFT, RAILING_RIGHT);
    }
    @Override
    public boolean canPlaceLiquid(BlockGetter world, BlockPos pos, BlockState state, Fluid fluid) {
        return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
        BlockState blockstate = this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection()).setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(pContext.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? Half.BOTTOM : Half.TOP).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
        return blockstate.setValue(SHAPE, getStairsShape(blockstate, pContext.getLevel(), blockpos));
    }
    private static StairsShape getStairsShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));
        if (isStairs(blockstate) && pState.getValue(HALF) == blockstate.getValue(HALF)) {
            Direction direction1 = blockstate.getValue(FACING);
            if (direction1.getAxis() != pState.getValue(FACING).getAxis() && canTakeShape(pState, pLevel, pPos, direction1.getOpposite())) {
                if (direction1 == direction.getCounterClockWise()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = pLevel.getBlockState(pPos.relative(direction.getOpposite()));
        if (isStairs(blockstate1) && pState.getValue(HALF) == blockstate1.getValue(HALF)) {
            Direction direction2 = blockstate1.getValue(FACING);
            if (direction2.getAxis() != pState.getValue(FACING).getAxis() && canTakeShape(pState, pLevel, pPos, direction2)) {
                if (direction2 == direction.getCounterClockWise()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }
    private static boolean canTakeShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFace) {
        BlockState blockstate = pLevel.getBlockState(pPos.relative(pFace));
        return !isStairs(blockstate) || blockstate.getValue(FACING) != pState.getValue(FACING) || blockstate.getValue(HALF) != pState.getValue(HALF);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);

        // Check if the item in hand is LIMESTONE_SIMPLE_RAILING block item
        if (stack.getItem() instanceof BlockItem && ((BlockItem) stack.getItem()).getBlock() == blockregistry.LIMESTONE_SIMPLE_RAILING.get()) {
            if (state.getValue(BlockStateProperties.HALF) == Half.BOTTOM) {
                // Check if the stairs are straight
                if (state.getValue(BlockStateProperties.STAIRS_SHAPE) == StairsShape.STRAIGHT) {

                    Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    Direction topFace = Direction.UP;

                    Vec3 hitVec = hitResult.getLocation();
                    Vec3 blockPosVec = Vec3.atLowerCornerOf(pos).add(0.5, 0.5, 0.5);
                    Vec3 hitRelativeVec = hitVec.subtract(blockPosVec);

                    boolean isTopLeft = false;
                    boolean isTopRight = false;

                    // Determine if the click was on the left or right side of the top face of the block
                    if (facing == Direction.NORTH && state.getValue(BlockStateProperties.STAIRS_SHAPE) == StairsShape.STRAIGHT) {
                        isTopLeft = hitRelativeVec.x < 0;
                        isTopRight = hitRelativeVec.x > 0;
                    }
                    if (facing == Direction.EAST && state.getValue(BlockStateProperties.STAIRS_SHAPE) == StairsShape.STRAIGHT) {
                        isTopLeft = hitRelativeVec.z < 0;
                        isTopRight = hitRelativeVec.z > 0;
                    }
                    if (facing == Direction.SOUTH && state.getValue(BlockStateProperties.STAIRS_SHAPE) == StairsShape.STRAIGHT) {
                        isTopLeft = hitRelativeVec.x > 0;
                        isTopRight = hitRelativeVec.x < 0;
                    }
                    if (facing == Direction.WEST && state.getValue(BlockStateProperties.STAIRS_SHAPE) == StairsShape.STRAIGHT) {
                        isTopLeft = hitRelativeVec.z > 0;
                        isTopRight = hitRelativeVec.z < 0;
                    }

                    // Set the appropriate railing property based on the click side
                    if (isTopLeft) {
                        level.setBlock(pos, state.setValue(RAILING_LEFT, true), 3);
                    } else if (isTopRight) {
                        level.setBlock(pos, state.setValue(RAILING_RIGHT, true), 3);
                    }

                    // If the player doesn't have instabuild, decrement the item stack size
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }
}
