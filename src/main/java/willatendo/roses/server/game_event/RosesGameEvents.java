package willatendo.roses.server.game_event;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.util.RosesUtils;

public class RosesGameEvents {
	public static final DeferredRegister<GameEvent> GAME_EVENTS = DeferredRegister.create(Registries.GAME_EVENT, RosesUtils.ID);

	public static final RegistryObject<GameEvent> COG_RUMBLES = GAME_EVENTS.register("cog_rumbles", () -> new GameEvent("cog_rumbles", 16));
}
