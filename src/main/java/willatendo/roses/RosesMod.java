package willatendo.roses;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.entity.RosesEntities;
import willatendo.roses.server.game_event.RosesGameEvents;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.sound.RosesSounds;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

@Mod(RosesUtils.ID)
public class RosesMod {
	public RosesMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		SimpleUtils.registerAll(iEventBus, RosesItems.ITEMS, RosesBlocks.BLOCKS, RosesCreativeModeTabs.CREATIVE_MODE_TABS, RosesEntities.ENTITY_TYPES, RosesSounds.SOUND_EVENTS, RosesGameEvents.GAME_EVENTS);
	}
}
