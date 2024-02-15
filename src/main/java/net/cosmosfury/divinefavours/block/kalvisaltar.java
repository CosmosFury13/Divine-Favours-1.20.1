package net.cosmosfury.divinefavours.block;

import net.cosmosfury.divinefavours.item.itemregistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class kalvisaltar extends HorizontalDirectionalBlock {
    private static final BooleanProperty CHISEL = BooleanProperty.create("chisel");
    private static final BooleanProperty SAW = BooleanProperty.create("saw");
    private static final BooleanProperty HAMMER = BooleanProperty.create("hammer");

    public kalvisaltar() {
        super(Properties.of()
                .strength(3.0F, 3.0F)
                .noOcclusion()
                .isViewBlocking((state, world, pos) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isRedstoneConductor((state, world, pos) -> false)
                .sound(SoundType.DEEPSLATE_TILES));
        this.registerDefaultState(this.stateDefinition.any().setValue(CHISEL, false).setValue(SAW, false).setValue(HAMMER, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(CHISEL).add(SAW).add(HAMMER);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(CHISEL, false)
                .setValue(SAW, false).setValue(HAMMER, false);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        // Get the item in the player's hand
        ItemStack heldItem = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide()) {
            if (heldItem.getItem() == itemregistry.SAW.get() && pHand == InteractionHand.MAIN_HAND && !pState.getValue(SAW) && !pState.getValue(CHISEL) && !pState.getValue(HAMMER)) {
                // Right-clicked with saw, and saw property is false
                BlockState sawstate = pState.setValue(SAW, true);

                // Consume 1 saw (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    heldItem.shrink(1);
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, sawstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
            else if (heldItem.getItem() == itemregistry.CHISEL.get() && pHand == InteractionHand.MAIN_HAND && !pState.getValue(CHISEL) && !pState.getValue(SAW) && !pState.getValue(HAMMER)) {
                // Right-clicked with chisel, and chisel property is false
                BlockState chiselstate = pState.setValue(CHISEL, true);

                // Consume 1 chisel (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    heldItem.shrink(1);
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, chiselstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
            else if (heldItem.getItem() == itemregistry.HAMMER.get() && pHand == InteractionHand.MAIN_HAND && !pState.getValue(CHISEL) && !pState.getValue(SAW) && !pState.getValue(HAMMER)) {
                // Right-clicked with chisel, and chisel property is false
                BlockState hammerstate = pState.setValue(HAMMER, true);

                // Consume 1 chisel (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    heldItem.shrink(1);
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, hammerstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
            else if (heldItem.isEmpty() && pHand == InteractionHand.MAIN_HAND && pState.getValue(CHISEL)) {
                // Set SNUFF to false
                BlockState chiselstate = pState.setValue(CHISEL, false);


                // Give 1 snuffer back to the player (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    pPlayer.addItem(itemregistry.CHISEL.get().getDefaultInstance());
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, chiselstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
            else if (heldItem.isEmpty() && pHand == InteractionHand.MAIN_HAND && pState.getValue(SAW)) {
                // Set SNUFF to false
                BlockState sawstate = pState.setValue(SAW, false);


                // Give 1 snuffer back to the player (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    pPlayer.addItem(itemregistry.SAW.get().getDefaultInstance());
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, sawstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
            else if (heldItem.isEmpty() && pHand == InteractionHand.MAIN_HAND && pState.getValue(HAMMER)) {
                // Set SNUFF to false
                BlockState hammerstate = pState.setValue(HAMMER, false);


                // Give 1 snuffer back to the player (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    pPlayer.addItem(itemregistry.HAMMER.get().getDefaultInstance());
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, hammerstate, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

    }
}

