package net.cosmosfury.divinefavours.item;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.block.blockregistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.CreativeModeTab;

import javax.swing.*;

import static net.cosmosfury.divinefavours.item.itemregistry.UNCUT_SAPPHIRE;

public class creativeregistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DivineFavours.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DIVINE_TAB = CREATIVE_MODE_TABS.register("divine_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(itemregistry.UNCUT_SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.divine_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(itemregistry.UNCUT_SAPPHIRE.get());
                        pOutput.accept(itemregistry.UNCUT_RUBY.get());
                        pOutput.accept(itemregistry.UNCUT_JADE.get());
                        pOutput.accept(itemregistry.UNCUT_TOPAZ.get());
                        pOutput.accept(itemregistry.UNCUT_MOONSTONE.get());
                        pOutput.accept(itemregistry.UNCUT_JANUS_CRYSTAL.get());
                        pOutput.accept(itemregistry.OLIVE_OIL.get());
                        pOutput.accept(itemregistry.OLIVE_RIPE.get());
                        pOutput.accept(itemregistry.FIG.get());
                        pOutput.accept(itemregistry.ORANGE.get());
                        pOutput.accept(itemregistry.LEMON.get());
                        pOutput.accept(itemregistry.WALNUT.get());
                        pOutput.accept(itemregistry.AUBERGINE.get());
                        pOutput.accept(itemregistry.CUCUMBER.get());
                        pOutput.accept(itemregistry.COFFEE_BEANS.get());
                        pOutput.accept(itemregistry.RAW_CALAMARI.get());
                        pOutput.accept(itemregistry.GRAPES.get());
                        pOutput.accept(itemregistry.CORN.get());
                        pOutput.accept(itemregistry.RAW_MITHRIL.get());
                        pOutput.accept(itemregistry.MITHRIL_INGOT.get());
                        pOutput.accept(itemregistry.MITHRIL_NUGGET.get());
                        pOutput.accept(itemregistry.CRUSHED_MITHRIL.get());
                        pOutput.accept(itemregistry.KINDLING.get());
                        pOutput.accept(itemregistry.SNUFFER.get());
                        pOutput.accept(itemregistry.ASTRALITE_INGOT.get());
                        pOutput.accept(itemregistry.ASTRALITE_NUGGET.get());
                        pOutput.accept(itemregistry.RAW_ASTRALITE.get());
                        pOutput.accept(itemregistry.GLEAMIUM_INGOT.get());
                        pOutput.accept(itemregistry.GLEAMIUM_NUGGET.get());
                        pOutput.accept(itemregistry.RAW_GLEAMIUM.get());
                        pOutput.accept(itemregistry.KYBER_NUGGET.get());
                        pOutput.accept(itemregistry.KYBER.get());
                        pOutput.accept(itemregistry.RAW_KYBER.get());
                        pOutput.accept(itemregistry.CRUSHED_KYBER.get());
                        pOutput.accept(itemregistry.ORICHALCUM_INGOT.get());
                        pOutput.accept(itemregistry.ORICHALCUM_NUGGET.get());
                        pOutput.accept(itemregistry.RAW_ORICHALCUM.get());
                        pOutput.accept(itemregistry.CRUSHED_ORICHALCUM.get());
                        pOutput.accept(itemregistry.PROMETHEUM_INGOT.get());
                        pOutput.accept(itemregistry.PROMETHEUM_NUGGET.get());
                        pOutput.accept(itemregistry.RAW_PROMETHEUM.get());
                        pOutput.accept(itemregistry.CRUSHED_PROMETHEUM.get());
                        pOutput.accept(itemregistry.QUASARITE_INGOT.get());
                        pOutput.accept(itemregistry.QUASARITE_NUGGET.get());
                        pOutput.accept(itemregistry.SILVER_DUST.get());
                        pOutput.accept(itemregistry.RAW_SILVER.get());
                        pOutput.accept(itemregistry.SILVER_INGOT.get());
                        pOutput.accept(itemregistry.SILVER_NUGGET.get());
                        pOutput.accept(itemregistry.CRUSHED_SILVER.get());
                        pOutput.accept(itemregistry.SALT.get());
                        pOutput.accept(itemregistry.MISTLETOE.get());
                        pOutput.accept(itemregistry.CHISEL.get());
                        pOutput.accept(itemregistry.SAW.get());
                        pOutput.accept(itemregistry.HAMMER.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_CHESTPLATE.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_HELMET.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_BOOTS.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_LEGGINGS.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_PICKAXE.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_SHIELD.get());
                        pOutput.accept(itemregistry.UNIDENTIFIED_SWORD.get());




                        pOutput.accept(blockregistry.UNCUT_SAPPHIRE_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_SAPPHIRE_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_RUBY_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_RUBY_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_JADE_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_TOPAZ_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_JADE_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_TOPAZ_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_MOONSTONE_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_MOONSTONE_NODE.get());
                        pOutput.accept(blockregistry.TABLET_STAND.get());
                        pOutput.accept(blockregistry.SAPPHIRE_ALTAR.get());
                        pOutput.accept(blockregistry.CROWN_ALTAR.get());
                        pOutput.accept(blockregistry.RUBY_ALTAR.get());
                        pOutput.accept(blockregistry.JADE_ALTAR.get());
                        pOutput.accept(blockregistry.TOPAZ_ALTAR.get());
                        pOutput.accept(blockregistry.LIMESTONE_STAIRS.get());
                        pOutput.accept(blockregistry.OLIVE_PLANKS.get());
                        pOutput.accept(blockregistry.STRIPPED_OLIVE_LOG.get());
                        pOutput.accept(blockregistry.OLIVE_WOOD.get());
                        pOutput.accept(blockregistry.STRIPPED_OLIVE_WOOD.get());
                        pOutput.accept(blockregistry.OLIVE_LOG.get());
                        pOutput.accept(blockregistry.OLIVE_LEAVES.get());
                        pOutput.accept(blockregistry.OLIVE_SAPLING.get());
                        pOutput.accept(blockregistry.OLIVE_BEAM.get());
                        pOutput.accept(blockregistry.OLIVE_PALISADE.get());
                        pOutput.accept(blockregistry.OLIVE_STAIRS.get());
                        pOutput.accept(blockregistry.OLIVE_SLAB.get());
                        pOutput.accept(blockregistry.OLIVE_BUTTON.get());
                        pOutput.accept(blockregistry.OLIVE_PRESSURE_PLATE.get());
                        pOutput.accept(blockregistry.OLIVE_FENCE.get());
                        pOutput.accept(blockregistry.OLIVE_FENCE_GATE.get());
                        pOutput.accept(blockregistry.OLIVE_DOOR.get());
                        pOutput.accept(blockregistry.OLIVE_TRAPDOOR.get());
                        pOutput.accept(blockregistry.HAWTHORNE_LOG.get());
                        pOutput.accept(blockregistry.STRIPPED_HAWTHORNE_LOG.get());
                        pOutput.accept(blockregistry.HAWTHORNE_LEAVES.get());
                        pOutput.accept(blockregistry.HAWTHORNE_SAPLING.get());
                        pOutput.accept(blockregistry.HAWTHORNE_WOOD.get());
                        pOutput.accept(blockregistry.STRIPPED_HAWTHORNE_WOOD.get());
                        pOutput.accept(blockregistry.HAWTHORNE_BEAM.get());
                        pOutput.accept(blockregistry.HAWTHORNE_PALISADE.get());
                        pOutput.accept(blockregistry.HAWTHORNE_STAIRS.get());
                        pOutput.accept(blockregistry.HAWTHORNE_SLAB.get());
                        pOutput.accept(blockregistry.HAWTHORNE_BUTTON.get());
                        pOutput.accept(blockregistry.HAWTHORNE_PRESSURE_PLATE.get());
                        pOutput.accept(blockregistry.HAWTHORNE_FENCE.get());
                        pOutput.accept(blockregistry.HAWTHORNE_FENCE_GATE.get());
                        pOutput.accept(blockregistry.HAWTHORNE_DOOR.get());
                        pOutput.accept(blockregistry.HAWTHORNE_TRAPDOOR.get());
                        pOutput.accept(blockregistry.HAWTHORNE_PLANKS.get());
                        pOutput.accept(blockregistry.BRAZIER_MITHRIL.get());
                        pOutput.accept(blockregistry.BRAZIER_PROMETHEUM.get());
                        pOutput.accept(blockregistry.BRAZIER_GLEAMIUM.get());
                        pOutput.accept(blockregistry.BRAZIER_KYBER.get());
                        pOutput.accept(blockregistry.BRAZIER_ORICHALCUM.get());
                        pOutput.accept(blockregistry.BRAZIER_ASTRALITE.get());
                        pOutput.accept(blockregistry.BRAZIER_QUASARITE.get());
                        pOutput.accept(blockregistry.MITHRIL_ORE.get());
                        pOutput.accept(blockregistry.DEEPSLATE_MITHRIL_ORE.get());
                        pOutput.accept(blockregistry.MITHRIL_BLOCK.get());
                        pOutput.accept(blockregistry.RAW_MITHRIL_BLOCK.get());
                        pOutput.accept(blockregistry.ORICHALCUM_BLOCK.get());
                        pOutput.accept(blockregistry.ASTRALITE_BLOCK.get());
                        pOutput.accept(blockregistry.RAW_ASTRALITE_BLOCK.get());
                        pOutput.accept(blockregistry.GLEAMIUM_BLOCK.get());
                        pOutput.accept(blockregistry.RAW_GLEAMIUM_BLOCK.get());
                        pOutput.accept(blockregistry.KYBER_BLOCK.get());
                        pOutput.accept(blockregistry.KYBER_ORE.get());
                        pOutput.accept(blockregistry.RAW_KYBER_BLOCK.get());
                        pOutput.accept(blockregistry.ORICHALCUM_ORE.get());
                        pOutput.accept(blockregistry.RAW_ORICHALCUM_BLOCK.get());
                        pOutput.accept(blockregistry.PROMETHEUM_BLOCK.get());
                        pOutput.accept(blockregistry.PROMETHEUM_ORE.get());
                        pOutput.accept(blockregistry.RAW_PROMETHEUM_BLOCK.get());
                        pOutput.accept(blockregistry.QUASARITE_BLOCK.get());
                        pOutput.accept(blockregistry.SILVER_ORE.get());
                        pOutput.accept(blockregistry.DEEPSLATE_SILVER_ORE.get());
                        pOutput.accept(blockregistry.SILVER_BLOCK.get());
                        pOutput.accept(blockregistry.RAW_SILVER_BLOCK.get());
                        pOutput.accept(blockregistry.MOUNTAIN_ASH.get());
                        pOutput.accept(blockregistry.SILVER_KALVIS_ALTAR.get());
                        pOutput.accept(blockregistry.PROMETHEUM_KALVIS_ALTAR.get());
                        pOutput.accept(blockregistry.GLEAMIUM_KALVIS_ALTAR.get());
                        pOutput.accept(blockregistry.JANUS_TABLE.get());
                        pOutput.accept(blockregistry.SCROLL.get());
                        pOutput.accept(blockregistry.SALT_BLOCK.get());
                        pOutput.accept(blockregistry.AMPHORA.get());
                        pOutput.accept(blockregistry.UNCUT_RUBY_TORCH.get());
                        pOutput.accept(blockregistry.UNCUT_JADE_TORCH.get());
                        pOutput.accept(blockregistry.UNCUT_SAPPHIRE_TORCH.get());
                        pOutput.accept(blockregistry.UNCUT_TOPAZ_TORCH.get());
                        pOutput.accept(blockregistry.UNCUT_MOONSTONE_TORCH.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_A.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_B.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_C.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_D.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_E.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_F.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_G.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_H.get());
                        pOutput.accept(blockregistry.ANDESITE_ARCHED_RAILING_I.get());

                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_A.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_B.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_C.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_D.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_E.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_F.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_G.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_H.get());
                        pOutput.accept(blockregistry.ANDESITE_GLASS_RAILING_I.get());

                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_A.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_B.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_C.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_D.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_E.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_F.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_G.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_H.get());
                        pOutput.accept(blockregistry.ANDESITE_SIMPLE_RAILING_I.get());

                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_A.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_B.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_C.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_D.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_E.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_F.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_G.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_H.get());
                        pOutput.accept(blockregistry.BRICK_ARCHED_RAILING_I.get());

                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_A.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_B.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_C.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_D.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_E.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_F.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_G.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_H.get());
                        pOutput.accept(blockregistry.BRICK_GLASS_RAILING_I.get());

                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_A.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_B.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_C.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_D.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_E.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_F.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_G.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_H.get());
                        pOutput.accept(blockregistry.BRICK_SIMPLE_RAILING_I.get());

                        pOutput.accept(blockregistry.DEEPSLATE_ARCHED_RAILING.get());
                        pOutput.accept(blockregistry.DEEPSLATE_ARCHED_RAILING_A.get());
                        pOutput.accept(blockregistry.DEEPSLATE_ARCHED_RAILING_B.get());
                        pOutput.accept(blockregistry.DEEPSLATE_ARCHED_RAILING_C.get());
                        pOutput.accept(blockregistry.DEEPSLATE_ARCHED_RAILING_D.get());

                        pOutput.accept(blockregistry.DEEPSLATE_GLASS_RAILING.get());
                        pOutput.accept(blockregistry.DEEPSLATE_GLASS_RAILING_A.get());
                        pOutput.accept(blockregistry.DEEPSLATE_GLASS_RAILING_B.get());
                        pOutput.accept(blockregistry.DEEPSLATE_GLASS_RAILING_C.get());
                        pOutput.accept(blockregistry.DEEPSLATE_GLASS_RAILING_D.get());

                        pOutput.accept(blockregistry.DEEPSLATE_SIMPLE_RAILING.get());
                        pOutput.accept(blockregistry.DEEPSLATE_SIMPLE_RAILING_A.get());
                        pOutput.accept(blockregistry.DEEPSLATE_SIMPLE_RAILING_B.get());
                        pOutput.accept(blockregistry.DEEPSLATE_SIMPLE_RAILING_C.get());
                        pOutput.accept(blockregistry.DEEPSLATE_SIMPLE_RAILING_D.get());

                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_A.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_B.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_C.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_D.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_E.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_F.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_G.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_H.get());
                        pOutput.accept(blockregistry.LIMESTONE_ARCHED_RAILING_I.get());

                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_A.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_B.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_C.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_D.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_E.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_F.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_G.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_H.get());
                        pOutput.accept(blockregistry.LIMESTONE_GLASS_RAILING_I.get());

                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_A.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_B.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_C.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_D.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_E.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_F.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_G.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_H.get());
                        pOutput.accept(blockregistry.LIMESTONE_SIMPLE_RAILING_I.get());

                        pOutput.accept(blockregistry.MUD_BRICK_ARCHED_RAILING.get());
                        pOutput.accept(blockregistry.MUD_BRICK_ARCHED_RAILING_A.get());


                        pOutput.accept(blockregistry.MUD_BRICK_GLASS_RAILING.get());
                        pOutput.accept(blockregistry.MUD_BRICK_GLASS_RAILING_A.get());


                        pOutput.accept(blockregistry.MUD_BRICK_SIMPLE_RAILING.get());
                        pOutput.accept(blockregistry.MUD_BRICK_SIMPLE_RAILING_A.get());


                        pOutput.accept(blockregistry.STONE_ARCHED_RAILING.get());
                        pOutput.accept(blockregistry.STONE_ARCHED_RAILING_A.get());
                        pOutput.accept(blockregistry.STONE_ARCHED_RAILING_B.get());
                        pOutput.accept(blockregistry.STONE_ARCHED_RAILING_C.get());
                        pOutput.accept(blockregistry.STONE_ARCHED_RAILING_D.get());
                        pOutput.accept(blockregistry.STONE_ARCHED_RAILING_E.get());

                        pOutput.accept(blockregistry.STONE_GLASS_RAILING.get());
                        pOutput.accept(blockregistry.STONE_GLASS_RAILING_A.get());
                        pOutput.accept(blockregistry.STONE_GLASS_RAILING_B.get());
                        pOutput.accept(blockregistry.STONE_GLASS_RAILING_C.get());
                        pOutput.accept(blockregistry.STONE_GLASS_RAILING_D.get());
                        pOutput.accept(blockregistry.STONE_GLASS_RAILING_E.get());

                        pOutput.accept(blockregistry.STONE_SIMPLE_RAILING.get());
                        pOutput.accept(blockregistry.STONE_SIMPLE_RAILING_A.get());
                        pOutput.accept(blockregistry.STONE_SIMPLE_RAILING_B.get());
                        pOutput.accept(blockregistry.STONE_SIMPLE_RAILING_C.get());
                        pOutput.accept(blockregistry.STONE_SIMPLE_RAILING_D.get());
                        pOutput.accept(blockregistry.STONE_SIMPLE_RAILING_E.get());

                        pOutput.accept(blockregistry.DEEPSLATE_PILLAR.get());



                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
