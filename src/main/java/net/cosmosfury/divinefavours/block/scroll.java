package net.cosmosfury.divinefavours.block;

import com.simibubi.create.foundation.placement.PlacementHelpers;
import net.cosmosfury.divinefavours.item.itemregistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class scroll extends HorizontalDirectionalBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final BooleanProperty WRITTEN = BooleanProperty.create("written");

    public scroll(BlockBehaviour.Properties props) {
        super(props);
        this.registerDefaultState(this.defaultBlockState().setValue(OPEN, true));
    }

    private static final VoxelShape VOXEL_OPEN = Block.box(
            0.5d, 0.5d, 14.5d,
            15.5d, 15.5d, 16d
    );

    private static final VoxelShape VOXEL_CLOSED = Block.box(
            0.5d, 6d, 14d,
            15.5d, 10d, 16d
    );

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(OPEN);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext ctx) {
        return getInteractionShape(state, reader, pos);
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        VoxelShape shape = Shapes.empty();
        if (state.getValue(OPEN)) shape = Shapes.join(shape, VOXEL_OPEN, BooleanOp.OR);
        if (!state.getValue(OPEN)) shape = Shapes.join(shape, VOXEL_CLOSED, BooleanOp.OR);

        return shape;
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            if (pPlayer.isShiftKeyDown() && pHand == InteractionHand.MAIN_HAND && pState.getValue(OPEN)) {
                BlockState closedstate = pState.setValue(OPEN, false);
                pLevel.playSound(null, pPos, SoundEvents.BOOK_PAGE_TURN, SoundSource.BLOCKS);
                pLevel.setBlock(pPos, closedstate, 3);
                return InteractionResult.SUCCESS;
            } else if (pPlayer.isShiftKeyDown() && pHand == InteractionHand.MAIN_HAND && !pState.getValue(OPEN)) {
                BlockState openstate = pState.setValue(OPEN, true);
                pLevel.playSound(null, pPos, SoundEvents.BOOK_PAGE_TURN, SoundSource.BLOCKS);
                pLevel.setBlock(pPos, openstate, 3);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(OPEN, true);
    }
}
