package roses.content;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import roses.content.config.RosesConfig;
import roses.content.server.ServerConfig;

public class ModUtils {
	public static final Logger LOGGER = LogManager.getLogger(ModUtils.ID);

	public static final String ID = "roses";

	public static final ServerConfig COMMON_CONFIG = RosesConfig.COMMON_CONFIG;

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}
}
