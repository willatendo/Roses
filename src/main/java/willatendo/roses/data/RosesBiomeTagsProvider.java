package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.biome.RosesBiomeTags;

public class RosesBiomeTagsProvider extends BiomeTagsProvider {
	public RosesBiomeTagsProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(RosesBiomeTags.USES_BIRCH_FOREST_MUSIC).add(Biomes.BIRCH_FOREST).add(Biomes.OLD_GROWTH_BIRCH_FOREST);
		this.tag(RosesBiomeTags.USES_BEACH_MUSIC).add(Biomes.BEACH).add(Biomes.SNOWY_BEACH).add(Biomes.STONY_SHORE);
		this.tag(RosesBiomeTags.USES_DEEP_DARK_MUSIC).add(Biomes.DEEP_DARK);

		this.tag(RosesBiomeTags.HAS_ROSE).add(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
		this.tag(RosesBiomeTags.HAS_CYAN_FLOWER).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
	}
}
