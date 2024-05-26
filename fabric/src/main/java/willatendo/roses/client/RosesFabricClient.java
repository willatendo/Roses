package willatendo.roses.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import willatendo.roses.server.block.RosesBlocks;

public class RosesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.COG.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.CYAN_FLOWER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.ROSE.get(), RenderType.cutout());

        RosesClient.loadModels();

        RosesClient.CLIENT_EVENTS_HOLDER.registerAllEntityModels(entityModel -> {
            EntityRendererRegistry.register(entityModel.entityType(), entityModel.entityRendererProvider());
        });
    }
}
