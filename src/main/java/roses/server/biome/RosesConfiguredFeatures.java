package roses.server.biome;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import roses.server.RosesRegistry;

public class RosesConfiguredFeatures {
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ROSE_AND_CYAN_FLOWER = FeatureUtils.register("rose_and_cyan_flower", Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(RosesRegistry.ROSE.get().defaultBlockState(), RosesRegistry.CYAN_FLOWER.get().defaultBlockState()))))));
}
