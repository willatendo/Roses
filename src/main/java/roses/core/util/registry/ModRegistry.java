package roses.core.util.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import roses.core.init.BlockInit;
import roses.core.init.ItemInit;
import roses.core.util.ModID;
import roses.world.init.BiomeInit;

public class ModRegistry 
{
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModID.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModID.ID);
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, ModID.ID);

	public static void registry()
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ITEM_REGISTRY.register(bus);
		BLOCK_REGISTRY.register(bus);
		BIOME_REGISTRY.register(bus);
		
		ItemInit.initItems();
		BlockInit.initBlocks();
		BiomeInit.initBiomes();
	}
}
