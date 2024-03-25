package net.cosmosfury.divinefavours.item.artifacts;

import net.minecraft.world.item.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class icaruswing2 extends ElytraItem {

    public icaruswing2(Properties pProperties) {
        super(pProperties);
    }

    protected void upwardsFlight(Player player) {
        double acceleration = sigmoidAcceleration(player.tickCount, 5.0, 1.0, 2.0);
        acceleration /= 25.0f;
        player.addDeltaMovement(new Vec3(0, Math.max(0.0025, acceleration), 0));
        player.fallDistance = Math.max(player.fallDistance / 1.5f, 0.0f);
    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (!(entity instanceof Player player)) return;
        if (player.getItemBySlot(EquipmentSlot.CHEST) != stack) return;

        if (player.getAbilities().flying) return;
        if (player.getCooldowns().isOnCooldown(stack.getItem())) return;

        if (!KeybindManager.suitFlightEnabled(player)) return;
        if (!KeybindManager.jumpDown(player)) return;
        if (!canFly(player, stack)) return;

        if (KeybindManager.sprintDown(player)) {
            fullFlight(player);
            consume(player, stack, 100);
        } else {
            upwardsFlight(player);
            consume(player, stack, 50);
        }
    }
    private void consume(Player player, ItemStack stack, int amount) {
        if (player.isCreative() || player.isSpectator() || player.level().isClientSide()) return;
        getEnergyStorage(stack).internalExtract(amount, false);
    }
    @Override
    public WrappedItemEnergyContainer getEnergyStorage(ItemStack holder) {
        return new WrappedItemEnergyContainer(
                holder,
                new SimpleEnergyContainer(energyCapacity) {
                    @Override
                    public long maxInsert() {
                        return 1000;
                    }
                });
    }
    private boolean canFly(Player player, ItemStack stack) {
        return player.isCreative();
    }
    public static double sigmoidAcceleration(double t, double peakTime, double peakAcceleration, double initialAcceleration) {
        return ((2 * peakAcceleration) / (1 + Math.exp(-t / peakTime)) - peakAcceleration) + initialAcceleration;
    }
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
                }
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }

    @SuppressWarnings("unused") // Forge
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return entity instanceof Player player && canFly(player, stack);
    }


}
