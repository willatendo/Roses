package willatendo.roses.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class RosesItemTags {
    public static final TagRegister<Item> ITEM_TAGS = TagRegister.create(Registries.ITEM, RosesUtils.ID);

    public static final TagKey<Item> LEGACY_ITEM = ITEM_TAGS.register("legacy_item");
    public static final TagKey<Item> LEGACY_BLOCKS = ITEM_TAGS.register("legacy_blocks");
    public static final TagKey<Item> CHAIRS = ITEM_TAGS.register("chairs");
    public static final TagKey<Item> CLOTH = ITEM_TAGS.register("cloth");
    public static final TagKey<Item> COGS = ITEM_TAGS.register("cogs");
}
