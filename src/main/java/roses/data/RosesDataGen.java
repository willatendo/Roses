package roses.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import roses.RosesMod;

@EventBusSubscriber(bus = Bus.MOD, modid = RosesMod.ID)
public class RosesDataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		dataGenerator.addProvider(new RosesAdvancements(dataGenerator));
	}
}
