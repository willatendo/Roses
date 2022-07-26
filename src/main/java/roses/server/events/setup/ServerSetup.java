package roses.server.events.setup;

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
import roses.server.block.RosesBlocks;

public class ServerSetup {
	@EventBusSubscriber(modid = RosesMod.ID, bus = Bus.MOD)
	static class VanillaMaps {
		@SubscribeEvent
		public static void addToMaps(final FMLCommonSetupEvent event) {
			addToCompostables(0.65F, RosesBlocks.ROSE.get());
			addToCompostables(0.65F, RosesBlocks.CYAN_FLOWER.get());

			addToFlammables(RosesBlocks.ROSE.get(), 60, 100);
			addToFlammables(RosesBlocks.CYAN_FLOWER.get(), 60, 100);
			addToFlammables(RosesBlocks.ACACIA_CHAIR.get(), 5, 20);
			addToFlammables(RosesBlocks.BIRCH_CHAIR.get(), 5, 20);
			addToFlammables(RosesBlocks.DARK_OAK_CHAIR.get(), 5, 20);
			addToFlammables(RosesBlocks.JUNGLE_CHAIR.get(), 5, 20);
			addToFlammables(RosesBlocks.OAK_CHAIR.get(), 5, 20);
			addToFlammables(RosesBlocks.SPRUCE_CHAIR.get(), 5, 20);
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
