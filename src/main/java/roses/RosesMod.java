package roses;

import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import roses.data.RosesAdvancements;
import roses.server.RosesRegistry;
import roses.server.biome.BiomeGeneration;
import roses.server.config.RosesConfig;
import roses.server.util.RosesRegistrate;
import tyrannotitanlib.core.content.UtilitiesRegistry;

@Mod(RosesMod.ID)
public class RosesMod {
	public static final String ID = "roses";
	public static final UtilitiesRegistry UTILS = new UtilitiesRegistry(RosesMod.ID);
	public static final NonNullSupplier<RosesRegistrate> CENTRAL_REGISTRATE = RosesRegistrate.lazy(RosesMod.ID);

	public RosesMod() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		var forgeBus = MinecraftForge.EVENT_BUS;

		RosesRegistry.init();
		
		bus.addListener(this::dataSetup);
		bus.addListener(this::commonSetup);

		forgeBus.addListener(EventPriority.HIGH, BiomeGeneration::addFeaturesToOverworld);

		ModLoadingContext.get().registerConfig(Type.COMMON, RosesConfig.commonSpec);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			RosesRegistry.ROSES_TAB.setItemIcon(RosesRegistry.ROSE.get().asItem().getDefaultInstance());
		});
	}
	
	private void dataSetup(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		dataGenerator.addProvider(new RosesAdvancements(dataGenerator));
	}
}
