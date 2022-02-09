package roses.content;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import roses.content.config.RosesConfig;
import roses.library.biome.BiomeGeneration;
import tyrannotitanlib.core.content.Util;

@Mod(Util.ROSES_ID)
public class RosesMod {
	public RosesMod() {
//		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		final IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		ModRegistry.registry();

//		bus.addListener(this::clientSetup);

		forgeBus.addListener(EventPriority.HIGH, BiomeGeneration::addFeaturesToOverworld);

		ModLoadingContext.get().registerConfig(Type.COMMON, RosesConfig.commonSpec);
	}

//	private void clientSetup(FMLClientSetupEvent event) {
//		RosesProgramerArt.init();
//	}
}
