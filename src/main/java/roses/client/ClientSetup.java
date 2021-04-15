package roses.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import roses.core.init.BlockInit;
import roses.core.util.ModID;

@Mod.EventBusSubscriber(modid = ModID.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup 
{
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
		RenderTypeLookup.setRenderLayer(BlockInit.ROSE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_ROSE.get(), RenderType.cutout());
	}
}
