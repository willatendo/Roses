package roses.server.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import roses.server.block.BurningBlock;

public class ModBlockItem extends BlockItem {
	public ModBlockItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getBurnTime(ItemStack stack, RecipeType<?> recipeType) {
		return this.getBlock() instanceof BurningBlock burning ? burning.getBurnTime() : super.getBurnTime(stack, recipeType);
	}
}
