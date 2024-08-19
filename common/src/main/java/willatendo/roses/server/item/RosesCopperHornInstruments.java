package willatendo.roses.server.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Instruments;
import willatendo.roses.server.RosesRegistries;
import willatendo.roses.server.sound.RosesSoundEvents;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RosesCopperHornInstruments {
    public static final SimpleRegistry<CopperHornInstrument> COPPER_HORN_INSTRUMENTS = SimpleRegistry.create(RosesRegistries.COPPER_HORN_INSTRUMENTS, RosesUtils.ID);

    public static final SimpleHolder<CopperHornInstrument> GREAT_SKY_FALLING = COPPER_HORN_INSTRUMENTS.register("great_sky_falling", () -> new CopperHornInstrument(RosesSoundEvents.GREAT, RosesSoundEvents.SKY, RosesSoundEvents.FALLING, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> OLD_HYMN_RESTING = COPPER_HORN_INSTRUMENTS.register("old_hymn_resting", () -> new CopperHornInstrument(RosesSoundEvents.OLD, RosesSoundEvents.HYMN, RosesSoundEvents.RESTING, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> PURE_WATER_DESIRE = COPPER_HORN_INSTRUMENTS.register("pure_water_desire", () -> new CopperHornInstrument(RosesSoundEvents.PURE, RosesSoundEvents.WATER, RosesSoundEvents.DESIRE, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> HUMBLE_FIRE_MEMORY = COPPER_HORN_INSTRUMENTS.register("humble_fire_memory", () -> new CopperHornInstrument(RosesSoundEvents.HUMBLE, RosesSoundEvents.FIRE, RosesSoundEvents.MEMORY, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> DRY_URGE_ANGER = COPPER_HORN_INSTRUMENTS.register("dry_urge_anger", () -> new CopperHornInstrument(RosesSoundEvents.DRY, RosesSoundEvents.URGE, RosesSoundEvents.ANGER, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> CLEAR_TEMPER_JOURNEY = COPPER_HORN_INSTRUMENTS.register("clear_temper_journey", () -> new CopperHornInstrument(RosesSoundEvents.CLEAR, RosesSoundEvents.TEMPER, RosesSoundEvents.JOURNEY, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> FRESH_NEST_THOUGHT = COPPER_HORN_INSTRUMENTS.register("fresh_nest_thought", () -> new CopperHornInstrument(RosesSoundEvents.FRESH, RosesSoundEvents.NEST, RosesSoundEvents.THOUGHT, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> SECRET_LAKE_TEAR = COPPER_HORN_INSTRUMENTS.register("secret_lake_tear", () -> new CopperHornInstrument(RosesSoundEvents.SECRET, RosesSoundEvents.LAKE, RosesSoundEvents.TEAR, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> FEARLESS_RIVER_GIFT = COPPER_HORN_INSTRUMENTS.register("fearless_river_gift", () -> new CopperHornInstrument(RosesSoundEvents.FEARLESS, RosesSoundEvents.RIVER, RosesSoundEvents.GIFT, 80, 256.0F));
    public static final SimpleHolder<CopperHornInstrument> SWEET_MOON_LOVE = COPPER_HORN_INSTRUMENTS.register("sweet_moon_love", () -> new CopperHornInstrument(RosesSoundEvents.SWEET, RosesSoundEvents.MOON, RosesSoundEvents.LOVE, 80, 256.0F));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(COPPER_HORN_INSTRUMENTS);
    }

    public static Map<ResourceKey<Instrument>, CopperHornInstrument> getInstruments() {
        Map<ResourceKey<Instrument>, CopperHornInstrument> map = new HashMap<>();
        map.put(Instruments.PONDER_GOAT_HORN, RosesCopperHornInstruments.GREAT_SKY_FALLING.get());
        map.put(Instruments.SING_GOAT_HORN, RosesCopperHornInstruments.OLD_HYMN_RESTING.get());
        map.put(Instruments.SEEK_GOAT_HORN, RosesCopperHornInstruments.PURE_WATER_DESIRE.get());
        map.put(Instruments.FEEL_GOAT_HORN, RosesCopperHornInstruments.HUMBLE_FIRE_MEMORY.get());
        map.put(Instruments.ADMIRE_GOAT_HORN, RosesCopperHornInstruments.DRY_URGE_ANGER.get());
        map.put(Instruments.CALL_GOAT_HORN, RosesCopperHornInstruments.CLEAR_TEMPER_JOURNEY.get());
        map.put(Instruments.YEARN_GOAT_HORN, RosesCopperHornInstruments.FRESH_NEST_THOUGHT.get());
        map.put(Instruments.DREAM_GOAT_HORN, RosesCopperHornInstruments.SECRET_LAKE_TEAR.get());
        map.put(RosesInstruments.FLY.getKey(), RosesCopperHornInstruments.FEARLESS_RIVER_GIFT.get());
        map.put(RosesInstruments.RESIST.getKey(), RosesCopperHornInstruments.SWEET_MOON_LOVE.get());
        return map;
    }
}
