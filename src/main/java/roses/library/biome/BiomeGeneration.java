package roses.library.biome;

import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import roses.content.config.RosesConfig;
import roses.content.server.BiomeConfig;

public class BiomeGeneration 
{
	public static void addFeaturesToOverworld(BiomeLoadingEvent event)
	{
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		
		if(RosesConfig.COMMON_CONFIG.enableRosesGeneration.get())
		{
			if(BiomeConfig.roseBiomes.contains(event.getName().toString()))
			{
				generation.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.ROSES);
			}
		}
		
		if(RosesConfig.COMMON_CONFIG.enableCyanFlowersGeneration.get())
		{
			if(BiomeConfig.cyanFlowerBiomes.contains(event.getName().toString()))
			{
				generation.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.CYAN_FLOWERS);
			}
		}
	}
}
