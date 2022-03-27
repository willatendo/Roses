package roses.server.events.setup;

import static roses.RosesMod.UTILS;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import roses.RosesMod;
import roses.server.RosesRegistry;

public class ServerSetup {
	@EventBusSubscriber(modid = RosesMod.ID, bus = Bus.MOD)
	static class VanillaMaps {
		@SubscribeEvent
		public static void addToMaps(final FMLCommonSetupEvent event) {
			UTILS.getLogger().debug("Adding Compostables");

			addToCompostables(0.65F, RosesRegistry.ROSE.get());
			addToCompostables(0.65F, RosesRegistry.CYAN_FLOWER.get());

			UTILS.getLogger().debug("Finished Adding Compostables");

			UTILS.getLogger().debug("Adding Flammables");

			addToFlammables(RosesRegistry.ROSE.get(), 60, 100);
			addToFlammables(RosesRegistry.CYAN_FLOWER.get(), 60, 100);
			addToFlammables(RosesRegistry.ACACIA_CHAIR.get(), 5, 20);
			addToFlammables(RosesRegistry.BIRCH_CHAIR.get(), 5, 20);
			addToFlammables(RosesRegistry.DARK_OAK_CHAIR.get(), 5, 20);
			addToFlammables(RosesRegistry.JUNGLE_CHAIR.get(), 5, 20);
			addToFlammables(RosesRegistry.OAK_CHAIR.get(), 5, 20);
			addToFlammables(RosesRegistry.SPRUCE_CHAIR.get(), 5, 20);

			UTILS.getLogger().debug("Finished Adding Flammables");
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
