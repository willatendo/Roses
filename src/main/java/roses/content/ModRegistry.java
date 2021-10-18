package roses.content;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry 
{
	public static final Block ROSE = blockAndItemBuilder("rose", new FlowerBlock(Effects.LUCK, 13, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_ROSE = blockBuilder("potted_rose", new FlowerPotBlock(ROSE, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	public static final Block CYAN_FLOWER = blockAndItemBuilder("cyan_flower", new FlowerBlock(Effects.CONDUIT_POWER, 3, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_CYAN_FLOWER = blockBuilder("potted_cyan_flower", new FlowerPotBlock(CYAN_FLOWER, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	
	public static Block blockAndItemBuilder(String id, Block block)
	{
		BlockItem item = new BlockItem(block, new Properties().tab(ItemGroup.TAB_DECORATIONS));
		TyrannoRegister.registerBlock(id, block);
		TyrannoRegister.registerItem(id, item);
		return block;
	}
	
	public static Block blockBuilder(String id, Block block)
	{
		TyrannoRegister.registerBlock(id, block);
		return block;
	}
	
	public static void registry() { }
}
