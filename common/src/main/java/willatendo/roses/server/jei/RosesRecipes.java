package willatendo.roses.server.jei;

import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import willatendo.roses.server.RosesBuiltInRegistries;
import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.roses.server.item.RosesCopperHornInstruments;
import willatendo.roses.server.item.RosesDataComponents;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RosesRecipes {
    private final RecipeManager recipeManager;

    public RosesRecipes(IIngredientManager iIngredientManager) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        this.recipeManager = clientLevel.getRecipeManager();
    }

    public static List<RecipeHolder<CraftingRecipe>> createCopperHornRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();
        Map<CopperHornInstrument, Holder<Instrument>> inverse = new HashMap<>();
        RosesCopperHornInstruments.getInstruments().forEach(((instrumentResourceKey, copperHornInstrument) -> {
            inverse.put(copperHornInstrument, BuiltInRegistries.INSTRUMENT.getHolder(instrumentResourceKey).get());
        }));
        for (Holder<CopperHornInstrument> copperHornInstrument : RosesBuiltInRegistries.COPPER_HORN_INSTRUMENTS.asHolderIdMap()) {
            ItemStack copperHorn = new ItemStack(RosesItems.COPPER_HORN.get());
            copperHorn.set(RosesDataComponents.COPPER_HORN_INSTRUMENT.get(), copperHornInstrument);
            ItemStack goatHorn = new ItemStack(Items.GOAT_HORN);
            goatHorn.set(DataComponents.INSTRUMENT, inverse.get(copperHornInstrument.value()));
            recipes.add(new RecipeHolder<>(RosesUtils.resource("copper_horn_" + RosesBuiltInRegistries.COPPER_HORN_INSTRUMENTS.getKey(copperHornInstrument.value()).getPath()), new ShapedRecipe("magic_conch", CraftingBookCategory.MISC, ShapedRecipePattern.of(Map.of('#', Ingredient.of(Items.COPPER_INGOT), '@', Ingredient.of(goatHorn)), "#@#", " # "), copperHorn)));
        }

        return recipes;
    }
}
