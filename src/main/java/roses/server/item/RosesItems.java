package roses.server.item;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import roses.RosesMod;
import roses.server.RosesTags;
import roses.server.block.RosesBlocks;
import roses.server.sound.RosesSounds;
import roses.server.util.RosesRegistrate;

public class RosesItems {
	public static final RosesRegistrate REGISTRATE = RosesMod.getRegistrate().creativeModeTab(() -> RosesMod.ROSES_TAB, "Roses");;

	// 3.3.0 Content
	public static final ItemEntry<Item> RUBY = REGISTRATE.item("ruby", Item::new).tag(RosesTags.Items.LEGACY_ITEMS).recipe((item, provider) -> {
		provider.smeltingAndBlasting(DataIngredient.items(item.get()), RosesBlocks.RUBY_ORE, 0.7F);
		provider.smeltingAndBlasting(DataIngredient.items(item.get()), RosesBlocks.DEEPSLATE_RUBY_ORE, 0.7F);
	}).register();

	// 4.0.0 Content
	public static final ItemEntry<RecordItem> MUSIC_DISC_MAGNETIC_CIRCUIT = REGISTRATE.item("music_disc_magnetic_circuit", p -> new RecordItem(1, () -> RosesSounds.MAGNETIC_CIRCUIT.get(), p)).properties(properties -> properties.stacksTo(1).rarity(Rarity.RARE)).lang("Music Disc").addMiscData(ProviderType.LANG, provider -> provider.add("item.roses.music_disc_magnetic_circuit.desc", "Notch - Magnetic Circuit")).register();

	public static void init() {
	}
}
