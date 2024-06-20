package willatendo.roses.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;

public class RosesItems {
    public static final SimpleRegistry<Item> ITEMS = SimpleRegistry.create(Registries.ITEM, RosesUtils.ID);

    public static final SimpleHolder<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final SimpleHolder<Item> MUSIC_DISC_MAGNETIC_CIRCUIT = ITEMS.register("music_disc_magnetic_circuit", () -> new Item((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(RosesJukeboxSongs.MAGNETIC_CIRCUIT)));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        SimpleHolder<Block>[] exceptions = new SimpleHolder[]{RosesBlocks.POTTED_ROSE, RosesBlocks.POTTED_CYAN_FLOWER};

        SimpleUtils.registerAllItems(RosesItems.ITEMS, RosesBlocks.BLOCKS, exceptions);

        simpleRegistries.add(ITEMS);
    }
}
