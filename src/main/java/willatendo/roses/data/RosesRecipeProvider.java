package willatendo.roses.data;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;

public class RosesRecipeProvider extends RecipeProvider {
	public static final ImmutableList<ItemLike> RUBY_SMELTABLES = ImmutableList.of(RosesBlocks.RUBY_ORE.get(), RosesBlocks.DEEPSLATE_RUBY_ORE.get());

	public RosesRecipeProvider(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	public void buildRecipes(RecipeOutput recipeOutput) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RosesItems.RUBY.get(), 9).requires(RosesBlocks.RUBY_BLOCK.get()).unlockedBy(getHasName(RosesBlocks.RUBY_BLOCK.get()), has(RosesBlocks.RUBY_BLOCK.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesItems.RUBY.get())));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.RUBY_BLOCK.get()).define('#', RosesItems.RUBY.get()).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(RosesItems.RUBY.get()), has(RosesItems.RUBY.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.RUBY_BLOCK.get())));
		oreSmelting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, RosesItems.RUBY.get(), 1.0F, 200, "ruby");
		oreBlasting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, RosesItems.RUBY.get(), 1.0F, 100, "ruby");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get()).pattern("###").pattern("$#@").pattern("###").define('#', Items.IRON_INGOT).define('$', RosesBlocks.RUBY_BLOCK.get()).define('@', Blocks.LAPIS_BLOCK).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE, 2).requires(RosesBlocks.ROSE.get()).unlockedBy(getHasName(RosesBlocks.ROSE.get()), has(RosesBlocks.ROSE.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(Items.RED_DYE) + "_from_rose"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE, 2).requires(RosesBlocks.CYAN_FLOWER.get()).unlockedBy(getHasName(RosesBlocks.CYAN_FLOWER.get()), has(RosesBlocks.CYAN_FLOWER.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(Items.CYAN_DYE) + "_from_cyan_flower"));
		chair(recipeOutput, RosesBlocks.OAK_CHAIR.get(), Blocks.OAK_PLANKS);
		chair(recipeOutput, RosesBlocks.SPRUCE_CHAIR.get(), Blocks.SPRUCE_PLANKS);
		chair(recipeOutput, RosesBlocks.BIRCH_CHAIR.get(), Blocks.BIRCH_PLANKS);
		chair(recipeOutput, RosesBlocks.JUNGLE_CHAIR.get(), Blocks.JUNGLE_PLANKS);
		chair(recipeOutput, RosesBlocks.ACACIA_CHAIR.get(), Blocks.ACACIA_PLANKS);
		chair(recipeOutput, RosesBlocks.DARK_OAK_CHAIR.get(), Blocks.DARK_OAK_PLANKS);
		chair(recipeOutput, RosesBlocks.CRIMSON_CHAIR.get(), Blocks.CRIMSON_PLANKS);
		chair(recipeOutput, RosesBlocks.WARPED_CHAIR.get(), Blocks.WARPED_PLANKS);
		chair(recipeOutput, RosesBlocks.MANGROVE_CHAIR.get(), Blocks.MANGROVE_PLANKS);
		chair(recipeOutput, RosesBlocks.CHERRY_CHAIR.get(), Blocks.CHERRY_PLANKS);
		chair(recipeOutput, RosesBlocks.BAMBOO_CHAIR.get(), Blocks.BAMBOO_PLANKS, Items.BAMBOO);
		table(recipeOutput, RosesBlocks.OAK_TABLE.get(), Blocks.OAK_PLANKS);
		table(recipeOutput, RosesBlocks.SPRUCE_TABLE.get(), Blocks.SPRUCE_PLANKS);
		table(recipeOutput, RosesBlocks.BIRCH_TABLE.get(), Blocks.BIRCH_PLANKS);
		table(recipeOutput, RosesBlocks.JUNGLE_TABLE.get(), Blocks.JUNGLE_PLANKS);
		table(recipeOutput, RosesBlocks.ACACIA_TABLE.get(), Blocks.ACACIA_PLANKS);
		table(recipeOutput, RosesBlocks.DARK_OAK_TABLE.get(), Blocks.DARK_OAK_PLANKS);
		table(recipeOutput, RosesBlocks.CRIMSON_TABLE.get(), Blocks.CRIMSON_PLANKS);
		table(recipeOutput, RosesBlocks.WARPED_TABLE.get(), Blocks.WARPED_PLANKS);
		table(recipeOutput, RosesBlocks.MANGROVE_TABLE.get(), Blocks.MANGROVE_PLANKS);
		table(recipeOutput, RosesBlocks.CHERRY_TABLE.get(), Blocks.CHERRY_PLANKS);
		table(recipeOutput, RosesBlocks.BAMBOO_TABLE.get(), Blocks.BAMBOO_PLANKS, Items.BAMBOO);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RosesBlocks.COG.get()).pattern(" # ").pattern("#$#").pattern(" # ").define('#', Items.IRON_INGOT).define('$', Items.ECHO_SHARD).unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD)).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.COG.get())));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.CAPRI_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.CAPRI_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.CHARTREUSE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIME_DYE).requires(Items.YELLOW_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.CHARTREUSE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.CYAN_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).requires(Items.WHITE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.CYAN_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.DARK_GRAY_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.DARK_GRAY_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.GREEN_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIME_DYE).requires(Items.GREEN_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.GREEN_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.LIGHT_GRAY_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.LIGHT_GRAY_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.MAGNETA_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PINK_DYE).requires(Items.MAGENTA_DYE).requires(Items.RED_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.MAGNETA_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.ORANGE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.ORANGE_DYE).requires(Items.GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.ORANGE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.PURPLE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.MAGENTA_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.PURPLE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.RED_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.MAGENTA_DYE).requires(Items.RED_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.RED_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.ROSE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).requires(Items.WHITE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.ROSE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.SPRING_GREEN_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.RED_DYE).requires(Items.PINK_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.SPRING_GREEN_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.ULTRAMARINE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PINK_DYE).requires(Items.PURPLE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.ULTRAMARINE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.VIOLET_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.PURPLE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.VIOLET_CLOTH.get())));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.WHITE_CLOTH.get()).group("cloth").pattern("###").pattern("###").pattern("###").define('#', Items.STRING).unlockedBy(getHasName(Items.STRING), has(Items.STRING)).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.WHITE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.YELLOW_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.YELLOW_DYE).requires(Items.GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.YELLOW_CLOTH.get())));
	}

	public static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ores, RecipeCategory recipeCategory, ItemLike output, float experience, int smeltTime, String name) {
		oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ores, recipeCategory, output, experience, smeltTime, name, "_from_smelting");
	}

	public static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ores, RecipeCategory recipeCategory, ItemLike output, float experience, int smeltTime, String name) {
		oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ores, recipeCategory, output, experience, smeltTime, name, "_from_blasting");
	}

	public static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> recipeSerializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> ores, RecipeCategory recipeCategory, ItemLike output, float experience, int smeltTime, String group, String type) {
		for (ItemLike itemlike : ores) {
			SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), recipeCategory, output, experience, smeltTime, recipeSerializer, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike)).save(recipeOutput, RosesUtils.resource(getItemName(output) + type + "_" + getItemName(itemlike)));
		}
	}

	public static void chair(RecipeOutput recipeOutput, Block chair, Block planks) {
		chair(recipeOutput, chair, planks, Items.STICK);
	}

	public static void chair(RecipeOutput recipeOutput, Block chair, Block planks, Item stick) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, chair).pattern("#  ").pattern("###").pattern("@ @").define('#', planks).define('@', stick).group("chair").unlockedBy(getHasName(planks), has(planks)).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(chair)));
	}

	public static void table(RecipeOutput recipeOutput, Block table, Block planks) {
		table(recipeOutput, table, planks, Items.STICK);
	}

	public static void table(RecipeOutput recipeOutput, Block table, Block planks, Item stick) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, table).pattern("###").pattern("@@@").pattern("@ @").define('#', planks).define('@', stick).group("table").unlockedBy(getHasName(planks), has(planks)).save(recipeOutput, RosesUtils.resource(getSimpleRecipeName(table)));
	}
}
