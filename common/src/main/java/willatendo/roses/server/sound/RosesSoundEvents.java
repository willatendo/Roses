package willatendo.roses.server.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesSoundEvents {
    public static final SimpleRegistry<SoundEvent> SOUND_EVENTS = SimpleRegistry.create(Registries.SOUND_EVENT, RosesUtils.ID);

    public static final SimpleHolder<SoundEvent> MAGNETIC_CIRCUIT = register("disc.sound.magnetic_circuit");
    public static final SimpleHolder<SoundEvent> DOG = register("disc.sound.dog");

    public static final SimpleHolder<SoundEvent> COG_RUMBLES = register("block.sound.cog_rumbles");

    public static final SimpleHolder<SoundEvent> FLY = register("item.goat_horn.sound.call.8");
    public static final SimpleHolder<SoundEvent> RESIST = register("item.goat_horn.sound.call.9");

    public static final SimpleHolder<SoundEvent> GREAT = register("item.copper_horn.sound.call.0");
    public static final SimpleHolder<SoundEvent> SKY = register("item.copper_horn.sound.melody.0");
    public static final SimpleHolder<SoundEvent> FALLING = register("item.copper_horn.sound.bass.0");
    public static final SimpleHolder<SoundEvent> OLD = register("item.copper_horn.sound.call.1");
    public static final SimpleHolder<SoundEvent> HYMN = register("item.copper_horn.sound.melody.1");
    public static final SimpleHolder<SoundEvent> RESTING = register("item.copper_horn.sound.bass.1");
    public static final SimpleHolder<SoundEvent> PURE = register("item.copper_horn.sound.call.2");
    public static final SimpleHolder<SoundEvent> WATER = register("item.copper_horn.sound.melody.2");
    public static final SimpleHolder<SoundEvent> DESIRE = register("item.copper_horn.sound.bass.2");
    public static final SimpleHolder<SoundEvent> HUMBLE = register("item.copper_horn.sound.call.3");
    public static final SimpleHolder<SoundEvent> FIRE = register("item.copper_horn.sound.melody.3");
    public static final SimpleHolder<SoundEvent> MEMORY = register("item.copper_horn.sound.bass.3");
    public static final SimpleHolder<SoundEvent> DRY = register("item.copper_horn.sound.call.4");
    public static final SimpleHolder<SoundEvent> URGE = register("item.copper_horn.sound.melody.4");
    public static final SimpleHolder<SoundEvent> ANGER = register("item.copper_horn.sound.bass.4");
    public static final SimpleHolder<SoundEvent> CLEAR = register("item.copper_horn.sound.call.5");
    public static final SimpleHolder<SoundEvent> TEMPER = register("item.copper_horn.sound.melody.5");
    public static final SimpleHolder<SoundEvent> JOURNEY = register("item.copper_horn.sound.bass.5");
    public static final SimpleHolder<SoundEvent> FRESH = register("item.copper_horn.sound.call.6");
    public static final SimpleHolder<SoundEvent> NEST = register("item.copper_horn.sound.melody.6");
    public static final SimpleHolder<SoundEvent> THOUGHT = register("item.copper_horn.sound.bass.6");
    public static final SimpleHolder<SoundEvent> SECRET = register("item.copper_horn.sound.call.7");
    public static final SimpleHolder<SoundEvent> LAKE = register("item.copper_horn.sound.melody.7");
    public static final SimpleHolder<SoundEvent> TEAR = register("item.copper_horn.sound.bass.7");
    public static final SimpleHolder<SoundEvent> FEARLESS = register("item.copper_horn.sound.call.8");
    public static final SimpleHolder<SoundEvent> RIVER = register("item.copper_horn.sound.melody.8");
    public static final SimpleHolder<SoundEvent> GIFT = register("item.copper_horn.sound.bass.8");
    public static final SimpleHolder<SoundEvent> SWEET = register("item.copper_horn.sound.call.9");
    public static final SimpleHolder<SoundEvent> MOON = register("item.copper_horn.sound.melody.9");
    public static final SimpleHolder<SoundEvent> LOVE = register("item.copper_horn.sound.bass.9");

    private static SimpleHolder<SoundEvent> register(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(RosesUtils.resource(name)));
    }

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(SOUND_EVENTS);
    }
}
