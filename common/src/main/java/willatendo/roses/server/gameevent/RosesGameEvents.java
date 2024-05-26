package willatendo.roses.server.gameevent;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesGameEvents {
    public static final SimpleRegistry<GameEvent> GAME_EVENTS = SimpleRegistry.create(Registries.GAME_EVENT, RosesUtils.ID);

    public static final SimpleHolder<GameEvent> COG_RUMBLES = GAME_EVENTS.register("cog_rumbles", () -> new GameEvent(16));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(GAME_EVENTS);
        //SculkSensorFrequencyRegistry.register(RosesGameEvents.COG_RUMBLES.get(), 10);
    }
}
