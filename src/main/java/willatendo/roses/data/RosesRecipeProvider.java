package willatendo.roses.data;

import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;

public class RosesRecipeProvider extends RecipeProvider {
	public RosesRecipeProvider(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RosesItems.RUBY.get(), 9).requires(RosesBlocks.RUBY_BLOCK.get()).unlockedBy(getHasName(RosesBlocks.RUBY_BLOCK.get()), has(RosesBlocks.RUBY_BLOCK.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesItems.RUBY.get())));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.RUBY_BLOCK.get()).define('#', RosesItems.RUBY.get()).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(RosesItems.RUBY.get()), has(RosesItems.RUBY.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.RUBY_BLOCK.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE, 2).requires(RosesBlocks.ROSE.get()).unlockedBy(getHasName(RosesBlocks.ROSE.get()), has(RosesBlocks.ROSE.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(Items.RED_DYE) + "_from_rose"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE, 2).requires(RosesBlocks.CYAN_FLOWER.get()).unlockedBy(getHasName(RosesBlocks.CYAN_FLOWER.get()), has(RosesBlocks.CYAN_FLOWER.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(Items.CYAN_DYE) + "_from_cyan_flower"));
		chair(consumer, RosesBlocks.OAK_CHAIR.get(), Blocks.OAK_PLANKS);
		chair(consumer, RosesBlocks.SPRUCE_CHAIR.get(), Blocks.SPRUCE_PLANKS);
		chair(consumer, RosesBlocks.BIRCH_CHAIR.get(), Blocks.BIRCH_PLANKS);
		chair(consumer, RosesBlocks.JUNGLE_CHAIR.get(), Blocks.JUNGLE_PLANKS);
		chair(consumer, RosesBlocks.ACACIA_CHAIR.get(), Blocks.ACACIA_PLANKS);
		chair(consumer, RosesBlocks.DARK_OAK_CHAIR.get(), Blocks.DARK_OAK_PLANKS);
		chair(consumer, RosesBlocks.CRIMSON_CHAIR.get(), Blocks.CRIMSON_PLANKS);
		chair(consumer, RosesBlocks.WARPED_CHAIR.get(), Blocks.WARPED_PLANKS);
		chair(consumer, RosesBlocks.MANGROVE_CHAIR.get(), Blocks.MANGROVE_PLANKS);
		chair(consumer, RosesBlocks.CHERRY_CHAIR.get(), Blocks.CHERRY_PLANKS);
		chair(consumer, RosesBlocks.BAMBOO_CHAIR.get(), Blocks.BAMBOO_PLANKS, Items.BAMBOO);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RosesBlocks.COG.get()).pattern(" # ").pattern("# #").pattern(" # ").define('#', Items.IRON_INGOT).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.COG.get())));
	}

	public static void chair(Consumer<FinishedRecipe> consumer, Block chair, Block planks) {
		chair(consumer, chair, planks, Items.STICK);
	}

	public static void chair(Consumer<FinishedRecipe> consumer, Block chair, Block planks, Item stick) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, chair).pattern("#  ").pattern("###").pattern("@ @").define('#', planks).define('@', stick).unlockedBy(getHasName(planks), has(planks)).save(consumer, RosesUtils.resource(getSimpleRecipeName(chair)));
	}
}