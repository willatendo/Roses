package willatendo.roses.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.data.PackOutput;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.data.SimplePlacedFeatureProvider;

public class RosesPlacedFeatureProvider extends SimplePlacedFeatureProvider {
	public RosesPlacedFeatureProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void allPlacedFeatures() {
		this.simplePlacedFeature(RosesUtils.ID + ":rose_patch", "rose_patch", this.flowerPatch());
		this.simplePlacedFeature(RosesUtils.ID + ":cyan_flower_patch", "cyan_flower_patch", this.flowerPatch());
	}

	public void simplePlacedFeature(String configuredFeature, String id, JsonArray placement) {
		JsonObject placedFeature = new JsonObject();
		placedFeature.addProperty("feature", configuredFeature);
		placedFeature.add("placement", placement);
		PLACED_FEATURES.put(id, placedFeature);
	}

	public JsonArray flowerPatch() {
		JsonArray placement = new JsonArray();
		JsonObject rare = new JsonObject();
		rare.addProperty("type", "minecraft:rarity_filter");
		rare.addProperty("chance", 32);
		placement.add(rare);
		JsonObject square = new JsonObject();
		square.addProperty("type", "minecraft:in_square");
		placement.add(square);
		JsonObject height = new JsonObject();
		height.addProperty("type", "minecraft:heightmap");
		height.addProperty("heightmap", "MOTION_BLOCKING");
		placement.add(height);
		JsonObject biome = new JsonObject();
		biome.addProperty("type", "minecraft:biome");
		placement.add(biome);
		return placement;
	}
}
