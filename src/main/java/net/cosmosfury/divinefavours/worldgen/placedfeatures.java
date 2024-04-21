package net.cosmosfury.divinefavours.worldgen;
import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.block.blockregistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class placedfeatures {
    public static final ResourceKey<PlacedFeature> MITHRIL_ORE_PLACED_KEY = registerKey("mithril_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ORICHALCUM_ORE_PLACED_KEY = registerKey("nether_orichalcum_ore_placed");
    public static final ResourceKey<PlacedFeature> KYBER_ORE_PLACED_KEY = registerKey("kyber_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_PROMETHEUM_ORE_PLACED_KEY = registerKey("nether_prometheum_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");

    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> TOPAZ_ORE_PLACED_KEY = registerKey("topaz_ore_placed");
    public static final ResourceKey<PlacedFeature> JADE_ORE_PLACED_KEY = registerKey("jade_ore_placed");
    public static final ResourceKey<PlacedFeature> MOONSTONE_ORE_PLACED_KEY = registerKey("moonstone_ore_placed");

    public static final ResourceKey<PlacedFeature> OLIVE_PLACED_KEY = registerKey("olive_placed");
    public static final ResourceKey<PlacedFeature> HAWTHORNE_PLACED_KEY = registerKey("hawthorne_placed");



    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MITHRIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.OVERWORLD_MITHRIL_ORE_KEY),
                oreplacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_ORICHALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.NETHER_ORICHALCUM_ORE_KEY),
                oreplacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.OVERWORLD_SILVER_ORE_KEY),
                oreplacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_PROMETHEUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.NETHER_PROMETHEUM_ORE_KEY),
                oreplacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, KYBER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.OVERWORLD_KYBER_ORE_KEY),
                oreplacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.RUBY_ORE_KEY),
                oreplacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.SAPPHIRE_ORE_KEY),
                oreplacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, TOPAZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.TOPAZ_ORE_KEY),
                oreplacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(48))));
        register(context, JADE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.JADE_ORE_KEY),
                oreplacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(48))));
        register(context, MOONSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.MOONSTONE_ORE_KEY),
                oreplacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));


        register(context, OLIVE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.OLIVE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.000001f, 1),
                        blockregistry.OLIVE_SAPLING.get()));

        register(context, HAWTHORNE_PLACED_KEY, configuredFeatures.getOrThrow(configuredfeatures.HAWTHORNE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.0000001f, 1),
                        blockregistry.HAWTHORNE_SAPLING.get()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DivineFavours.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
