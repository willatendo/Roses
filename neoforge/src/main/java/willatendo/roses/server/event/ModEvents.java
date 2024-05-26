package willatendo.roses.server.event;

import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import willatendo.roses.RosesNeoforgeMod;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.NeoForgeRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = RosesUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void register(RegisterEvent event) {
        NeoForgeRegister.register(event, RosesNeoforgeMod.REGISTRIES.toArray(SimpleRegistry[]::new));
    }
}
