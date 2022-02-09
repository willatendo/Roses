package roses.content;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
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
import roses.library.block.ChairBlock;
import roses.library.entity.SittingEntity;
import tyrannotitanlib.library.item.block.TyrannoBurningBlockItem;
import tyrannotitanlib.tyranniregister.TyrannoRegister;

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

	public static final Block OAK_CHAIR = burningBlockAndItemBuilder("oak_chair", new ChairBlock(chair(MaterialColor.WOOD)));
	public static final Block SPRUCE_CHAIR = burningBlockAndItemBuilder("spruce_chair", new ChairBlock(chair(MaterialColor.PODZOL)));
	public static final Block BIRCH_CHAIR = burningBlockAndItemBuilder("birch_chair", new ChairBlock(chair(MaterialColor.SAND)));
	public static final Block JUNGLE_CHAIR = burningBlockAndItemBuilder("jungle_chair", new ChairBlock(chair(MaterialColor.DIRT)));
	public static final Block ACACIA_CHAIR = burningBlockAndItemBuilder("acacia_chair", new ChairBlock(chair(MaterialColor.COLOR_BROWN)));
	public static final Block DARK_OAK_CHAIR = burningBlockAndItemBuilder("dark_oak_chair", new ChairBlock(chair(MaterialColor.COLOR_BROWN)));
	public static final Block CRIMSON_CHAIR = blockAndItemBuilder("crimson_chair", new ChairBlock(chair(MaterialColor.CRIMSON_STEM)));
	public static final Block WARPED_CHAIR = blockAndItemBuilder("warped_chair", new ChairBlock(chair(MaterialColor.WARPED_STEM)));

	public static final EntityType<SittingEntity> CHAIR_ENTITY = entityBuilder("chair", EntityType.Builder.of(SittingEntity.factory, MobCategory.MISC).sized(0, 0).clientTrackingRange(256).updateInterval(20).sized(0.0001F, 0.0001F).build("chair"));

	public static BlockBehaviour.Properties chair(MaterialColor mapColour) {
		return BlockBehaviour.Properties.of(Material.WOOD, mapColour).strength(2.0F, 3.0F).sound(SoundType.WOOD);
	}

	public static Block blockAndItemBuilder(String id, Block block) {
		BlockItem item = new BlockItem(block, new Properties().tab(CreativeModeTab.TAB_DECORATIONS));
		TyrannoRegister.registerBlock(id, block);
		TyrannoRegister.registerItem(id, item);
		return block;
	}

	public static Block burningBlockAndItemBuilder(String id, Block block) {
		BlockItem item = new TyrannoBurningBlockItem(new Properties().tab(CreativeModeTab.TAB_DECORATIONS), block, 300);
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

	public static EntityType entityBuilder(String id, EntityType type) {
		TyrannoRegister.registerEntity(id, type);
		return type;
	}

	public static void registry() {
	}
}
