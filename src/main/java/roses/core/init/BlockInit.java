package roses.core.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import roses.core.util.registry.ModRegistry;

@SuppressWarnings("deprecation")
public class BlockInit 
{
	//Rose
	public static final RegistryObject<FlowerBlock> ROSE = ModRegistry.BLOCK_REGISTRY.register("rose", () -> new FlowerBlock(Effects.LUCK, 9, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<FlowerPotBlock> POTTED_ROSE = ModRegistry.BLOCK_REGISTRY.register("potted_rose", () -> new FlowerPotBlock(ROSE.get(), AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	
	//Registry
	public static void initBlocks() { }
}
