package roses.content;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;

public class ModUtils 
{
    public static final Logger LOGGER = LogManager.getLogger(ModUtils.ID);

    public static final String ID = "roses";
    
    public static ResourceLocation rL(String path)
    {
    	return new ResourceLocation(ID, path);
    }
}
