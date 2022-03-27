package roses.server.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import roses.server.events.ServerConfig;

public class RosesConfig {
	public static final ForgeConfigSpec commonSpec;
	public static final ServerConfig COMMON_CONFIG;

	static {
		final Pair<ServerConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
		commonSpec = commonSpecPair.getRight();
		COMMON_CONFIG = commonSpecPair.getLeft();
	}
}
