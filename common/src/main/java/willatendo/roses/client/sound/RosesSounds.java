package willatendo.roses.client.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesSounds {
    public static final SimpleRegistry<SoundEvent> SOUND_EVENTS = SimpleRegistry.create(Registries.SOUND_EVENT, RosesUtils.ID);

    public static final SimpleHolder<SoundEvent> MAGNETIC_CIRCUIT = SOUND_EVENTS.register("disc.sound.magnetic_circuit", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("disc.sound.magnetic_circuit")));
    public static final SimpleHolder<SoundEvent> COG_RUMBLES = SOUND_EVENTS.register("block.sound.cog_rumbles", () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource("disc.sound.cog_rumbles")));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(SOUND_EVENTS);
    }
}
