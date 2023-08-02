package willatendo.roses.data;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.data.DataHelper;

@EventBusSubscriber(bus = Bus.MOD, modid = RosesUtils.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataHelper.collectAllData(RosesUtils.ID, event, RosesLanguageProvider::new).addBlockStateProvider(RosesBlockStateProvider::new).addItemModelProvider(RosesItemModelProvider::new).addSoundDefinitionProvider(RosesSoundDefinitionsProvider::new).addBasicTagProviders(RosesItemTagsProvider::new, RosesBlockTagsProvider::new).addBiomeTagProvider(RosesBiomeTagsProvider::new).addRecipeProvider(RosesRecipeProvider::new).addLootProvider(RosesLootTableProvider::create).addGeneric(RosesConfiguredFeatureProvider::new).addGeneric(RosesPlacedFeatureProvider::new).addGeneric(RosesBiomeModificationProvider::new);
	}
}
