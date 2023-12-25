package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import willatendo.roses.server.block.RosesBlockTags;
import willatendo.roses.server.item.RosesItemTags;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.data.SimpleItemTagsProvider;
import willatendo.simplelibrary.data.SimpleTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class RosesItemTagsProvider extends SimpleItemTagsProvider {
	public RosesItemTagsProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, CompletableFuture<SimpleTagsProvider.TagLookup<Block>> blockTags, String modid, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, blockTags, modid, existingFileHelper);
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
