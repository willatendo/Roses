package roses.server;

import static roses.RosesMod.UTILS;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RosesTags {
	public static class Items {
		public static final TagKey<Item> LEGACY_ITEMS = tag("legacy_items");
		public static final TagKey<Item> LEGACY_BLOCKS = tag("legacy_blocks");
		public static final TagKey<Item> CHAIRS = tag("chairs");
		public static final TagKey<Item> CLOTH = tag("cloth");

		private static TagKey<Item> tag(String name) {
			return ItemTags.create(UTILS.mod(name));
		}
	}

	public static class Blocks {
		public static final TagKey<Block> LEGACY_BLOCKS = tag("legacy_blocks");
		public static final TagKey<Block> CHAIRS = tag("chairs");
		public static final TagKey<Block> CLOTH = tag("cloth");

		private static TagKey<Block> tag(String name) {
			return BlockTags.create(UTILS.mod(name));
		}
	}
}
