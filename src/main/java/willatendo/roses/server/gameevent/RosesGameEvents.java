package willatendo.roses.server.gameevent;

import net.fabricmc.fabric.api.registry.SculkSensorFrequencyRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class RosesGameEvents {
	public static final SimpleRegistry<GameEvent> GAME_EVENTS = SimpleRegistry.create(BuiltInRegistries.GAME_EVENT, RosesUtils.ID);

	public static final RegistryHolder<GameEvent> COG_RUMBLES = GAME_EVENTS.register("cog_rumbles", () -> new GameEvent(16));

	public static void init() {
		SculkSensorFrequencyRegistry.register(RosesGameEvents.COG_RUMBLES.get(), 10);
	}
}
