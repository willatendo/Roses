package willatendo.roses.server;

import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.simplelibrary.server.util.RegistryHolder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesBuiltInRegistries {
    public static final RegistryHolder<CopperHornInstrument> COPPER_HORN_INSTRUMENTS = SimpleUtils.createRegistry(RosesRegistries.COPPER_HORN_INSTRUMENTS);

    public static void init() {
    }
}
