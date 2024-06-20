package willatendo.roses.server.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;

public class RosesConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_PATCH = create("rose_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYAN_FLOWER_PATCH = create("cyan_flower_patch");

    public static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, RosesUtils.resource(name));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider blockStateProvider, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(blockStateProvider)));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> bootstrapContext) {
        FeatureUtils.register(bootstrapContext, ROSE_PATCH, Feature.FLOWER, grassPatch(BlockStateProvider.simple(RosesBlocks.ROSE.get().defaultBlockState()), 96));
        FeatureUtils.register(bootstrapContext, CYAN_FLOWER_PATCH, Feature.FLOWER, grassPatch(BlockStateProvider.simple(RosesBlocks.CYAN_FLOWER.get().defaultBlockState()), 96));

    }
}
