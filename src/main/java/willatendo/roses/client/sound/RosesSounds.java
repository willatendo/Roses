package willatendo.roses.client.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.util.RosesUtils;

public class RosesSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RosesUtils.ID);

	public static final RegistryObject<SoundEvent> MAGNETIC_CIRCUIT = SOUND_EVENTS.register("disc.sound.magnetic_circuit", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("disc.sound.magnetic_circuit")));
	public static final RegistryObject<SoundEvent> BIRCH_FOREST = SOUND_EVENTS.register("music.sound.birch_forest", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("music.sound.birch_forest")));
	public static final RegistryObject<SoundEvent> DEEP_DARK = SOUND_EVENTS.register("music.sound.deep_dark", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("music.sound.deep_dark")));
	public static final RegistryObject<SoundEvent> BEACH = SOUND_EVENTS.register("music.sound.beach", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("music.sound.beach")));
}
