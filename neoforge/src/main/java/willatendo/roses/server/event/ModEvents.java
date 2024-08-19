package willatendo.roses.server.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import willatendo.roses.RosesNeoforgeMod;
import willatendo.roses.server.RosesBuiltInRegistries;
import willatendo.roses.server.RosesRegistries;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.NeoForgeRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = RosesUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void registerRegistries(NewRegistryEvent event) {
        event.register(RosesBuiltInRegistries.COPPER_HORN_INSTRUMENTS.registry());
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        NeoForgeRegister.register(event, RosesNeoforgeMod.REGISTRIES.toArray(SimpleRegistry[]::new));
    }
}
