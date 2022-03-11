package roses.content.server.setup;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import roses.content.ModRegistry;
import tyrannotitanlib.core.content.Util;

public class ServerSetup {
	@EventBusSubscriber(modid = Util.ROSES_ID, bus = Bus.MOD)
	static class VanillaMaps {
		@SubscribeEvent
		public static void addToMaps(final FMLCommonSetupEvent event) {
			Util.ROSES_UTILS.getLogger().debug("Adding Compostables");

			addToCompostables(0.65F, ModRegistry.ROSE.get());
			addToCompostables(0.65F, ModRegistry.CYAN_FLOWER.get());

			Util.ROSES_UTILS.getLogger().debug("Finished Adding Compostables");

			Util.ROSES_UTILS.getLogger().debug("Adding Flammables");

			addToFlammables(ModRegistry.ROSE.get(), 60, 100);
			addToFlammables(ModRegistry.CYAN_FLOWER.get(), 60, 100);
			addToFlammables(ModRegistry.ACACIA_CHAIR.get(), 5, 20);
			addToFlammables(ModRegistry.BIRCH_CHAIR.get(), 5, 20);
			addToFlammables(ModRegistry.DARK_OAK_CHAIR.get(), 5, 20);
			addToFlammables(ModRegistry.JUNGLE_CHAIR.get(), 5, 20);
			addToFlammables(ModRegistry.OAK_CHAIR.get(), 5, 20);
			addToFlammables(ModRegistry.SPRUCE_CHAIR.get(), 5, 20);

			Util.ROSES_UTILS.getLogger().debug("Finished Adding Flammables");
		}

		private static void addToCompostables(float chance, ItemLike item) {
			ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
		}

		private static void addToFlammables(Block burnable, int catchFlame, int burn) {
			FireBlock fireblock = (FireBlock) Blocks.FIRE;
			fireblock.setFlammable(burnable, catchFlame, burn);
		}
	}
}
