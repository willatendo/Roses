package roses.content;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import roses.content.client.resourcepacks.RosesProgramerArt;
import roses.content.config.RosesConfig;
import roses.library.biome.BiomeGeneration;
import tyrannotitanlib.library.TyrannotitanMod;

@Mod(ModUtils.ID)
public class RosesMod 
{
	public RosesMod() 
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		
		TyrannotitanMod.init(ModUtils.ID);
		ModRegistry.registry();
		
		bus.addListener(this::clientSetup);
		
		forgeBus.addListener(EventPriority.HIGH, BiomeGeneration::addFeaturesToOverworld);
		
		ModLoadingContext.get().registerConfig(Type.COMMON, RosesConfig.commonSpec);
	}
	
	private void clientSetup(FMLClientSetupEvent event)
	{
		RosesProgramerArt.init();
	}
}
