package roses.content;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import roses.content.config.RosesConfig;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry 
{
	public static final Block ROSE = new FlowerBlock(Effects.LUCK, 13, AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.GRASS));
	public static final Block POTTED_ROSE = new FlowerPotBlock(ROSE, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion());

	public static final Block CYAN_FLOWER = new FlowerBlock(Effects.CONDUIT_POWER, 3, AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.GRASS));
	public static final Block POTTED_CYAN_FLOWER = new FlowerPotBlock(ROSE, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion());
	
	public static void registry()
	{
		if(RosesConfig.COMMON_CONFIG.enableRoses.get())
		{
			TyrannoRegister.registerBlock("rose", ROSE);
			TyrannoRegister.registerBlock("potted_rose", POTTED_ROSE);
			TyrannoRegister.registerItem("rose", new BlockItem(ROSE, new Properties().tab(ItemGroup.TAB_DECORATIONS)));
		}
		if(RosesConfig.COMMON_CONFIG.enableCyanFlowers.get())
		{
			TyrannoRegister.registerBlock("cyan_flower", CYAN_FLOWER);
			TyrannoRegister.registerBlock("potted_cyan_flower", POTTED_CYAN_FLOWER);
			TyrannoRegister.registerItem("cyan_flower", new BlockItem(CYAN_FLOWER, new Properties().tab(ItemGroup.TAB_DECORATIONS)));
		}
	}
}
