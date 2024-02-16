package net.cosmosfury.divinefavours.block;

import net.cosmosfury.divinefavours.item.itemregistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.cosmosfury.divinefavours.block.brazier.LIT;
import static net.minecraft.world.level.block.Blocks.DEEPSLATE_TILES;

public class janustable extends HorizontalDirectionalBlock {
    private static final BooleanProperty CRYSTAL = BooleanProperty.create("crystal");

    // You may need to adjust the constructor based on your needs
    public janustable() {
        super(Properties.of()
                .strength(3.0F, 3.0F)
                .noOcclusion()
                .isViewBlocking((state, world, pos) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isRedstoneConductor((state, world, pos) -> false)
                .sound(SoundType.DEEPSLATE_TILES).lightLevel(state -> state.getValue(CRYSTAL) ? 15 : 0));
        this.registerDefaultState(this.stateDefinition.any().setValue(CRYSTAL, false).setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(CRYSTAL);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(CRYSTAL, false);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        // Get the item in the player's hand
        ItemStack heldItem = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide()) {
            if (heldItem.getItem() == itemregistry.UNCUT_JANUS_CRYSTAL.get() && pHand == InteractionHand.MAIN_HAND && !pState.getValue(CRYSTAL)) {
                // Right-clicked with saw, and saw property is false
                BlockState sawstate = pState.setValue(CRYSTAL, true);

                // Consume 1 saw (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    heldItem.shrink(1);
                }
                pLevel.playSound(null, pPos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS);

                // Set the block to the new state
                pLevel.setBlock(pPos, sawstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
            else if (heldItem.isEmpty() && pHand == InteractionHand.MAIN_HAND && pState.getValue(CRYSTAL)) {
                // Set SNUFF to false
                BlockState crystalstate = pState.setValue(CRYSTAL, false);


                // Give 1 snuffer back to the player (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    pPlayer.addItem(itemregistry.UNCUT_JANUS_CRYSTAL.get().getDefaultInstance());
                }
                pLevel.playSound(null, pPos, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS);

                // Set the block to the new state
                pLevel.setBlock(pPos, crystalstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

    }


}

