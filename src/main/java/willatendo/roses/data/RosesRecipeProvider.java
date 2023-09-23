package willatendo.roses.data;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableList;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
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
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RosesItems.RUBY.get(), 9).requires(RosesBlocks.RUBY_BLOCK.get()).unlockedBy(getHasName(RosesBlocks.RUBY_BLOCK.get()), has(RosesBlocks.RUBY_BLOCK.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesItems.RUBY.get())));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.RUBY_BLOCK.get()).define('#', RosesItems.RUBY.get()).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(RosesItems.RUBY.get()), has(RosesItems.RUBY.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.RUBY_BLOCK.get())));
		oreSmelting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, RosesItems.RUBY.get(), 1.0F, 200, "ruby");
		oreBlasting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, RosesItems.RUBY.get(), 1.0F, 100, "ruby");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get()).pattern("###").pattern("$#@").pattern("###").define('#', Items.IRON_INGOT).define('$', RosesBlocks.RUBY_BLOCK.get()).define('@', Blocks.LAPIS_BLOCK).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get())));
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
		table(consumer, RosesBlocks.OAK_TABLE.get(), Blocks.OAK_PLANKS);
		table(consumer, RosesBlocks.SPRUCE_TABLE.get(), Blocks.SPRUCE_PLANKS);
		table(consumer, RosesBlocks.BIRCH_TABLE.get(), Blocks.BIRCH_PLANKS);
		table(consumer, RosesBlocks.JUNGLE_TABLE.get(), Blocks.JUNGLE_PLANKS);
		table(consumer, RosesBlocks.ACACIA_TABLE.get(), Blocks.ACACIA_PLANKS);
		table(consumer, RosesBlocks.DARK_OAK_TABLE.get(), Blocks.DARK_OAK_PLANKS);
		table(consumer, RosesBlocks.CRIMSON_TABLE.get(), Blocks.CRIMSON_PLANKS);
		table(consumer, RosesBlocks.WARPED_TABLE.get(), Blocks.WARPED_PLANKS);
		table(consumer, RosesBlocks.MANGROVE_TABLE.get(), Blocks.MANGROVE_PLANKS);
		table(consumer, RosesBlocks.CHERRY_TABLE.get(), Blocks.CHERRY_PLANKS);
		table(consumer, RosesBlocks.BAMBOO_TABLE.get(), Blocks.BAMBOO_PLANKS, Items.BAMBOO);
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RosesBlocks.COG.get()).pattern(" # ").pattern("#$#").pattern(" # ").define('#', Items.IRON_INGOT).define('$', Items.ECHO_SHARD).unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD)).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.COG.get())));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.CAPRI_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.CAPRI_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.CHARTREUSE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIME_DYE).requires(Items.YELLOW_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.CHARTREUSE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.CYAN_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).requires(Items.WHITE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.CYAN_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.DARK_GRAY_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.DARK_GRAY_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.GREEN_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIME_DYE).requires(Items.GREEN_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.GREEN_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.LIGHT_GRAY_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.LIGHT_GRAY_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.MAGNETA_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PINK_DYE).requires(Items.MAGENTA_DYE).requires(Items.RED_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.MAGNETA_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.ORANGE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.ORANGE_DYE).requires(Items.GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.ORANGE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.PURPLE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.MAGENTA_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.PURPLE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.RED_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.MAGENTA_DYE).requires(Items.RED_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.RED_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.ROSE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).requires(Items.WHITE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.ROSE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.SPRING_GREEN_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.RED_DYE).requires(Items.PINK_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.SPRING_GREEN_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.ULTRAMARINE_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PINK_DYE).requires(Items.PURPLE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.ULTRAMARINE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.VIOLET_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.PURPLE_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.VIOLET_CLOTH.get())));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.WHITE_CLOTH.get()).group("cloth").pattern("###").pattern("###").pattern("###").define('#', Items.STRING).unlockedBy(getHasName(Items.STRING), has(Items.STRING)).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.WHITE_CLOTH.get())));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.YELLOW_CLOTH.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.YELLOW_DYE).requires(Items.GRAY_DYE).unlockedBy(getHasName(RosesBlocks.WHITE_CLOTH.get()), has(RosesBlocks.WHITE_CLOTH.get())).save(consumer, RosesUtils.resource(getSimpleRecipeName(RosesBlocks.YELLOW_CLOTH.get())));
	}

	protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> ores, RecipeCategory recipeCategory, ItemLike output, float experience, int smeltTime, String name) {
		oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, ores, recipeCategory, output, experience, smeltTime, name, "_from_smelting");
	}

	protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> ores, RecipeCategory recipeCategory, ItemLike output, float experience, int smeltTime, String name) {
		oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, ores, recipeCategory, output, experience, smeltTime, name, "_from_blasting");
	}

	protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerializer, List<ItemLike> ores, RecipeCategory recipeCategory, ItemLike output, float experience, int smeltTime, String group, String type) {
		for (ItemLike itemlike : ores) {
			SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), recipeCategory, output, experience, smeltTime, recipeSerializer).group(group).unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, RosesUtils.resource(getItemName(output) + type + "_" + getItemName(itemlike)));
		}
	}

	public static void chair(Consumer<FinishedRecipe> consumer, Block chair, Block planks) {
		chair(consumer, chair, planks, Items.STICK);
	}

	public static void chair(Consumer<FinishedRecipe> consumer, Block chair, Block planks, Item stick) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, chair).pattern("#  ").pattern("###").pattern("@ @").define('#', planks).define('@', stick).group("chair").unlockedBy(getHasName(planks), has(planks)).save(consumer, RosesUtils.resource(getSimpleRecipeName(chair)));
	}

	public static void table(Consumer<FinishedRecipe> consumer, Block table, Block planks) {
		table(consumer, table, planks, Items.STICK);
	}

	public static void table(Consumer<FinishedRecipe> consumer, Block table, Block planks, Item stick) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, table).pattern("###").pattern("@@@").pattern("@ @").define('#', planks).define('@', stick).group("table").unlockedBy(getHasName(planks), has(planks)).save(consumer, RosesUtils.resource(getSimpleRecipeName(table)));
	}
}
