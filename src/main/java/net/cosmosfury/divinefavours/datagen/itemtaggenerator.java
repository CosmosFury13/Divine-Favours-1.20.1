package net.cosmosfury.divinefavours.datagen;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.block.blockregistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class itemtaggenerator extends ItemTagsProvider {
    public itemtaggenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, DivineFavours.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(ItemTags.PLANKS)
                .add(blockregistry.OLIVE_PLANKS.get().asItem())
                .add(blockregistry.HAWTHORNE_PLANKS.get().asItem());

    }
}
