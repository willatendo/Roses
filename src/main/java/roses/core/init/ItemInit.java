package roses.core.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import roses.core.util.registry.ModRegistry;

public class ItemInit 
{
	//Rose
	public static final RegistryObject<BlockItem> ROSE = ModRegistry.ITEM_REGISTRY.register("rose", () -> new BlockItem(BlockInit.ROSE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	
	//Registry
	public static void initItems() { }
}
