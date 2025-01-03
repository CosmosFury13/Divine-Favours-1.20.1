package net.cosmosfury.divinefavours.block;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.item.itemregistry;
//import net.cosmosfury.divinefavours.worldgen.tree.hawthornetreegrower;
//import net.cosmosfury.divinefavours.worldgen.tree.olivetreegrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.cosmosfury.divinefavours.block.brazier.LIT;
import static net.minecraft.world.level.block.Blocks.DEEPSLATE;
import static net.minecraft.world.level.block.Blocks.OAK_PLANKS;


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
    public static final RegistryObject<Block> UNCUT_MOONSTONE_PILLAR = registerBlock("uncut_moonstone_pillar",
            () -> new pillar());

    public static final RegistryObject<Block> UNCUT_MOONSTONE_NODE = registerBlock("uncut_moonstone_node",
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



    public static final RegistryObject<Block> SCROLL = registerBlock("scroll",
            () -> new scroll(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)
                    .noOcclusion().sound(SoundType.WOOD)));

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
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBlock("orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> RAW_ORICHALCUM_BLOCK = registerBlock("raw_orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> PROMETHEUM_ORE = registerBlock("prometheum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> PROMETHEUM_BLOCK = registerBlock("prometheum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));
    public static final RegistryObject<Block> RAW_PROMETHEUM_BLOCK = registerBlock("raw_prometheum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> QUASARITE_BLOCK = registerBlock("quasarite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(3.5f)));

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
    public static final RegistryObject<Block> SILVER_KALVIS_ALTAR = registerBlock("silver_kalvis_altar",
            () -> new kalvisaltar());
    public static final RegistryObject<Block> PROMETHEUM_KALVIS_ALTAR = registerBlock("prometheum_kalvis_altar",
            () -> new kalvisaltar());
    public static final RegistryObject<Block> GLEAMIUM_KALVIS_ALTAR = registerBlock("gleamium_kalvis_altar",
            () -> new kalvisaltar());
    public static final RegistryObject<Block> JANUS_TABLE = registerBlock("janus_table",
            () -> new janustable());

    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING = registerBlock("limestone_arched_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING = registerBlock("limestone_glass_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING = registerBlock("limestone_simple_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_ARCHED_RAILING = registerBlock("deepslate_arched_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_GLASS_RAILING = registerBlock("deepslate_glass_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_GLASS_RAILING_A = registerBlock("deepslate_glass_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_GLASS_RAILING_B = registerBlock("deepslate_glass_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_GLASS_RAILING_C = registerBlock("deepslate_glass_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_GLASS_RAILING_D = registerBlock("deepslate_glass_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_ARCHED_RAILING_A = registerBlock("deepslate_arched_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_ARCHED_RAILING_B = registerBlock("deepslate_arched_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_ARCHED_RAILING_C = registerBlock("deepslate_arched_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_ARCHED_RAILING_D = registerBlock("deepslate_arched_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> DEEPSLATE_SIMPLE_RAILING_A = registerBlock("deepslate_simple_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_SIMPLE_RAILING_B = registerBlock("deepslate_simple_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_SIMPLE_RAILING_C = registerBlock("deepslate_simple_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_SIMPLE_RAILING_D = registerBlock("deepslate_simple_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_SIMPLE_RAILING = registerBlock("deepslate_simple_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING = registerBlock("andesite_arched_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING = registerBlock("andesite_glass_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING = registerBlock("andesite_simple_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING = registerBlock("brick_arched_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING = registerBlock("brick_glass_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING = registerBlock("brick_simple_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_ARCHED_RAILING = registerBlock("mud_brick_arched_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_GLASS_RAILING = registerBlock("mud_brick_glass_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_SIMPLE_RAILING = registerBlock("mud_brick_simple_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_ARCHED_RAILING_A = registerBlock("mud_brick_arched_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_GLASS_RAILING_A = registerBlock("mud_brick_glass_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_SIMPLE_RAILING_A = registerBlock("mud_brick_simple_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_ARCHED_RAILING = registerBlock("stone_arched_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_GLASS_RAILING = registerBlock("stone_glass_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_SIMPLE_RAILING = registerBlock("stone_simple_railing",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_A = registerBlock("andesite_glass_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_B = registerBlock("andesite_glass_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_C = registerBlock("andesite_glass_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_D = registerBlock("andesite_glass_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_E = registerBlock("andesite_glass_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_F = registerBlock("andesite_glass_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_G = registerBlock("andesite_glass_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_H = registerBlock("andesite_glass_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_GLASS_RAILING_I = registerBlock("andesite_glass_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_A = registerBlock("andesite_arched_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_B = registerBlock("andesite_arched_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_C = registerBlock("andesite_arched_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_D = registerBlock("andesite_arched_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_E = registerBlock("andesite_arched_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_F = registerBlock("andesite_arched_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_G = registerBlock("andesite_arched_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_H = registerBlock("andesite_arched_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_ARCHED_RAILING_I = registerBlock("andesite_arched_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_A = registerBlock("andesite_simple_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_B = registerBlock("andesite_simple_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_C = registerBlock("andesite_simple_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_D = registerBlock("andesite_simple_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_E = registerBlock("andesite_simple_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_F = registerBlock("andesite_simple_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_G = registerBlock("andesite_simple_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_H = registerBlock("andesite_simple_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_SIMPLE_RAILING_I = registerBlock("andesite_simple_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_A = registerBlock("brick_glass_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_B = registerBlock("brick_glass_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_C = registerBlock("brick_glass_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_D = registerBlock("brick_glass_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_E = registerBlock("brick_glass_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_F = registerBlock("brick_glass_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_G = registerBlock("brick_glass_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_H = registerBlock("brick_glass_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_GLASS_RAILING_I = registerBlock("brick_glass_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_A = registerBlock("brick_arched_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_B = registerBlock("brick_arched_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_C = registerBlock("brick_arched_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_D = registerBlock("brick_arched_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_E = registerBlock("brick_arched_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_F = registerBlock("brick_arched_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_G = registerBlock("brick_arched_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_H = registerBlock("brick_arched_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_ARCHED_RAILING_I = registerBlock("brick_arched_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_A = registerBlock("brick_simple_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_B = registerBlock("brick_simple_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_C = registerBlock("brick_simple_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_D = registerBlock("brick_simple_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_E = registerBlock("brick_simple_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_F = registerBlock("brick_simple_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_G = registerBlock("brick_simple_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_H = registerBlock("brick_simple_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> BRICK_SIMPLE_RAILING_I = registerBlock("brick_simple_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.BRICKS).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_A = registerBlock("limestone_glass_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_B = registerBlock("limestone_glass_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_C = registerBlock("limestone_glass_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_D = registerBlock("limestone_glass_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_E = registerBlock("limestone_glass_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_F = registerBlock("limestone_glass_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_G = registerBlock("limestone_glass_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_H = registerBlock("limestone_glass_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_GLASS_RAILING_I = registerBlock("limestone_glass_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_A = registerBlock("limestone_arched_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_B = registerBlock("limestone_arched_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_C = registerBlock("limestone_arched_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_D = registerBlock("limestone_arched_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_E = registerBlock("limestone_arched_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_F = registerBlock("limestone_arched_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_G = registerBlock("limestone_arched_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_H = registerBlock("limestone_arched_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_ARCHED_RAILING_I = registerBlock("limestone_arched_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_A = registerBlock("limestone_simple_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_B = registerBlock("limestone_simple_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_C = registerBlock("limestone_simple_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_D = registerBlock("limestone_simple_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_E = registerBlock("limestone_simple_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_F = registerBlock("limestone_simple_railing_f",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_G = registerBlock("limestone_simple_railing_g",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_H = registerBlock("limestone_simple_railing_h",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> LIMESTONE_SIMPLE_RAILING_I = registerBlock("limestone_simple_railing_i",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_GLASS_RAILING_A = registerBlock("stone_glass_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_GLASS_RAILING_B = registerBlock("stone_glass_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_GLASS_RAILING_C = registerBlock("stone_glass_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_GLASS_RAILING_D = registerBlock("stone_glass_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_GLASS_RAILING_E = registerBlock("stone_glass_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> STONE_ARCHED_RAILING_A = registerBlock("stone_arched_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_ARCHED_RAILING_B = registerBlock("stone_arched_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_ARCHED_RAILING_C = registerBlock("stone_arched_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_ARCHED_RAILING_D = registerBlock("stone_arched_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_ARCHED_RAILING_E = registerBlock("stone_arched_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));

    public static final RegistryObject<Block> STONE_SIMPLE_RAILING_A = registerBlock("stone_simple_railing_a",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_SIMPLE_RAILING_B = registerBlock("stone_simple_railing_b",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_SIMPLE_RAILING_C = registerBlock("stone_simple_railing_c",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_SIMPLE_RAILING_D = registerBlock("stone_simple_railing_d",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));
    public static final RegistryObject<Block> STONE_SIMPLE_RAILING_E = registerBlock("stone_simple_railing_e",
            () -> new railingblock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f).noOcclusion()));







    public static final RegistryObject<Block> LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            () -> new stairtrial(OAK_PLANKS.defaultBlockState(),BlockBehaviour.Properties.copy(OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
            () -> new column(BlockBehaviour.Properties.copy(DEEPSLATE).lightLevel((i) -> 2).emissiveRendering((state, level, pos) -> true)));

    public static final RegistryObject<Block> AMPHORA = registerBlock("amphora",
            () -> new amphora(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion().dynamicShape().sound(SoundType.DECORATED_POT)));
    public static final RegistryObject<Block> UNCUT_RUBY_TORCH = registerBlock("uncut_ruby_torch",
            () -> new gemtorchblock(BlockBehaviour.Properties.of().forceSolidOff().instabreak().lightLevel((p_152692_) -> {
                return 12;
            }).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> UNCUT_JADE_TORCH = registerBlock("uncut_jade_torch",
            () -> new gemtorchblock(BlockBehaviour.Properties.of().forceSolidOff().noCollission().instabreak().lightLevel((p_152692_) -> {
                return 12;
            }).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> UNCUT_SAPPHIRE_TORCH = registerBlock("uncut_sapphire_torch",
            () -> new gemtorchblock(BlockBehaviour.Properties.of().forceSolidOff().noCollission().instabreak().lightLevel((p_152692_) -> {
                return 12;
            }).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> UNCUT_TOPAZ_TORCH = registerBlock("uncut_topaz_torch",
            () -> new gemtorchblock(BlockBehaviour.Properties.of().forceSolidOff().noCollission().instabreak().lightLevel((p_152692_) -> {
                return 12;
            }).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> UNCUT_MOONSTONE_TORCH = registerBlock("uncut_moonstone_torch",
            () -> new gemtorchblock(BlockBehaviour.Properties.of().forceSolidOff().noCollission().instabreak().lightLevel((p_152692_) -> {
                return 12;
            }).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> PLUTUS_CHEST = registerBlock("plutus_chest",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.5f).noOcclusion()
                    .isViewBlocking((state, world, pos) -> false)));





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



