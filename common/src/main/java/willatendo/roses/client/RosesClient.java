package willatendo.roses.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import willatendo.roses.client.render.EmptyRenderer;
import willatendo.roses.server.entity.RosesEntities;
import willatendo.simplelibrary.client.event.ClientEventsHolder;

public class RosesClient {
    public static final ClientEventsHolder CLIENT_EVENTS_HOLDER = new ClientEventsHolder();

    public static <T extends Entity> void addModel(EntityType<? extends T> entityType, EntityRendererProvider<? extends T> entityRendererProvider) {
        CLIENT_EVENTS_HOLDER.addModel(entityType, entityRendererProvider);
    }

    public static void loadModels() {
        RosesClient.addModel(RosesEntities.CHAIR.get(), EmptyRenderer::new);
    }

    //BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.COG.get(), RenderType.cutout());
    //BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.CYAN_FLOWER.get(), RenderType.cutout());
    //BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.ROSE.get(), RenderType.cutout());
}
