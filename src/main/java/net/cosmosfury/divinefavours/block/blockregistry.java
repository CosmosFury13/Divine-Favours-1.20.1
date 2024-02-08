package net.cosmosfury.divinefavours.block;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.item.itemregistry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.cosmosfury.divinefavours.block.brazier.LIT;



public class blockregistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DivineFavours.MOD_ID);

    public static final RegistryObject<Block> UNCUT_SAPPHIRE_PILLAR = registerBlock("uncut_sapphire_pillar",
            () -> new pillar());
    public static final RegistryObject<Block> UNCUT_RUBY_PILLAR = registerBlock("uncut_ruby_pillar",
            () -> new pillar());
    public static final RegistryObject<Block> UNCUT_JADE_PILLAR = registerBlock("uncut_jade_pillar",
            () -> new pillar());
    public static final RegistryObject<Block> UNCUT_TOPAZ_PILLAR = registerBlock("uncut_topaz_pillar",
            () -> new pillar());

    public static final RegistryObject<Block> UNCUT_SAPPHIRE_NODE = registerBlock("uncut_sapphire_node",
            () -> new node());
    public static final RegistryObject<Block> UNCUT_RUBY_NODE = registerBlock("uncut_ruby_node",
            () -> new node());
    public static final RegistryObject<Block> UNCUT_JADE_NODE = registerBlock("uncut_jade_node",
            () -> new node());
    public static final RegistryObject<Block> UNCUT_TOPAZ_NODE = registerBlock("uncut_topaz_node",
            () -> new node());

    public static final RegistryObject<Block> SAPPHIRE_ALTAR = registerBlock("sapphire_altar",
            () -> new altar());
    public static final RegistryObject<Block> RUBY_ALTAR = registerBlock("ruby_altar",
            () -> new altar());
    public static final RegistryObject<Block> JADE_ALTAR = registerBlock("jade_altar",
            () -> new altar());
    public static final RegistryObject<Block> CROWN_ALTAR = registerBlock("crown_altar",
            () -> new altar());
    public static final RegistryObject<Block> TOPAZ_ALTAR = registerBlock("topaz_altar",
            () -> new altar());
    public static final RegistryObject<Block> TABLET_STAND = registerBlock("tablet_stand",
            () -> new tablet());

    public static final RegistryObject<Block> MOUNTAIN_ASH = registerBlock("mountain_ash",
            () -> new mountainash(BlockBehaviour.Properties.copy(Blocks.REDSTONE_WIRE).sound(SoundType.STONE).noOcclusion().strength(0.0f, 0.75f)
            ));
    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> OLIVE_LOG = registerBlock("olive_log",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> OLIVE_LEAVES = registerBlock("olive_leaves",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> OLIVE_SAPLING = registerBlock("olive_sapling",
            () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> BRAZIER_MITHRIL = registerBlock("brazier_mithril",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));
    public static final RegistryObject<Block> BRAZIER_PROMETHEUM = registerBlock("brazier_prometheum",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));
    public static final RegistryObject<Block> BRAZIER_GLEAMIUM = registerBlock("brazier_gleamium",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));

    public static final RegistryObject<Block> BRAZIER_KYBER = registerBlock("brazier_kyber",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));
    public static final RegistryObject<Block> BRAZIER_ORICHALCUM = registerBlock("brazier_orichalcum",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));
    public static final RegistryObject<Block> BRAZIER_ASTRALITE = registerBlock("brazier_astralite",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));

    public static final RegistryObject<Block> BRAZIER_QUASARITE = registerBlock("brazier_quasarite",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));
    public static final RegistryObject<Block> BRAZIER_WYRMSTONE = registerBlock("brazier_wyrmstone",
            () -> new brazier(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .dynamicShape().lightLevel(state -> state.getValue(LIT) ? 15 : 0),1));

    public static final RegistryObject<Block> MITHRIL_ORE = registerBlock("mithril_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> MITHRIL_BLOCK = registerBlock("mithril_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));

    public static final RegistryObject<Block> RAW_MITHRIL_BLOCK = registerBlock("raw_mithril_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_ASTRALITE_BLOCK = registerBlock("raw_astralite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> ASTRALITE_BLOCK = registerBlock("astralite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> GLEAMIUM_BLOCK = registerBlock("gleamium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> RAW_GLEAMIUM_BLOCK = registerBlock("raw_gleamium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> KYBER_BLOCK = registerBlock("kyber_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> RAW_KYBER_BLOCK = registerBlock("raw_kyber_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> KYBER_ORE = registerBlock("kyber_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBlock("orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> RAW_ORICHALCUM_BLOCK = registerBlock("raw_orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> PROMETHEUM_ORE = registerBlock("prometheum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> PROMETHEUM_BLOCK = registerBlock("prometheum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> RAW_PROMETHEUM_BLOCK = registerBlock("raw_prometheum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> QUASARITE_BLOCK = registerBlock("quasarite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> WYRMSTONE_BLOCK = registerBlock("wyrmstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).strength(3.5f)));

    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));


    //public static final RegistryObject<Block> OFFERING_CHEST = registerBlock("offering_chest",
    //        () -> new ChestBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
     //               .sound(SoundType.WOOD),
    //                () -> BlockEntityType.CHEST));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        itemregistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static Block mithril_brazier = null;
}



