package net.cosmosfury.divinefavours.block;

import net.cosmosfury.divinefavours.item.itemregistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class brazier extends Block {
    // Define boolean properties for block state
    public static final BooleanProperty LIT = BooleanProperty.create("lit");
    public static final BooleanProperty SNUFF = BooleanProperty.create("snuff");
    private final int fireDamage;

    // Constructor for the brazier block
    public brazier(Properties properties, int pFireDamage) {
        // Call the super constructor with provided properties
        super(properties);
        this.fireDamage = pFireDamage;

        // Register default block state with initial values for properties
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(SNUFF, false));
    }

    // Method to define block state properties
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT).add(SNUFF);
    }

    // Method called when the block is right-clicked
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        // Get the item in the player's hand
        ItemStack heldItem = pPlayer.getItemInHand(pHand);

        // Check if the world is not on the client side
        if (!pLevel.isClientSide()) {
            // Check if right-clicked with an empty hand and snuff is true
            if (heldItem.isEmpty() && pHand == InteractionHand.MAIN_HAND && pState.getValue(SNUFF)) {
                // Set SNUFF to false
                BlockState extinguishedState = pState.setValue(SNUFF, false);

                // Play wood break sound effect
                pLevel.playSound(null, pPos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS);

                // Give 1 snuffer back to the player (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    pPlayer.addItem(itemregistry.SNUFFER.get().getDefaultInstance());
                }

                // Set the block to the new state
                pLevel.setBlock(pPos, extinguishedState, 3);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            } else if (heldItem.getItem() == itemregistry.KINDLING.get() && pHand == InteractionHand.MAIN_HAND) {
                // Check if the flint and steel has durability
                if (pPlayer.isCreative() || heldItem.getDamageValue() < heldItem.getMaxDamage()) {
                    // Create a new BlockState with LIT set to true
                    BlockState litState = pState.setValue(LIT, true);

                    // Check if snuff is false before setting the block to the new lit state
                    if (!pState.getValue(SNUFF)) {
                        // Set the block to the new lit state
                        pLevel.setBlock(pPos, litState, 3);

                        pLevel.playSound(null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS);

                        // Consume durability from the flint and steel
                        if (!pPlayer.isCreative()) {
                            heldItem.hurtAndBreak(1, pPlayer, playerEntity -> playerEntity.broadcastBreakEvent(pHand));
                        }

                        // Return success
                        return InteractionResult.SUCCESS;
                    }
                }
            } else if (heldItem.getItem() == itemregistry.SNUFFER.get() && (pState.getValue(LIT) || !pState.getValue(SNUFF)) && pHand == InteractionHand.MAIN_HAND) {
                // Right-clicked with snuffer, and the brazier is lit or not snuffed
                BlockState extinguishedState = pState.setValue(LIT, false).setValue(SNUFF, true);

                // Consume 1 snuffer (if not in creative mode)
                if (!pPlayer.isCreative()) {
                    heldItem.shrink(1);
                }

                // Set the block to the new extinguished state
                pLevel.setBlock(pPos, extinguishedState, 3);
                pLevel.playSound(null, pPos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS);

                // Return success for right-click
                return InteractionResult.SUCCESS;
            }
        }

        // Call the super method if the conditions are not met
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    // Method called to play fire sounds

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            if (pRandom.nextInt(6) == 0) {
                pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.9F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.6F, false);
            }

        }
    }


    // Method to handle entities inside the block
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pState.getValue(LIT) && pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity)) {
            pEntity.hurt(pLevel.damageSources().inFire(), (float)this.fireDamage);
        }

        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
