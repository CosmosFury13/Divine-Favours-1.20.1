package net.cosmosfury.divinefavours.item;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.block.blockregistry;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class itemregistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DivineFavours.MOD_ID);
    public static final RegistryObject<Item> UNCUT_SAPPHIRE = ITEMS.register("uncut_sapphire",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> UNCUT_JADE = ITEMS.register("uncut_jade",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> UNCUT_TOPAZ = ITEMS.register("uncut_topaz",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> UNCUT_MOONSTONE = ITEMS.register("uncut_moonstone",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> UNCUT_JANUS_CRYSTAL = ITEMS.register("uncut_janus_crystal",
            () -> new Item((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
            () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> CRUSHED_MITHRIL = ITEMS.register("crushed_mithril",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RAW_ASTRALITE = ITEMS.register("raw_astralite",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> ASTRALITE_INGOT = ITEMS.register("astralite_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> ASTRALITE_NUGGET = ITEMS.register("astralite_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RAW_GLEAMIUM = ITEMS.register("raw_gleamium",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> GLEAMIUM_INGOT = ITEMS.register("gleamium_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> GLEAMIUM_NUGGET = ITEMS.register("gleamium_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RAW_KYBER = ITEMS.register("raw_kyber",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> KYBER = ITEMS.register("kyber",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> KYBER_NUGGET = ITEMS.register("kyber_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CRUSHED_KYBER = ITEMS.register("crushed_kyber",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RAW_ORICHALCUM = ITEMS.register("raw_orichalcum",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> ORICHALCUM_NUGGET = ITEMS.register("orichalcum_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CRUSHED_ORICHALCUM = ITEMS.register("crushed_orichalcum",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RAW_PROMETHEUM = ITEMS.register("raw_prometheum",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> PROMETHEUM_INGOT = ITEMS.register("prometheum_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> PROMETHEUM_NUGGET = ITEMS.register("prometheum_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CRUSHED_PROMETHEUM = ITEMS.register("crushed_prometheum",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> QUASARITE_NUGGET = ITEMS.register("quasarite_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> QUASARITE_INGOT = ITEMS.register("quasarite_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CRUSHED_SILVER = ITEMS.register("crushed_silver",
            () -> new Item((new Item.Properties())));


    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> OLIVE_RIPE = ITEMS.register("olive_ripe",
            () -> new Item((new Item.Properties().food(foodregistry.OLIVES))));
    public static final RegistryObject<Item> FIG = ITEMS.register("fig",
            () -> new Item((new Item.Properties().food(foodregistry.FIG))));
    public static final RegistryObject<Item> MISTLETOE = ITEMS.register("mistletoe",
            () -> new Item((new Item.Properties().food(foodregistry.MISTLETOE))));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item((new Item.Properties().food(foodregistry.ORANGE))));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item((new Item.Properties().food(foodregistry.LEMON))));
    public static final RegistryObject<Item> WALNUT = ITEMS.register("walnut",
            () -> new Item((new Item.Properties().food(foodregistry.WALNUT))));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes",
            () -> new Item((new Item.Properties().food(foodregistry.GRAPES))));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new Item((new Item.Properties().food(foodregistry.COFFEE_BEANS))));
    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item((new Item.Properties().food(foodregistry.CUCUMBER))));
    public static final RegistryObject<Item> AUBERGINE = ITEMS.register("aubergine",
            () -> new Item((new Item.Properties().food(foodregistry.AUBERGINE))));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item((new Item.Properties().food(foodregistry.CORN))));
    public static final RegistryObject<Item> RAW_CALAMARI = ITEMS.register("raw_calamari",
            () -> new Item((new Item.Properties().food(foodregistry.RAW_CALAMARI))));

    public static final RegistryObject<Item> UNCUT_RUBY = ITEMS.register("uncut_ruby",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> KINDLING = ITEMS.register("kindling",
            () -> new Item((new Item.Properties().durability(20))));
    public static final RegistryObject<Item> SNUFFER = ITEMS.register("snuffer",
            () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new Item((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> SAW = ITEMS.register("saw",
            () -> new Item((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
            () -> new Item((new Item.Properties().stacksTo(1))));

    public static final RegistryObject<Item> UNIDENTIFIED_CHESTPLATE = ITEMS.register("unidentified_chestplate",
            () -> new unidentifiedchestplateitem((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> UNIDENTIFIED_HELMET = ITEMS.register("unidentified_helmet",
            () -> new unidentifiedhelmetitem((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> UNIDENTIFIED_LEGGINGS = ITEMS.register("unidentified_leggings",
            () -> new unidentifiedpantsitem((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> UNIDENTIFIED_BOOTS = ITEMS.register("unidentified_boots",
            () -> new unidentifiedbootsitem((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> UNIDENTIFIED_PICKAXE = ITEMS.register("unidentified_pickaxe",
            () -> new unidentifiedpickitem((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> UNIDENTIFIED_SHIELD = ITEMS.register("unidentified_shield",
            () -> new unidentifiedshielditem((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> UNIDENTIFIED_SWORD = ITEMS.register("unidentified_sword",
            () -> new unidentifiedsworditem((new Item.Properties().stacksTo(1))));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
