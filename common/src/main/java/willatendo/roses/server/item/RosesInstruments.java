package willatendo.roses.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Instrument;
import willatendo.roses.server.sound.RosesSoundEvents;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesInstruments {
    public static final SimpleRegistry<Instrument> INSTRUMENTS = SimpleRegistry.create(Registries.INSTRUMENT, RosesUtils.ID);

    public static final SimpleHolder<Instrument> FLY = INSTRUMENTS.register("fly", () -> new Instrument(RosesSoundEvents.FLY, 140, 256.0F));
    public static final SimpleHolder<Instrument> RESIST = INSTRUMENTS.register("resist", () -> new Instrument(RosesSoundEvents.RESIST, 140, 256.0F));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(INSTRUMENTS);
    }
}
