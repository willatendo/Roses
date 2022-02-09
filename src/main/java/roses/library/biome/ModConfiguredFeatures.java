package roses.library.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import roses.content.ModRegistry;
import tyrannotitanlib.core.content.Util;

public class ModConfiguredFeatures {
	public static final ConfiguredFeature<?, ?> ROSES = register("roses", Feature.FLOWER.configured(patch(BlockStateProvider.simple(ModRegistry.ROSE), 64)));
	public static final PlacedFeature PLACED_ROSES = PlacementUtils.register("placed_roses", ModConfiguredFeatures.ROSES.placed(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

	public static final ConfiguredFeature<?, ?> CYAN_FLOWER = register("cyan_flower", Feature.FLOWER.configured(patch(BlockStateProvider.simple(ModRegistry.CYAN_FLOWER), 64)));
	public static final PlacedFeature PLACED_CYAN_FLOWER = PlacementUtils.register("placed_cyan_flower", ModConfiguredFeatures.CYAN_FLOWER.placed(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Util.ROSES_UTILS.resource(id), configuredFeature);
	}

	private static RandomPatchConfiguration patch(BlockStateProvider block, int tries) {
		return FeatureUtils.simpleRandomPatchConfiguration(tries, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(block)).onlyWhenEmpty());
	}
}
