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
}
