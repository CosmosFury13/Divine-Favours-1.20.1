package net.cosmosfury.divinefavours.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class gemtorchblock extends gemrodblock {
    public gemtorchblock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.UP));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction $$1 = pContext.getClickedFace();
        BlockState $$2 = pContext.getLevel().getBlockState(pContext.getClickedPos().relative($$1.getOpposite()));
        return $$2.is(this) && $$2.getValue(FACING) == $$1 ? (BlockState)this.defaultBlockState().setValue(FACING, $$1.getOpposite()) : (BlockState)this.defaultBlockState().setValue(FACING, $$1);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        Direction $$4 = (Direction)pState.getValue(FACING);
        double $$5 = (double)pPos.getX() + 0.55 - (double)(pRandom.nextFloat() * 0.1F);
        double $$6 = (double)pPos.getY() + 0.55 - (double)(pRandom.nextFloat() * 0.1F);
        double $$7 = (double)pPos.getZ() + 0.55 - (double)(pRandom.nextFloat() * 0.1F);
        double $$8 = (double)(0.4F - (pRandom.nextFloat() + pRandom.nextFloat()) * 0.4F);
        if (pRandom.nextInt(5) == 0) {
            pLevel.addParticle(ParticleTypes.END_ROD, $$5 + (double)$$4.getStepX() * $$8, $$6 + (double)$$4.getStepY() * $$8, $$7 + (double)$$4.getStepZ() * $$8, pRandom.nextGaussian() * 0.005, pRandom.nextGaussian() * 0.005, pRandom.nextGaussian() * 0.005);
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING});
    }}
