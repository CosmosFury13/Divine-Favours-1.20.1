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
                .add(blockregistry.UNCUT_SAPPHIRE_PILLAR.get(),
                        blockregistry.UNCUT_RUBY_PILLAR.get(),
                        blockregistry.UNCUT_JADE_PILLAR.get(),
                        blockregistry.UNCUT_TOPAZ_PILLAR.get(),
                        blockregistry.UNCUT_SAPPHIRE_NODE.get(),
                        blockregistry.UNCUT_MOONSTONE_PILLAR.get(),
                        blockregistry.UNCUT_MOONSTONE_NODE.get(),
                        blockregistry.UNCUT_RUBY_NODE.get(),
                        blockregistry.UNCUT_JADE_NODE.get(),
                        blockregistry.UNCUT_TOPAZ_NODE.get(),
                        blockregistry.MITHRIL_ORE.get(),
                        blockregistry.DEEPSLATE_MITHRIL_ORE.get(),
                        blockregistry.MITHRIL_BLOCK.get(),
                        blockregistry.RAW_MITHRIL_BLOCK.get(),
                        blockregistry.BRAZIER_MITHRIL.get(),
                        blockregistry.BRAZIER_ASTRALITE.get(),
                        blockregistry.BRAZIER_GLEAMIUM.get(),
                        blockregistry.BRAZIER_KYBER.get(),
                        blockregistry.BRAZIER_ORICHALCUM.get(),
                        blockregistry.BRAZIER_PROMETHEUM.get(),
                        blockregistry.BRAZIER_QUASARITE.get(),
                        blockregistry.BRAZIER_WYRMSTONE.get(),
                        blockregistry.ORICHALCUM_BLOCK.get(),
                        blockregistry.ASTRALITE_BLOCK.get(),
                        blockregistry.RAW_ASTRALITE_BLOCK.get(),
                        blockregistry.GLEAMIUM_BLOCK.get(),
                        blockregistry.RAW_GLEAMIUM_BLOCK.get(),
                        blockregistry.KYBER_BLOCK.get(),
                        blockregistry.KYBER_ORE.get(),
                        blockregistry.RAW_KYBER_BLOCK.get(),
                        blockregistry.ORICHALCUM_ORE.get(),
                        blockregistry.RAW_ORICHALCUM_BLOCK.get(),
                        blockregistry.PROMETHEUM_BLOCK.get(),
                        blockregistry.PROMETHEUM_ORE.get(),
                        blockregistry.RAW_PROMETHEUM_BLOCK.get(),
                        blockregistry.QUASARITE_BLOCK.get(),
                        blockregistry.WYRMSTONE_BLOCK.get(),
                        blockregistry.SAPPHIRE_ALTAR.get(),
                        blockregistry.RUBY_ALTAR.get(),
                        blockregistry.JADE_ALTAR.get(),
                        blockregistry.TOPAZ_ALTAR.get(),
                        blockregistry.CROWN_ALTAR.get(),
                        blockregistry.TABLET_STAND.get(),
                        blockregistry.SILVER_ORE.get(),
                        blockregistry.DEEPSLATE_SILVER_ORE.get(),
                        blockregistry.SILVER_BLOCK.get(),
                        blockregistry.RAW_SILVER_BLOCK.get(),
                        blockregistry.SILVER_KALVIS_ALTAR.get(),
                        blockregistry.PROMETHEUM_KALVIS_ALTAR.get(),
                        blockregistry.GLEAMIUM_KALVIS_ALTAR.get(),
                        blockregistry.JANUS_TABLE.get(),
                        blockregistry.GRECO_RAILING.get(),
                        blockregistry.GRECO_STAIRS.get(),
                        blockregistry.WOODFIRE_OVEN.get()
                );



        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        blockregistry.UNCUT_SAPPHIRE_PILLAR.get(),
                        blockregistry.UNCUT_RUBY_PILLAR.get(),
                        blockregistry.UNCUT_SAPPHIRE_NODE.get(),
                        blockregistry.UNCUT_MOONSTONE_PILLAR.get(),
                        blockregistry.UNCUT_MOONSTONE_NODE.get(),
                        blockregistry.UNCUT_RUBY_NODE.get(),
                        blockregistry.UNCUT_JADE_NODE.get(),
                        blockregistry.UNCUT_TOPAZ_NODE.get(),
                        blockregistry.UNCUT_JADE_PILLAR.get(),
                        blockregistry.UNCUT_TOPAZ_PILLAR.get(),
                        blockregistry.BRAZIER_MITHRIL.get(),
                        blockregistry.BRAZIER_ASTRALITE.get(),
                        blockregistry.BRAZIER_GLEAMIUM.get(),
                        blockregistry.BRAZIER_KYBER.get(),
                        blockregistry.BRAZIER_ORICHALCUM.get(),
                        blockregistry.BRAZIER_PROMETHEUM.get(),
                        blockregistry.BRAZIER_QUASARITE.get(),
                        blockregistry.BRAZIER_WYRMSTONE.get(),
                        blockregistry.RAW_MITHRIL_BLOCK.get(),
                        blockregistry.PROMETHEUM_BLOCK.get(),
                        blockregistry.PROMETHEUM_ORE.get(),
                        blockregistry.RAW_PROMETHEUM_BLOCK.get(),
                        blockregistry.QUASARITE_BLOCK.get(),
                        blockregistry.WYRMSTONE_BLOCK.get(),
                        blockregistry.ASTRALITE_BLOCK.get(),
                        blockregistry.RAW_ASTRALITE_BLOCK.get(),
                        blockregistry.SAPPHIRE_ALTAR.get(),
                        blockregistry.RUBY_ALTAR.get(),
                        blockregistry.JADE_ALTAR.get(),
                        blockregistry.TOPAZ_ALTAR.get(),
                        blockregistry.CROWN_ALTAR.get(),
                        blockregistry.TABLET_STAND.get(),
                        blockregistry.SILVER_ORE.get(),
                        blockregistry.DEEPSLATE_SILVER_ORE.get(),
                        blockregistry.SILVER_BLOCK.get(),
                        blockregistry.RAW_SILVER_BLOCK.get(),
                        blockregistry.SILVER_KALVIS_ALTAR.get(),
                        blockregistry.PROMETHEUM_KALVIS_ALTAR.get(),
                        blockregistry.GLEAMIUM_KALVIS_ALTAR.get(),
                        blockregistry.JANUS_TABLE.get(),
                        blockregistry.GRECO_RAILING.get()
                );


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        blockregistry.DEEPSLATE_MITHRIL_ORE.get(),
                        blockregistry.MITHRIL_BLOCK.get(),
                        blockregistry.MITHRIL_ORE.get(),
                        blockregistry.ORICHALCUM_BLOCK.get(),
                        blockregistry.GLEAMIUM_BLOCK.get(),
                        blockregistry.RAW_GLEAMIUM_BLOCK.get(),
                        blockregistry.KYBER_BLOCK.get(),
                        blockregistry.KYBER_ORE.get(),
                        blockregistry.RAW_KYBER_BLOCK.get(),
                        blockregistry.ORICHALCUM_ORE.get(),
                        blockregistry.RAW_ORICHALCUM_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(blockregistry.GRECO_STAIRS.get())
                .add(blockregistry.WOODFIRE_OVEN.get())
                ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                ;

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(blockregistry.OLIVE_LOG.get())
                .add(blockregistry.OLIVE_WOOD.get())
                .add(blockregistry.STRIPPED_OLIVE_LOG.get())
                .add(blockregistry.STRIPPED_OLIVE_WOOD.get())
                .add(blockregistry.OLIVE_BEAM.get());

        this.tag(BlockTags.PLANKS)
                .add(blockregistry.OLIVE_PLANKS.get());


        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(blockregistry.OLIVE_LOG.get())
                .add(blockregistry.OLIVE_WOOD.get())
                .add(blockregistry.STRIPPED_OLIVE_LOG.get())
                .add(blockregistry.STRIPPED_OLIVE_WOOD.get())
                .add(blockregistry.OLIVE_BEAM.get())
                .add(blockregistry.OLIVE_PLANKS.get());


    }
}