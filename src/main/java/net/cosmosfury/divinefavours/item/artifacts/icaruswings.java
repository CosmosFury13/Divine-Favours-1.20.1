package net.cosmosfury.divinefavours.item.artifacts;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class icaruswings extends ElytraItem {
    public icaruswings(Properties pProperties) {
        super(pProperties);
    }
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(Items.FEATHER);
    }




}
