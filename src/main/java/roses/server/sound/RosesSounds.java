package roses.server.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import roses.RosesMod;

public class RosesSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RosesMod.ID);

	// 4.0.0 Content
	public static final RegistryObject<SoundEvent> MAGNETIC_CIRCUIT = SOUND_EVENTS.register("disc.sound.magnetic_circuit", () -> new SoundEvent(RosesMod.rL("disc.sound.magnetic_circuit")));
	public static final RegistryObject<SoundEvent> BIRCH_FOREST = SOUND_EVENTS.register("music.sound.birch_forest", () -> new SoundEvent(RosesMod.rL("music.sound.birch_forest")));
	public static final RegistryObject<SoundEvent> DEEP_DARK = SOUND_EVENTS.register("music.sound.deep_dark", () -> new SoundEvent(RosesMod.rL("music.sound.deep_dark")));
	public static final RegistryObject<SoundEvent> BEACH = SOUND_EVENTS.register("music.sound.beach", () -> new SoundEvent(RosesMod.rL("music.sound.beach")));
}
