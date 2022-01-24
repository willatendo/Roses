package roses.content.client.setup;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import roses.content.ModRegistry;
import roses.content.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup 
{
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
		ItemBlockRenderTypes.setRenderLayer(ModRegistry.ROSE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModRegistry.POTTED_ROSE, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModRegistry.CYAN_FLOWER, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModRegistry.POTTED_CYAN_FLOWER, RenderType.cutout());
	}
}