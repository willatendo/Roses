package willatendo.roses.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.roses.server.biome.RosesBiomeTags;

import java.util.concurrent.CompletableFuture;

public class RosesBiomeTagsProvider extends BiomeTagsProvider {
    public RosesBiomeTagsProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modid, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modid, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(RosesBiomeTags.HAS_ROSE).add(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
        this.tag(RosesBiomeTags.HAS_CYAN_FLOWER).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
    }
}
