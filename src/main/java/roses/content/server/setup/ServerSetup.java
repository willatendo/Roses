package roses.content.server.setup;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import roses.content.ModRegistry;
import roses.content.ModUtils;

public class ServerSetup {
	@EventBusSubscriber(modid = ModUtils.ID, bus = Bus.MOD)
	static class VanillaMaps {
		@SubscribeEvent
		public static void addToMaps(final FMLCommonSetupEvent event) {
			ModUtils.LOGGER.debug("Adding Compostables");

			addToCompostables(0.65F, ModRegistry.ROSE);
			addToCompostables(0.65F, ModRegistry.CYAN_FLOWER);

			ModUtils.LOGGER.debug("Finished Adding Compostables");

			ModUtils.LOGGER.debug("Adding Flammables");

			addToFlammables(ModRegistry.ROSE, 60, 100);
			addToFlammables(ModRegistry.CYAN_FLOWER, 60, 100);
			addToFlammables(ModRegistry.ACACIA_CHAIR, 5, 20);
			addToFlammables(ModRegistry.BIRCH_CHAIR, 5, 20);
			addToFlammables(ModRegistry.DARK_OAK_CHAIR, 5, 20);
			addToFlammables(ModRegistry.JUNGLE_CHAIR, 5, 20);
			addToFlammables(ModRegistry.OAK_CHAIR, 5, 20);
			addToFlammables(ModRegistry.SPRUCE_CHAIR, 5, 20);

			ModUtils.LOGGER.debug("Finished Adding Flammables");
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
