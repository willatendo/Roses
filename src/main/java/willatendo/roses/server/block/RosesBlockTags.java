package willatendo.roses.server.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class RosesBlockTags {
	public static final TagRegister<Block> BLOCK_TAGS = SimpleUtils.create(Registries.BLOCK, RosesUtils.ID);

	public static final TagKey<Block> LEGACY_BLOCKS = BLOCK_TAGS.register("legacy_blocks");
	public static final TagKey<Block> CHAIRS = BLOCK_TAGS.register("chairs");
	public static final TagKey<Block> TABLES = BLOCK_TAGS.register("tables");
	public static final TagKey<Block> CLOTH = BLOCK_TAGS.register("cloth");
	public static final TagKey<Block> HARD_POWERS_COGS = BLOCK_TAGS.register("hard_powers_cogs");
	public static final TagKey<Block> SOFT_POWERS_COGS = BLOCK_TAGS.register("soft_powers_cogs");
	public static final TagKey<Block> COGS = BLOCK_TAGS.register("cogs");
}
