package willatendo.roses.client.render;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.roses.server.entity.Chair;

public class EmptyRenderer extends EntityRenderer<Chair> {
	public EmptyRenderer(Context context) {
		super(context);
	}

	@Override
	public boolean shouldRender(Chair chair, Frustum frustum, double camX, double camY, double camZ) {
		return false;
	}

	@Override
	public ResourceLocation getTextureLocation(Chair entity) {
		return null;
	}
}
