package roses.content.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import roses.content.ModRegistry;
import roses.content.ModUtils;
import roses.library.entity.EmptyRenderer;

@EventBusSubscriber(bus = Bus.MOD, modid = ModUtils.ID, value = Dist.CLIENT)
public class ClientSetup {
	@SubscribeEvent
	public static void onEntityRendererRegistry(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModRegistry.CHAIR_ENTITY, EmptyRenderer::new);
	}
}
