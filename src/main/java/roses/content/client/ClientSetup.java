package roses.content.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import roses.content.ModRegistry;
import roses.library.entity.EmptyRenderer;
import tyrannotitanlib.core.content.Util;

@EventBusSubscriber(bus = Bus.MOD, modid = Util.ROSES_ID, value = Dist.CLIENT)
public class ClientSetup {
	@SubscribeEvent
	public static void onEntityRendererRegistry(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModRegistry.CHAIR_ENTITY.get(), EmptyRenderer::new);
	}
}
