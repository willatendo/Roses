package willatendo.roses.server.recipe.serializer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import willatendo.roses.server.recipe.CopperHornRecipe;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesRecipeSerializers {
    public static final SimpleRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = SimpleRegistry.create(Registries.RECIPE_SERIALIZER, RosesUtils.ID);

    public static final SimpleHolder<RecipeSerializer<CopperHornRecipe>> COPPER_HORN = RECIPE_SERIALIZERS.register("copper_horn", () -> new SimpleCraftingRecipeSerializer<>(CopperHornRecipe::new));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(RECIPE_SERIALIZERS);
    }
}
