package willatendo.roses.server.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.sound.RosesSounds;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RosesUtils.ID);

	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
	public static final RegistryObject<RecordItem> MUSIC_DISC_MAGNETIC_CIRCUIT = ITEMS.register("music_disc_magnetic_circuit", () -> new RecordItem(1, () -> RosesSounds.MAGNETIC_CIRCUIT.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3860));

	static {
		SimpleUtils.registerAllItems(RosesItems.ITEMS, RosesBlocks.BLOCKS);
	}
}
