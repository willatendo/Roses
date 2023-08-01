package willatendo.roses.client.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import willatendo.roses.client.render.EmptyRenderer;
import willatendo.roses.server.entity.RosesEntities;
import willatendo.roses.server.util.RosesUtils;

@EventBusSubscriber(bus = Bus.MOD, modid = RosesUtils.ID, value = Dist.CLIENT)
public class ModClientEvents {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		EntityRenderers.register(RosesEntities.CHAIR.get(), EmptyRenderer::new);
	}
}
