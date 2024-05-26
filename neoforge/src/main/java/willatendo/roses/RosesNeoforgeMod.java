package willatendo.roses;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod(RosesUtils.ID)
public class RosesNeoforgeMod {
    public static final List<SimpleRegistry<?>> REGISTRIES = new ArrayList<>();

    public RosesNeoforgeMod(IEventBus modEventBus) {
        RosesMod.onInitialize(REGISTRIES);
    }
}
