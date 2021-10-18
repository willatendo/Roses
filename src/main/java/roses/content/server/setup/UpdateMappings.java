package roses.content.server.setup;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import roses.content.ModUtils;

public class UpdateMappings 
{
	private static final Map<ResourceLocation, Biome> biomeRemappings = new HashMap<ResourceLocation, Biome>()
	{
		private static final long serialVersionUID = -6593770258230881293L;
		{
			put(ModUtils.rL("rose_plains"), BiomeRegistry.PLAINS);
		}
	};

	
	@SubscribeEvent
	public void biomeMappings(RegistryEvent.MissingMappings<Biome> event)
	{
		if(event.getAllMappings().stream().filter(m -> m.key.getNamespace().equals(ModUtils.ID)).findAny().isPresent())
		{
			event.getAllMappings().stream().filter(m -> m.key.getNamespace().equals(ModUtils.ID)).forEach(mappings -> 
			{
				if(biomeRemappings.containsKey(mappings.key))
				{
					remap(mappings, biomeRemappings);
				}
			});
		}
	}
	
	private <T extends IForgeRegistryEntry<T>> void remap(RegistryEvent.MissingMappings.Mapping<T> mapping, Map<ResourceLocation, T> remappings) 
	{
		ResourceLocation key = mapping.key;
		if(remappings.containsKey(key)) 
		{
			mapping.remap(remappings.get(key));
		} 
		else 
		{
			mapping.ignore();
		}
	}
}
