package willatendo.roses.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import willatendo.roses.client.render.EmptyRenderer;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.entity.RosesEntities;

public class RosesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(RosesEntities.CHAIR.get(), EmptyRenderer::new);

		BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.COG.get(), RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.CYAN_FLOWER.get(), RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RosesBlocks.ROSE.get(), RenderType.cutout());
	}
}
