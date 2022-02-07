package roses.library.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class BurningBlockItem extends BlockItem {
	public BurningBlockItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
		return 300;
	}
}
