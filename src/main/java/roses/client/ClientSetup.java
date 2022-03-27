package roses.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import roses.RosesMod;
import roses.server.RosesRegistry;

@EventBusSubscriber(bus = Bus.MOD, modid = RosesMod.ID, value = Dist.CLIENT)
public class ClientSetup {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(RosesRegistry.ROSE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(RosesRegistry.POTTED_ROSE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(RosesRegistry.CYAN_FLOWER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(RosesRegistry.POTTED_CYAN_FLOWER.get(), RenderType.cutout());
	}
}
