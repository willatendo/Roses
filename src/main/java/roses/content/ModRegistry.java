package roses.content;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.effect.MobEffects;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry {
	public static final Block ROSE = blockAndItemBuilder("rose", new FlowerBlock(MobEffects.LUCK, 13, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_ROSE = blockBuilder("potted_rose", new FlowerPotBlock(ROSE, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	public static final Block CYAN_FLOWER = blockAndItemBuilder("cyan_flower", new FlowerBlock(MobEffects.CONDUIT_POWER, 3, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_CYAN_FLOWER = blockBuilder("potted_cyan_flower", new FlowerPotBlock(CYAN_FLOWER, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	public static Block blockAndItemBuilder(String id, Block block) {
		BlockItem item = new BlockItem(block, new Properties().tab(CreativeModeTab.TAB_DECORATIONS));
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
