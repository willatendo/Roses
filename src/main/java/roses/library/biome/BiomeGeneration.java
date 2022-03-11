package roses.library.biome;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import roses.content.config.RosesConfig;

public class BiomeGeneration {
	public static void addFeaturesToOverworld(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();

		if (RosesConfig.COMMON_CONFIG.enableFlowerGeneration.get()) {
			if (RosesConfig.COMMON_CONFIG.flowerBiomes.get().contains(event.getName().toString())) {
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.PLACED_ROSE_AND_CYAN_FLOWER);
			}
		}
	}
}
