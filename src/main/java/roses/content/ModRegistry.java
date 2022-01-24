package roses.content;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry {
	public static final Block ROSE = blockAndItemBuilder("rose", new FlowerBlock(MobEffects.LUCK, 13, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_ROSE = blockBuilder("potted_rose", new FlowerPotBlock(ROSE, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	public static final Block CYAN_FLOWER = blockAndItemBuilder("cyan_flower", new FlowerBlock(MobEffects.CONDUIT_POWER, 3, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_CYAN_FLOWER = blockBuilder("potted_cyan_flower", new FlowerPotBlock(CYAN_FLOWER, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	private static final BlockBehaviour.Properties CLOTH_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.SNOW).strength(0.8F).sound(SoundType.WOOL);
	public static final Block CAPRI_CLOTH = blockAndItemBuilder("capri_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block CHARTRUESE_CLOTH = blockAndItemBuilder("chartruese_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block CYAN_CLOTH = blockAndItemBuilder("cyan_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block DARK_GRAY_CLOTH = blockAndItemBuilder("dark_gray_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block GREEN_CLOTH = blockAndItemBuilder("green_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block LIGHT_GRAY_CLOTH = blockAndItemBuilder("light_gray_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block MAGNETA_CLOTH = blockAndItemBuilder("magenta_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block ORANGE_CLOTH = blockAndItemBuilder("orange_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block PURPLE_CLOTH = blockAndItemBuilder("purple_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block RED_CLOTH = blockAndItemBuilder("red_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block ROSE_CLOTH = blockAndItemBuilder("rose_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block SPRING_GREEN_CLOTH = blockAndItemBuilder("spring_green_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block ULTRAMARINE_CLOTH = blockAndItemBuilder("ultramarine_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block VIOLET_CLOTH = blockAndItemBuilder("violet_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block WHITE_CLOTH = blockAndItemBuilder("white_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Block YELLOW_CLOTH = blockAndItemBuilder("yellow_cloth", new Block(CLOTH_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static Block blockAndItemBuilder(String id, Block block) {
		BlockItem item = new BlockItem(block, new Properties().tab(CreativeModeTab.TAB_DECORATIONS));
		TyrannoRegister.registerBlock(id, block);
		TyrannoRegister.registerItem(id, item);
		return block;
	}
	
	public static Block blockAndItemBuilder(String id, Block block, CreativeModeTab tab) {
		BlockItem item = new BlockItem(block, new Properties().tab(tab));
		TyrannoRegister.registerBlock(id, block);
		TyrannoRegister.registerItem(id, item);
		return block;
	}

	public static Block blockBuilder(String id, Block block) {
		TyrannoRegister.registerBlock(id, block);
		return block;
	}

	public static void registry() {
	}
}
