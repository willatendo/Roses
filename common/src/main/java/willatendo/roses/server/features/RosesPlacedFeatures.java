package willatendo.roses.server.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import willatendo.roses.server.util.RosesUtils;

public class RosesPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ROSE_PATCH = create("rose_patch");
    public static final ResourceKey<PlacedFeature> CYAN_FLOWER_PATCH = create("cyan_flower_patch");

    public static ResourceKey<PlacedFeature> create(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, RosesUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> bootstrapContext) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = bootstrapContext.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(bootstrapContext, ROSE_PATCH, configuredFeatures.getOrThrow(RosesConfiguredFeatures.ROSE_PATCH), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, CYAN_FLOWER_PATCH, configuredFeatures.getOrThrow(RosesConfiguredFeatures.CYAN_FLOWER_PATCH), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    }
}
