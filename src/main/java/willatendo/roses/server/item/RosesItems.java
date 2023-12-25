package willatendo.roses.server.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.block.Block;
import willatendo.roses.client.sound.RosesSounds;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesItems {
	public static final SimpleRegistry<Item> ITEMS = SimpleRegistry.create(BuiltInRegistries.ITEM, RosesUtils.ID);

	public static final RegistryHolder<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
	public static final RegistryHolder<Item> MUSIC_DISC_MAGNETIC_CIRCUIT = ITEMS.register("music_disc_magnetic_circuit", () -> new RecordItem(1, RosesSounds.MAGNETIC_CIRCUIT.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3860));

	public static void init() {
		RegistryHolder<Block>[] exceptions = new RegistryHolder[] { RosesBlocks.POTTED_ROSE, RosesBlocks.POTTED_CYAN_FLOWER };

		SimpleUtils.registerAllItems(RosesItems.ITEMS, RosesBlocks.BLOCKS, exceptions);
	}
}
