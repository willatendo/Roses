package roses.content.server;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ServerConfig {
	protected static final String TRANSLATION_TEXT = "lostworlds.config.";

	public final BooleanValue enableRosesGeneration;
	public final ForgeConfigSpec.ConfigValue<List<? extends String>> roseBiomes;

	public final BooleanValue enableCyanFlowersGeneration;
	public final ForgeConfigSpec.ConfigValue<List<? extends String>> cyanFlowerBiomes;

	public ServerConfig(ForgeConfigSpec.Builder builder) {
		enableRosesGeneration = builder.comment("Sets if the roses should be generated.").translation(TRANSLATION_TEXT + "enableRosesGeneration").define("enableRosesGeneration", true);
		roseBiomes = builder.comment("Sets the biomes rose patches will spawn in.").translation(TRANSLATION_TEXT + "roseBiomes").defineList("roseBiomes", Lists.newArrayList("minecraft:plains", "minecraft:sunflower_plains", "minecraft:birch_forest", "minecraft:birch_forest_hills"), o -> o instanceof String);

		enableCyanFlowersGeneration = builder.comment("Sets if the cyan flower should be generated.").translation(TRANSLATION_TEXT + "enableCyanFlowersGeneration").define("enableCyanFlowersGeneration", true);
		cyanFlowerBiomes = builder.comment("Sets the biomes cyan flower patches will spawn in.").translation(TRANSLATION_TEXT + "cyanFlowerBiomes").defineList("cyanFlowerBiomes", Lists.newArrayList("minecraft:swamp", "minecraft:swamp_hills", "minecraft:mountains"), o -> o instanceof String);
	}
}
