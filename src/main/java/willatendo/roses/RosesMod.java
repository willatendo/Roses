package willatendo.roses;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import willatendo.roses.client.sound.RosesSounds;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.biome.RosesBiomeTags;
import willatendo.roses.server.biome.RosesPlacedFeatures;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.block.entity.RosesBlockEntities;
import willatendo.roses.server.entity.RosesEntities;
import willatendo.roses.server.gameevent.RosesGameEvents;
import willatendo.roses.server.item.RosesItems;

public class RosesMod implements ModInitializer {
	@Override
	public void onInitialize() {
		RosesSounds.init();
		RosesGameEvents.init();
		RosesItems.init();
		RosesBlocks.init();
		RosesBlockEntities.init();
		RosesCreativeModeTabs.init();
		RosesEntities.init();

		BiomeModifications.addFeature(BiomeSelectors.tag(RosesBiomeTags.HAS_CYAN_FLOWER), Decoration.VEGETAL_DECORATION, RosesPlacedFeatures.CYAN_FLOWER_PATCH);
		BiomeModifications.addFeature(BiomeSelectors.tag(RosesBiomeTags.HAS_ROSE), Decoration.VEGETAL_DECORATION, RosesPlacedFeatures.ROSE_PATCH);
	}
}
