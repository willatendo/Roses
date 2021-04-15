package roses.world.init;

import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SingleRandomFeature;
import roses.core.init.BlockInit;

public class ModFeatures 
{
	protected static final BlockState ROSE = BlockInit.ROSE.get().defaultBlockState();
	
	private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ROSES_FEATURES = ImmutableList.of(() -> 
	{
		return Feature.NO_BONEMEAL_FLOWER.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.ROSE), SimpleBlockPlacer.INSTANCE)).tries(64).build());
	});
	
	public static final ConfiguredFeature<?, ?> ROSE_PLAINS = register("rose_plains", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(ROSES_FEATURES)).count(FeatureSpread.of(-1, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) 
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, id, feature);
	}
}
