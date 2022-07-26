package roses.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import roses.RosesMod;
import roses.server.RosesTags;

public class RosesBiomeTags extends BiomeTagsProvider {
	public RosesBiomeTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, RosesMod.ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(RosesTags.Biomes.USES_BIRCH_FOREST_MUSIC).add(Biomes.BIRCH_FOREST).add(Biomes.OLD_GROWTH_BIRCH_FOREST);
		this.tag(RosesTags.Biomes.USES_BEACH_MUSIC).add(Biomes.BEACH).add(Biomes.SNOWY_BEACH).add(Biomes.STONY_SHORE);
		this.tag(RosesTags.Biomes.USES_DEEP_DARK_MUSIC).add(Biomes.DEEP_DARK);
	}
}
