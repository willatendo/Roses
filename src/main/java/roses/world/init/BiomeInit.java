package roses.world.init;

import java.util.function.Supplier;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import roses.core.util.ModID;
import roses.core.util.registry.ModRegistry;
import roses.world.biome.ModBiomeMaker;

public class BiomeInit 
{
	public static final RegistryObject<Biome> ROSE_PLAINS = createBiome("rose_plains", ModBiomeMaker::rosePlainsBiome);
	public static final RegistryKey<Biome> ROSE_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "rose_plains"));
	
	//Registry
    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) 
    {
        return ModRegistry.BIOME_REGISTRY.register(name, biome);
    }
    
    public static void initBiomes() { }
    
    //Generation
    public static void addBiomesToOverworld(BiomeLoadingEvent event)
    {
    	if (event.getName().equals(ROSE_PLAINS.get().getRegistryName())) 
    	{
    		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(ROSE_PLAINS_KEY, 1));
    		BiomeDictionary.addTypes(ROSE_PLAINS_KEY, Type.PLAINS, Type.RARE);
    	}
    }
}
