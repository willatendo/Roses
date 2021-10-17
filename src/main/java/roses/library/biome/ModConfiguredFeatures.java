package roses.library.biome;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import roses.content.ModRegistry;
import roses.content.ModUtils;

public class ModConfiguredFeatures 
{
	public static final BlockClusterFeatureConfig ROSE_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(ModRegistry.ROSE.defaultBlockState(), 2), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final ConfiguredFeature<?, ?> ROSES = register("roses", Feature.FLOWER.configured(ROSE_CONFIG).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(4));	
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) 
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ModUtils.rL(id), configuredFeature);
	}
}
