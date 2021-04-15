package roses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import roses.core.util.registry.ModRegistry;
import roses.world.init.BiomeInit;

@Mod("roses")
public class Roses
{
    public static final Logger LOGGER = LogManager.getLogger();

    public Roses() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        ModRegistry.registry();
        
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeInit::addBiomesToOverworld);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }
}
