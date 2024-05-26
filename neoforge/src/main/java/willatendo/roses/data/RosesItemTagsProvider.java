package willatendo.roses.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.roses.server.block.RosesBlockTags;
import willatendo.roses.server.item.RosesItemTags;
import willatendo.roses.server.item.RosesItems;

import java.util.concurrent.CompletableFuture;

public class RosesItemTagsProvider extends ItemTagsProvider {
    public RosesItemTagsProvider(PackOutput packOutput, CompletableFuture<Provider> registries, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ItemTags.MUSIC_DISCS).add(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get());
        this.tag(RosesItemTags.LEGACY_ITEM).add(RosesItems.RUBY.get(), RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get());

        this.copy(RosesBlockTags.LEGACY_BLOCKS, RosesItemTags.LEGACY_BLOCKS);
        this.copy(RosesBlockTags.CLOTH, RosesItemTags.CLOTH);
        this.copy(RosesBlockTags.CHAIRS, RosesItemTags.CHAIRS);
        this.copy(RosesBlockTags.COGS, RosesItemTags.COGS);
    }
}
