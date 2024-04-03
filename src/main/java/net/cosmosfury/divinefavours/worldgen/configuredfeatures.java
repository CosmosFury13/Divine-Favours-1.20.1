package net.cosmosfury.divinefavours.worldgen;

import net.cosmosfury.divinefavours.DivineFavours;
import net.minecraft.core.registries.Registries;
import net.cosmosfury.divinefavours.block.blockregistry;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.ObjLongConsumer;

public class configuredfeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MITHRIL_ORE_KEY = registerKey("mithril_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ORICHALCUM_ORE_KEY = registerKey("nether_orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_KYBER_ORE_KEY = registerKey("kyber_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PROMETHEUM_ORE_KEY = registerKey("nether_prometheum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_JADE_ORE_KEY = registerKey("jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TOPAZ_ORE_KEY = registerKey("topaz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MOONSTONE_ORE_KEY = registerKey("moonstone_ore");




    public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_KEY = registerKey("olive");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAWTHORNE_KEY = registerKey("hawthorne");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldMithrilOres = List.of(OreConfiguration.target(stoneReplaceable,
                        blockregistry.MITHRIL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, blockregistry.DEEPSLATE_MITHRIL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        blockregistry.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, blockregistry.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_MITHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMithrilOres, 9));
        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 9));
        register(context, NETHER_ORICHALCUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                blockregistry.ORICHALCUM_ORE.get().defaultBlockState(), 9));
        register(context, OVERWORLD_KYBER_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable,
                blockregistry.KYBER_ORE.get().defaultBlockState(), 9));
        register(context, NETHER_PROMETHEUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                blockregistry.PROMETHEUM_ORE.get().defaultBlockState(), 9));



        register(context, OLIVE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(blockregistry.OLIVE_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),

                BlockStateProvider.simple(blockregistry.OLIVE_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),

                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).build());

        register(context, HAWTHORNE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(blockregistry.HAWTHORNE_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),

                BlockStateProvider.simple(blockregistry.HAWTHORNE_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).build());


    }





    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DivineFavours.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}