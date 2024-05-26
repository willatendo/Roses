package willatendo.roses.server.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class RosesBiomeTags {
    public static final TagRegister<Biome> BIOME_TAGS = TagRegister.create(Registries.BIOME, RosesUtils.ID);

    public static final TagKey<Biome> HAS_ROSE = BIOME_TAGS.register("has_rose");
    public static final TagKey<Biome> HAS_CYAN_FLOWER = BIOME_TAGS.register("has_cyan_flower");
}
