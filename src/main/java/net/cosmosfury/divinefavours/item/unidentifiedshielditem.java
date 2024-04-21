package net.cosmosfury.divinefavours.item;

import net.cosmosfury.divinefavours.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class unidentifiedshielditem extends Item {

    public unidentifiedshielditem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            randomizeShield(stack, player, hand, world);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void randomizeShield(ItemStack stack, Player player, InteractionHand hand, Level world) {
        ResourceLocation[] shields = new ResourceLocation[]{
                new ResourceLocation("minecraft:shield"),
                // Add more shield resource locations as needed
        };

        Random rand = new Random();
        ResourceLocation randomShield = shields[rand.nextInt(shields.length)];

        stack = new ItemStack(ForgeRegistries.ITEMS.getValue(randomShield));
        player.setItemInHand(hand, stack);

        // Play identification sound
        SoundEvent soundEvent = SoundEvents.ANVIL_LAND;
        world.playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, SoundSource.PLAYERS, 0.3F, 1.0F);
    }

}
