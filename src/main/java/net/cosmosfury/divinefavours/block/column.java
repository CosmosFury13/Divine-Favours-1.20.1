package net.cosmosfury.divinefavours.block;


import com.simibubi.create.content.kinetics.simpleRelays.AbstractSimpleShaftBlock;
import com.simibubi.create.foundation.placement.PlacementHelpers;
import com.simibubi.create.foundation.placement.PoleHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nullable;

public class column extends Block {

    private static final BooleanProperty TOP = BooleanProperty.create("top");
    private static final BooleanProperty BOTTOM = BooleanProperty.create("bottom"); // 1. Define bottom property
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public column(Properties Props) {
        super(Properties.of().mapColor(DyeColor.WHITE).requiresCorrectToolForDrops().strength(2F, 6.0F).sound(SoundType.DEEPSLATE).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(TOP, Boolean.valueOf(true)).setValue(BOTTOM, Boolean.valueOf(false)).setValue(FACING, Direction.UP)); // 3. Include bottom property in default state
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockpos = pos.relative(direction.getOpposite());
        return level.getBlockState(blockpos).isFaceSturdy(level, blockpos, direction);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        BlockState pillar = super.updateShape(state, direction, state1, levelAccessor, blockPos, blockPos1);
        if (levelAccessor.getBlockState(blockPos.relative(state.getValue(FACING))).getBlock() == this) {
            pillar = pillar.setValue(TOP, false);
        } else {
            pillar = pillar.setValue(TOP, true);
        }
        if (levelAccessor.getBlockState(blockPos.relative(state.getValue(FACING).getOpposite())).getBlock() == this) {
            pillar = pillar.setValue(BOTTOM, false); // Set bottom to false if adjacent block is pillar
        } else {
            pillar = pillar.setValue(BOTTOM, true); // Set bottom to true if adjacent block is not pillar
        }
        return pillar;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState above = levelaccessor.getBlockState(blockpos.relative(context.getClickedFace()));
        return this.defaultBlockState().setValue(TOP, above.getBlock() != this).setValue(BOTTOM, levelaccessor.getBlockState(blockpos.below()).getBlock() != this).setValue(FACING, context.getClickedFace()); // 4. Set bottom property based on block below
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(TOP, BOTTOM, FACING); // 4. Include bottom property in block state definition
    }

}
