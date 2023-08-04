package willatendo.roses.server.events;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;

@EventBusSubscriber(modid = RosesUtils.ID, bus = Bus.MOD)
public class ModServerEvents {
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
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

		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(RosesBlocks.ROSE.getId(), () -> RosesBlocks.POTTED_ROSE.get());
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(RosesBlocks.CYAN_FLOWER.getId(), () -> RosesBlocks.POTTED_CYAN_FLOWER.get());
	}

	private static void addToCompostables(float chance, ItemLike item) {
		ComposterBlock.COMPOSTABLES.put(item, chance);
	}

	private static void addToFlammables(Block burnable, int catchFlame, int burn) {
//			FireBlock fireblock = (FireBlock) Blocks.FIRE;
//			fireblock.setFlammable(burnable, catchFlame, burn);
	}
}
