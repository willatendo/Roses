package roses;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import roses.content.ModRegistry;
import roses.content.config.RosesConfig;
import roses.library.biome.BiomeGeneration;
import roses.library.block.BurningBlock;
import roses.library.item.ModBlockItem;
import tyrannotitanlib.core.content.Util;
import tyrannotitanlib.library.item.block.TyrannoBurningBlockItem;

@Mod(Util.ROSES_ID)
@EventBusSubscriber(bus = Bus.MOD, modid = Util.ROSES_ID)
public class RosesMod {
	public RosesMod() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		var forgeBus = MinecraftForge.EVENT_BUS;

		ModRegistry.registry(bus);

		bus.addListener(this::setup);

		forgeBus.addListener(EventPriority.HIGH, BiomeGeneration::addFeaturesToOverworld);

		ModLoadingContext.get().registerConfig(Type.COMMON, RosesConfig.commonSpec);
	}

	private void setup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ModRegistry.ROSES_TAB.setItemIcon(ModRegistry.ROSE.get().asItem().getDefaultInstance());
		});
	}

	@SubscribeEvent
	public static void onRegisterItems(Register<Item> event) {
		var registry = event.getRegistry();

		ModRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get).filter(block -> !(block instanceof FlowerPotBlock)).forEach(block -> {
			Properties properties = new Item.Properties().tab(ModRegistry.ROSES_TAB);
			BlockItem blockItem;
			if (block instanceof BurningBlock burning) {
				blockItem = new TyrannoBurningBlockItem(properties, block, burning.getBurnTime());
			} else {
				blockItem = new ModBlockItem(() -> block, properties);
			}
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
	}
}
