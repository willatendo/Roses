package roses.library.biome;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import roses.content.RosesRegistry;

public class ModConfiguredFeatures {
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ROSE_AND_CYAN_FLOWER = FeatureUtils.register("rose_and_cyan_flower", Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(RosesRegistry.ROSE.get().defaultBlockState(), RosesRegistry.CYAN_FLOWER.get().defaultBlockState()))))));
	public static final Holder<PlacedFeature> PLACED_ROSE_AND_CYAN_FLOWER = PlacementUtils.register("placed_rose_and_cyan_flower", ModConfiguredFeatures.ROSE_AND_CYAN_FLOWER, CountPlacement.of(3), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}
