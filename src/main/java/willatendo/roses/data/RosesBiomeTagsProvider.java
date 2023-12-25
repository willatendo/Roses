package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.biome.Biomes;
import willatendo.roses.server.biome.RosesBiomeTags;
import willatendo.simplelibrary.data.SimpleBiomeTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class RosesBiomeTagsProvider extends SimpleBiomeTagsProvider {
	public RosesBiomeTagsProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modid, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(RosesBiomeTags.HAS_ROSE).add(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
		this.tag(RosesBiomeTags.HAS_CYAN_FLOWER).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
	}
}
