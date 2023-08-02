package willatendo.roses.data;

import com.google.gson.JsonObject;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import willatendo.simplelibrary.data.SimplePlacedFeatureProvider;

public class RosesPlacedFeatureProvider extends SimplePlacedFeatureProvider {
	public RosesPlacedFeatureProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void allConfiguredFeatures() {
		this.simpleConfiguredFeature("", getName(), null);
	}

	public JsonObject flowerPatch(Block flower) {
		JsonObject config = new JsonObject();
		return config;
	}
}
