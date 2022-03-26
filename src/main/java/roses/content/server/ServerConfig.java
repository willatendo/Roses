package roses.content.server;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ServerConfig {
	protected static final String TRANSLATION_TEXT = "config.roses.";

	public final BooleanValue enableFlowerGeneration;
	public final ForgeConfigSpec.ConfigValue<List<? extends String>> flowerBiomes;

	public ServerConfig(ForgeConfigSpec.Builder builder) {
		enableFlowerGeneration = builder.comment("Sets if the flowers should be generated.").translation(TRANSLATION_TEXT + "enableFlowerGeneration").define("enableFlowerGeneration", true);
		flowerBiomes = builder.comment("Sets the biomes flower patches will spawn in.").translation(TRANSLATION_TEXT + "flowerBiomes").defineList("flowerBiomes", Lists.newArrayList("minecraft:plains", "minecraft:sunflower_plains", "minecraft:birch_forest", "minecraft:swamps"), o -> o instanceof String);
	}
}
