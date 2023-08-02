package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.item.RosesItems;

public class RosesItemTagsProvider extends ItemTagsProvider {
	public RosesItemTagsProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, blockTags, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ItemTags.MUSIC_DISCS).add(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get());
	}
}
