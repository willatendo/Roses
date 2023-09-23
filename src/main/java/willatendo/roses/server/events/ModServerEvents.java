package willatendo.roses.server.events;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegisterEvent;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.game_event.RosesGameEvents;
import willatendo.roses.server.util.RosesUtils;

@EventBusSubscriber(modid = RosesUtils.ID, bus = Bus.MOD)
public class ModServerEvents {
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		addToCompostables(0.65F, RosesBlocks.ROSE.get());
		addToCompostables(0.65F, RosesBlocks.CYAN_FLOWER.get());

		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(RosesBlocks.ROSE.getId(), () -> RosesBlocks.POTTED_ROSE.get());
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(RosesBlocks.CYAN_FLOWER.getId(), () -> RosesBlocks.POTTED_CYAN_FLOWER.get());
	}

	@SubscribeEvent
	public static void addToVibrations(RegisterEvent event) {
		event.register(Registries.GAME_EVENT, registryHelper -> {
			Object2IntOpenHashMap<GameEvent> map = ((Object2IntOpenHashMap) VibrationSystem.VIBRATION_FREQUENCY_FOR_EVENT);
			map.put(RosesGameEvents.COG_RUMBLES.get(), 10);
		});
	}

	private static void addToCompostables(float chance, ItemLike item) {
		ComposterBlock.COMPOSTABLES.put(item, chance);
	}
}
