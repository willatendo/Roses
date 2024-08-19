package willatendo.roses.server.item;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesDataComponents {
    public static final SimpleRegistry<DataComponentType<?>> DATA_COMPONENT_TYPES = SimpleRegistry.create(Registries.DATA_COMPONENT_TYPE, RosesUtils.ID);

    public static final SimpleHolder<DataComponentType<Holder<CopperHornInstrument>>> COPPER_HORN_INSTRUMENT = DATA_COMPONENT_TYPES.register("copper_horn_instrument", () -> DataComponentType.<Holder<CopperHornInstrument>>builder().persistent(CopperHornInstrument.CODEC).networkSynchronized(CopperHornInstrument.STREAM_CODEC).cacheEncoding().build());

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(DATA_COMPONENT_TYPES);
    }
}
