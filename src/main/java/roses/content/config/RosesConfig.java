package roses.content.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import roses.content.server.ServerConfig;

public class RosesConfig {
	public static final ForgeConfigSpec commonSpec;
	public static final ServerConfig COMMON_CONFIG;

	static {
		final Pair<ServerConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
		commonSpec = commonSpecPair.getRight();
		COMMON_CONFIG = commonSpecPair.getLeft();
	}
}
