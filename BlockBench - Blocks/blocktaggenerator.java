package net.cosmosfury.divinefavours.datagen;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.block.blockregistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class blocktaggenerator extends BlockTagsProvider {
    public blocktaggenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DivineFavours.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(blockregistry.PROMETHEUM_BLOCK.get()
                        ,(blockregistry.GLEAMIUM_BLOCK.get()
                        ));


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(blockregistry.PROMETHEUM_BLOCK.get(),
                        (blockregistry.PROMETHEUM_ORE.get())
                        ,(blockregistry.JANUS_TABLE.get()));

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(blockregistry.GLEAMIUM_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                ;


    }
}