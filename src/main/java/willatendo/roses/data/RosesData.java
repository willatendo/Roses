package willatendo.roses.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import willatendo.simplelibrary.data.DataHandler;

public class RosesData implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		DataHandler dataHandler = new DataHandler(fabricDataGenerator);

		dataHandler.addLanguageProvider((fabricDataOutput, modId) -> new RosesLanguageProvider(fabricDataOutput, modId, "en_us"));
		dataHandler.addProvider(RosesSoundDefinitionsProvider::new);
		dataHandler.addProvider(RosesItemModelProvider::new);
		dataHandler.addProvider((fabricDataOutput, modId) -> new RosesRecipeProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, modId) -> RosesLootTableProvider.create(fabricDataOutput));
		dataHandler.addProvider(RosesBlockStateProvider::new);
		dataHandler.addProvider(RosesConfiguredFeatureProvider::new);
		dataHandler.addProvider(RosesPlacedFeatureProvider::new);
		dataHandler.addTagsProvider(RosesItemTagsProvider::new, RosesBlockTagsProvider::new);
		dataHandler.addProvider(RosesBiomeTagsProvider::new);
		dataHandler.addProvider(RosesGameEventTagsProvider::new);
	}
}
