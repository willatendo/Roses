package willatendo.roses.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import willatendo.roses.server.util.RosesUtils;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = RosesUtils.ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        RosesClient.loadModels();
        RosesClient.CLIENT_EVENTS_HOLDER.registerAllEntityModels(entityModel -> {
            event.registerEntityRenderer(entityModel.entityType(), entityModel.entityRendererProvider());
        });
    }
}
