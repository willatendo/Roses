package willatendo.roses.server.event;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegisterEvent;
import willatendo.roses.RosesForgeMod;
import willatendo.roses.server.gameevent.RosesGameEvents;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.ForgeRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = RosesUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        final Object2IntOpenHashMap<GameEvent> vibrationFrequencyForEvent = (Object2IntOpenHashMap<GameEvent>) VibrationSystem.VIBRATION_FREQUENCY_FOR_EVENT;
        vibrationFrequencyForEvent.put(RosesGameEvents.COG_RUMBLES.get(), 10);
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        ForgeRegister.register(event, RosesForgeMod.REGISTRIES.toArray(SimpleRegistry[]::new));
    }
}
