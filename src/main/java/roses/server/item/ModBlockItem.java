package roses.server.item;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import roses.server.block.BurningBlock;

public class ModBlockItem extends BlockItem {
	private Supplier<Block> block;

	public ModBlockItem(Supplier<Block> block, Properties properties) {
		super(null, properties);
		this.block = block;
	}

	@Override
	public Block getBlock() {
		return block.get();
	}

	@Override
	public int getBurnTime(ItemStack stack, RecipeType<?> recipeType) {
		return this.block.get() instanceof BurningBlock burning ? burning.getBurnTime() : super.getBurnTime(stack, recipeType);
	}
}
