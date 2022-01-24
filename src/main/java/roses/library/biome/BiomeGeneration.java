package roses.library.biome;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import roses.content.ModUtils;
import roses.content.config.RosesConfig;

public class BiomeGeneration {
	public static void addFeaturesToOverworld(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();

		if (RosesConfig.COMMON_CONFIG.enableRosesGeneration.get()) {
			if (ModUtils.COMMON_CONFIG.roseBiomes.get().contains(event.getName().toString())) {
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.PLACED_ROSES);
			}
		}

		if (RosesConfig.COMMON_CONFIG.enableCyanFlowersGeneration.get()) {
			if (ModUtils.COMMON_CONFIG.cyanFlowerBiomes.get().contains(event.getName().toString())) {
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.PLACED_CYAN_FLOWER);
			}
		}
	}
}
