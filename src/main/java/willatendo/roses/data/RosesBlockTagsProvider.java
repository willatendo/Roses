package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RosesBlockTagsProvider extends BlockTagsProvider {
	public RosesBlockTagsProvider(PackOutput packOutput, CompletableFuture<Provider> procider, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, procider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
	}
}
