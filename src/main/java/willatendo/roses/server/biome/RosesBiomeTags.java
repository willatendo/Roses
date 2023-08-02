package willatendo.roses.server.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class RosesBiomeTags {
	public static final TagRegister<Biome> BIOME_TAGS = SimpleUtils.create(Registries.BIOME, RosesUtils.ID);

	public static final TagKey<Biome> USES_BIRCH_FOREST_MUSIC = BIOME_TAGS.register("uses_music/birch_forest_music");
	public static final TagKey<Biome> USES_DEEP_DARK_MUSIC = BIOME_TAGS.register("uses_music/deep_dark_music");
	public static final TagKey<Biome> USES_BEACH_MUSIC = BIOME_TAGS.register("uses_music/beach_music");
	
	public static final TagKey<Biome> HAS_ROSE = BIOME_TAGS.register("has_rose");
	public static final TagKey<Biome> HAS_CYAN_FLOWER = BIOME_TAGS.register("has_cyan_flower");
}
