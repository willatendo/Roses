package willatendo.roses.server.features;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;

public class RosesPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ROSE_PATCH = create("rose_patch");
    public static final ResourceKey<PlacedFeature> CYAN_FLOWER_PATCH = create("cyan_flower_patch");

    public static ResourceKey<PlacedFeature> create(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, RosesUtils.resource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> bootstapContext) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = bootstapContext.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(bootstapContext, ROSE_PATCH, configuredFeatures.getOrThrow(RosesConfiguredFeatures.ROSE_PATCH), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(bootstapContext, CYAN_FLOWER_PATCH, configuredFeatures.getOrThrow(RosesConfiguredFeatures.CYAN_FLOWER_PATCH), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    }
}
