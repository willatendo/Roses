package willatendo.roses.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.simplelibrary.data.SimpleConfiguredFeatureProvider;

public class RosesConfiguredFeatureProvider extends SimpleConfiguredFeatureProvider {
	public RosesConfiguredFeatureProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void allConfiguredFeatures() {
		this.simpleConfiguredFeature(Feature.FLOWER, "rose_patch", this.flowerPatch(RosesBlocks.ROSE.get()));
		this.simpleConfiguredFeature(Feature.FLOWER, "cyan_flower_patch", this.flowerPatch(RosesBlocks.CYAN_FLOWER.get()));
	}

	public JsonObject flowerPatch(Block flower) {
		JsonObject config = new JsonObject();
		config.addProperty("tries", 96);
		config.addProperty("xz_spread", 6);
		config.addProperty("y_spread", 2);
		JsonObject feature = new JsonObject();
		JsonObject features = new JsonObject();
		features.addProperty("type", "minecraft:simple_block");
		JsonObject configs = new JsonObject();
		JsonObject toPlace = new JsonObject();
		toPlace.addProperty("type", "minecraft:simple_state_provider");
		JsonObject state = new JsonObject();
		state.addProperty("Name", BuiltInRegistries.BLOCK.getKey(flower).toString());
		toPlace.add("state", state);
		configs.add("to_place", toPlace);
		features.add("config", configs);
		feature.add("feature", features);
		JsonArray placement = new JsonArray();
		JsonObject type = new JsonObject();
		type.addProperty("type", "minecraft:block_predicate_filter");
		JsonObject predicate = new JsonObject();
		predicate.addProperty("type", "minecraft:matching_blocks");
		predicate.addProperty("blocks", "minecraft:air");
		type.add("predicate", predicate);
		placement.add(type);
		feature.add("placement", placement);
		config.add("feature", feature);
		return config;
	}
}
