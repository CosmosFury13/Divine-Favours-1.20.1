package net.cosmosfury.divinefavours.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Nullable;

public class log extends RotatedPillarBlock {
    public log(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(blockregistry.OLIVE_LOG.get())) {
                return blockregistry.STRIPPED_OLIVE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(blockregistry.OLIVE_WOOD.get())) {
                return blockregistry.STRIPPED_OLIVE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(blockregistry.HAWTHORNE_LOG.get())) {
                return blockregistry.STRIPPED_HAWTHORNE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(blockregistry.HAWTHORNE_WOOD.get())) {
                return blockregistry.STRIPPED_HAWTHORNE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
