package roses.server;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import roses.RosesMod;

public class RosesTags {
	public static class Items {
		public static final TagKey<Item> LEGACY_ITEMS = tag("legacy_items");
		public static final TagKey<Item> LEGACY_BLOCKS = tag("legacy_blocks");
		public static final TagKey<Item> CHAIRS = tag("chairs");
		public static final TagKey<Item> CLOTH = tag("cloth");

		private static TagKey<Item> tag(String name) {
			return ItemTags.create(RosesMod.rL(name));
		}
	}

	public static class Blocks {
		public static final TagKey<Block> LEGACY_BLOCKS = tag("legacy_blocks");
		public static final TagKey<Block> CHAIRS = tag("chairs");
		public static final TagKey<Block> CLOTH = tag("cloth");

		private static TagKey<Block> tag(String name) {
			return BlockTags.create(RosesMod.rL(name));
		}
	}
}
