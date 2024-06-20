package willatendo.roses.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.data.SimpleRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class RosesRecipeProvider extends SimpleRecipeProvider {
    public RosesRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(packOutput, registries, modId);
    }

    @Override
    public void addRecipes() {
        this.shapeless(RecipeCategory.MISC, RosesItems.RUBY.get(), 9, IngredientBuilder.build(RosesBlocks.RUBY_BLOCK.get()).requires());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, RosesBlocks.RUBY_BLOCK.get(), PatternBuilder.builder("###", "###", "###"), IngredientBuilder.build(RosesItems.RUBY.get()).symbol('#').requires());
        this.oreWithName("ruby_from_ore", RosesItems.RUBY.get(), RosesBlocks.RUBY_ORE.get(), 1.0F);
        this.oreWithName("ruby_from_deepslate", RosesItems.RUBY.get(), RosesBlocks.DEEPSLATE_RUBY_ORE.get(), 1.0F);
        this.shaped(RecipeCategory.DECORATIONS, RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get(), PatternBuilder.builder("###", "$#@", "###"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#').requires(), IngredientBuilder.build(RosesBlocks.RUBY_BLOCK.get()).symbol('$'), IngredientBuilder.build(Blocks.LAPIS_BLOCK).symbol('@'));
        this.shapeless("red_dye_from_rose", RecipeCategory.MISC, Items.RED_DYE, 2, IngredientBuilder.build(RosesBlocks.ROSE.get()));
        this.shapeless("cyan_dye_from_cyan_flower", RecipeCategory.MISC, Items.CYAN_DYE, 2, IngredientBuilder.build(RosesBlocks.CYAN_FLOWER.get()));
        this.chair(RosesBlocks.OAK_CHAIR.get(), Blocks.OAK_PLANKS);
        this.chair(RosesBlocks.SPRUCE_CHAIR.get(), Blocks.SPRUCE_PLANKS);
        this.chair(RosesBlocks.BIRCH_CHAIR.get(), Blocks.BIRCH_PLANKS);
        this.chair(RosesBlocks.JUNGLE_CHAIR.get(), Blocks.JUNGLE_PLANKS);
        this.chair(RosesBlocks.ACACIA_CHAIR.get(), Blocks.ACACIA_PLANKS);
        this.chair(RosesBlocks.DARK_OAK_CHAIR.get(), Blocks.DARK_OAK_PLANKS);
        this.chair(RosesBlocks.CRIMSON_CHAIR.get(), Blocks.CRIMSON_PLANKS);
        this.chair(RosesBlocks.WARPED_CHAIR.get(), Blocks.WARPED_PLANKS);
        this.chair(RosesBlocks.MANGROVE_CHAIR.get(), Blocks.MANGROVE_PLANKS);
        this.chair(RosesBlocks.CHERRY_CHAIR.get(), Blocks.CHERRY_PLANKS);
        this.chair(RosesBlocks.BAMBOO_CHAIR.get(), Blocks.BAMBOO_PLANKS, Items.BAMBOO);
        this.table(RosesBlocks.OAK_TABLE.get(), Blocks.OAK_PLANKS);
        this.table(RosesBlocks.SPRUCE_TABLE.get(), Blocks.SPRUCE_PLANKS);
        this.table(RosesBlocks.BIRCH_TABLE.get(), Blocks.BIRCH_PLANKS);
        this.table(RosesBlocks.JUNGLE_TABLE.get(), Blocks.JUNGLE_PLANKS);
        this.table(RosesBlocks.ACACIA_TABLE.get(), Blocks.ACACIA_PLANKS);
        this.table(RosesBlocks.DARK_OAK_TABLE.get(), Blocks.DARK_OAK_PLANKS);
        this.table(RosesBlocks.CRIMSON_TABLE.get(), Blocks.CRIMSON_PLANKS);
        this.table(RosesBlocks.WARPED_TABLE.get(), Blocks.WARPED_PLANKS);
        this.table(RosesBlocks.MANGROVE_TABLE.get(), Blocks.MANGROVE_PLANKS);
        this.table(RosesBlocks.CHERRY_TABLE.get(), Blocks.CHERRY_PLANKS);
        this.table(RosesBlocks.BAMBOO_TABLE.get(), Blocks.BAMBOO_PLANKS, Items.BAMBOO);
        this.shaped(RecipeCategory.REDSTONE, RosesBlocks.COG.get(), PatternBuilder.builder(" # ", "#$#", " # "), IngredientBuilder.build(Items.IRON_INGOT).symbol('#'), IngredientBuilder.build(Items.ECHO_SHARD).symbol('$').requires());

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.CAPRI_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.LIGHT_BLUE_DYE), IngredientBuilder.build(Items.WHITE_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.CHARTREUSE_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.LIME_DYE), IngredientBuilder.build(Items.YELLOW_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.CYAN_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.LIGHT_BLUE_DYE), IngredientBuilder.build(Items.WHITE_DYE), IngredientBuilder.build(Items.WHITE_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.DARK_GRAY_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.GRAY_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.GREEN_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.LIME_DYE), IngredientBuilder.build(Items.GREEN_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.LIGHT_GRAY_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.LIGHT_GRAY_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.MAGENTA_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.PINK_DYE), IngredientBuilder.build(Items.MAGENTA_DYE), IngredientBuilder.build(Items.RED_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.ORANGE_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.ORANGE_DYE), IngredientBuilder.build(Items.GRAY_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.PURPLE_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.PURPLE_DYE), IngredientBuilder.build(Items.MAGENTA_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.RED_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.PURPLE_DYE), IngredientBuilder.build(Items.MAGENTA_DYE), IngredientBuilder.build(Items.RED_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.ROSE_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.LIGHT_BLUE_DYE), IngredientBuilder.build(Items.WHITE_DYE), IngredientBuilder.build(Items.WHITE_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.SPRING_GREEN_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.RED_DYE), IngredientBuilder.build(Items.PINK_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.ULTRAMARINE_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.PINK_DYE), IngredientBuilder.build(Items.PURPLE_DYE));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.VIOLET_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.PURPLE_DYE), IngredientBuilder.build(Items.PURPLE_DYE));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.WHITE_CLOTH.get(), PatternBuilder.builder("###", "###", "###"), IngredientBuilder.build(Items.STRING).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "cloth", RosesBlocks.YELLOW_CLOTH.get(), IngredientBuilder.build(RosesBlocks.WHITE_CLOTH.get()).requires(), IngredientBuilder.build(Items.YELLOW_DYE), IngredientBuilder.build(Items.GRAY_DYE));
    }

    public void chair(Block chair, Block planks) {
        chair(chair, planks, Items.STICK);
    }

    public void chair(Block chair, Block planks, Item stick) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "chair", chair, PatternBuilder.builder("#  ", "###", "@ @"), IngredientBuilder.build(planks).symbol('#').requires(), IngredientBuilder.build(stick).symbol('@'));
    }

    public void table(Block table, Block planks) {
        table(table, planks, Items.STICK);
    }

    public void table(Block table, Block planks, Item stick) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "table", table, PatternBuilder.builder("###", "@@@", "@ @"), IngredientBuilder.build(planks).symbol('#').requires(), IngredientBuilder.build(stick).symbol('@'));
    }

    public void oreWithName(String name, ItemLike output, ItemLike input, float experience) {
        SimpleCookingRecipeBuilder smeltingRecipeBuilder = SimpleCookingRecipeBuilder.smelting(Ingredient.of(new ItemLike[]{input}), RecipeCategory.FOOD, output, experience, 200).unlockedBy(getHasName(input), has(input));
        SimpleCookingRecipeBuilder blastingRecipeBuilder = SimpleCookingRecipeBuilder.blasting(Ingredient.of(new ItemLike[]{input}), RecipeCategory.FOOD, output, experience, 100).unlockedBy(getHasName(input), has(input));

        this.recipeBuilders.put(name + "_from_smelting", smeltingRecipeBuilder);
        this.recipeBuilders.put(name + "_from_blasting", blastingRecipeBuilder);
    }
}
