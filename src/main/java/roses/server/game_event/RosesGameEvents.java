package roses.server.game_event;

import net.minecraft.core.Registry;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import roses.RosesMod;

public class RosesGameEvents {
	public static final DeferredRegister<GameEvent> GAME_EVENTS = DeferredRegister.create(Registry.GAME_EVENT_REGISTRY, RosesMod.ID);

	public static final RegistryObject<GameEvent> COG_RUMBLES = GAME_EVENTS.register("cog_rumbles", () -> new GameEvent("cog_rumbles", 16));
}
