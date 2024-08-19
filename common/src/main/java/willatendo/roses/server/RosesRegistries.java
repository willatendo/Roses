package willatendo.roses.server;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.roses.server.util.RosesUtils;

public class RosesRegistries {
    public static final ResourceKey<Registry<CopperHornInstrument>> COPPER_HORN_INSTRUMENTS = createRegistryKey("copper_horn_instruments");

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String id) {
        return ResourceKey.createRegistryKey(RosesUtils.resource(id));
    }
}
