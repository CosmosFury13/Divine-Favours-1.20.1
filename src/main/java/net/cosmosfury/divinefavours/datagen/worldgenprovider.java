package net.cosmosfury.divinefavours.datagen;

import net.cosmosfury.divinefavours.DivineFavours;
import net.cosmosfury.divinefavours.worldgen.biomemodifiers;
import net.cosmosfury.divinefavours.worldgen.configuredfeatures;
import net.cosmosfury.divinefavours.worldgen.placedfeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class worldgenprovider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, configuredfeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, placedfeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, biomemodifiers::bootstrap);

    public worldgenprovider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DivineFavours.MOD_ID));
    }
}