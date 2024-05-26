package willatendo.roses.server.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesPlacedFeatures {
	public static final ResourceKey<PlacedFeature> CYAN_FLOWER_PATCH = register("cyan_flower_patch");
	public static final ResourceKey<PlacedFeature> ROSE_PATCH = register("rose_patch");

	public static ResourceKey<PlacedFeature> register(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, SimpleUtils.resource(RosesUtils.ID, id));
	}
}
