package net.cosmosfury.divinefavours.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class gemrodblock extends DirectionalBlock {
    protected static final float AABB_MIN = 6.0F;
    protected static final float AABB_MAX = 10.0F;
    protected static final VoxelShape UP_AABB = Block.box(6.0, 0.0, 6.0, 10.0, 10.0, 10.0);
    protected static final VoxelShape DOWN_AABB = Block.box(6.0, 6.0, 6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape WEST_AABB = Block.box(11.0, 3.0, 5.5, 16.0, 13.0, 10.5);
    protected static final VoxelShape EAST_AABB = Block.box(0.0, 3.0, 5.5, 5.0, 13.0, 10.5);

    protected static final VoxelShape NORTH_AABB = Block.box(5.5, 3.0, 11.0, 10.5, 13.0, 16.0);
    protected static final VoxelShape SOUTH_AABB = Block.box(5.5, 3.0, 0.0, 10.5, 13.0, 5.0);
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0);


    public gemrodblock(BlockBehaviour.Properties p_154339_) {
        super(p_154339_);
    }

    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        Direction facing = p_154346_.getValue(FACING);

        switch (facing) {
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case UP:
                return UP_AABB;
            case DOWN:
                return DOWN_AABB;
            default:
                return X_AXIS_AABB; // Default to X_AXIS_AABB if facing direction is not recognized
        }
    }

    public BlockState rotate(BlockState p_154354_, Rotation p_154355_) {
        return (BlockState)p_154354_.setValue(FACING, p_154355_.rotate((Direction)p_154354_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_154351_, Mirror p_154352_) {
        return (BlockState)p_154351_.setValue(FACING, p_154352_.mirror((Direction)p_154351_.getValue(FACING)));
    }

    public boolean isPathfindable(BlockState p_154341_, BlockGetter p_154342_, BlockPos p_154343_, PathComputationType p_154344_) {
        return false;
    }
}
