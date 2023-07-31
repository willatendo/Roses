package willatendo.roses.server.entity;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class EmptyRenderer extends EntityRenderer<Chair> {
	public EmptyRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public boolean shouldRender(Chair entity, Frustum camera, double camX, double camY, double camZ) {
		return false;
	}

	@Override
	public ResourceLocation getTextureLocation(Chair entity) {
		return null;
	}
}
