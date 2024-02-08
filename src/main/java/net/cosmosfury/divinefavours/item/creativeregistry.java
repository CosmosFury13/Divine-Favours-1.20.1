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
                        pOutput.accept(itemregistry.OLIVE_OIL.get());
                        pOutput.accept(itemregistry.OLIVE_RIPE.get());
                        pOutput.accept(itemregistry.FIG.get());
                        pOutput.accept(itemregistry.RAW_MITHRIL.get());
                        pOutput.accept(itemregistry.MITHRIL_INGOT.get());
                        pOutput.accept(itemregistry.MITHRIL_NUGGET.get());
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
                        pOutput.accept(itemregistry.ORICHALCUM_INGOT.get());
                        pOutput.accept(itemregistry.ORICHALCUM_NUGGET.get());
                        pOutput.accept(itemregistry.RAW_ORICHALCUM.get());
                        pOutput.accept(itemregistry.PROMETHEUM_INGOT.get());
                        pOutput.accept(itemregistry.PROMETHEUM_NUGGET.get());
                        pOutput.accept(itemregistry.RAW_PROMETHEUM.get());
                        pOutput.accept(itemregistry.QUASARITE_INGOT.get());
                        pOutput.accept(itemregistry.QUASARITE_NUGGET.get());
                        pOutput.accept(itemregistry.WYRMSTONE.get());


                        pOutput.accept(blockregistry.UNCUT_SAPPHIRE_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_SAPPHIRE_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_RUBY_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_RUBY_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_JADE_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_TOPAZ_NODE.get());
                        pOutput.accept(blockregistry.UNCUT_JADE_PILLAR.get());
                        pOutput.accept(blockregistry.UNCUT_TOPAZ_PILLAR.get());
                        pOutput.accept(blockregistry.TABLET_STAND.get());
                        pOutput.accept(blockregistry.SAPPHIRE_ALTAR.get());
                        pOutput.accept(blockregistry.CROWN_ALTAR.get());
                        pOutput.accept(blockregistry.RUBY_ALTAR.get());
                        pOutput.accept(blockregistry.JADE_ALTAR.get());
                        pOutput.accept(blockregistry.TOPAZ_ALTAR.get());
                        pOutput.accept(blockregistry.OLIVE_PLANKS.get());
                        pOutput.accept(blockregistry.OLIVE_LOG.get());
                        pOutput.accept(blockregistry.OLIVE_LEAVES.get());
                        pOutput.accept(blockregistry.OLIVE_SAPLING.get());
                        pOutput.accept(blockregistry.BRAZIER_MITHRIL.get());
                        pOutput.accept(blockregistry.BRAZIER_PROMETHEUM.get());
                        pOutput.accept(blockregistry.BRAZIER_GLEAMIUM.get());
                        pOutput.accept(blockregistry.BRAZIER_KYBER.get());
                        pOutput.accept(blockregistry.BRAZIER_ORICHALCUM.get());
                        pOutput.accept(blockregistry.BRAZIER_ASTRALITE.get());
                        pOutput.accept(blockregistry.BRAZIER_WYRMSTONE.get());
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
                        pOutput.accept(blockregistry.WYRMSTONE_BLOCK.get());
                        pOutput.accept(blockregistry.MOUNTAIN_ASH.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
