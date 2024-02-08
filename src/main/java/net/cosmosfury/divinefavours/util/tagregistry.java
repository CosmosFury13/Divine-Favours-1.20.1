package net.cosmosfury.divinefavours.util;

import net.cosmosfury.divinefavours.DivineFavours;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class tagregistry {
    public static class Blocks {
        public static final TagKey<Block> TUNING_FORK_VALUABLES = tag("tuning_fork_valuables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DivineFavours.MOD_ID, name));
        }

    }


    public static class Items {




    }
    private static TagKey<Item> tag(String name) {
        return ItemTags.create(new ResourceLocation(DivineFavours.MOD_ID, name));
    }
}
