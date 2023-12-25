package willatendo.roses.client.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class RosesSounds {
	public static final SimpleRegistry<SoundEvent> SOUND_EVENTS = SimpleRegistry.create(BuiltInRegistries.SOUND_EVENT, RosesUtils.ID);

	public static final RegistryHolder<SoundEvent> MAGNETIC_CIRCUIT = SOUND_EVENTS.register("disc.sound.magnetic_circuit", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("disc.sound.magnetic_circuit")));
	public static final RegistryHolder<SoundEvent> COG_RUMBLES = SOUND_EVENTS.register("disc.sound.cog_rumbles", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("disc.sound.cog_rumbles")));

	public static void init() {
	}
}
