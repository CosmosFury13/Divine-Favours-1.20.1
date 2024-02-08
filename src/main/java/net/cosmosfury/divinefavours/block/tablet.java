package net.cosmosfury.divinefavours.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class tablet extends HorizontalDirectionalBlock {

    // You may need to adjust the constructor based on your needs
    public tablet() {
        super(Properties.of()
                .strength(3.0F, 3.0F)
                .noOcclusion()
                .isViewBlocking((state, world, pos) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isRedstoneConductor((state, world, pos) -> false)
                .sound(SoundType.DEEPSLATE_TILES));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }


}

