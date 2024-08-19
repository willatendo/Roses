package willatendo.roses.server.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;

@JeiPlugin
public class RosesJEI implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return RosesUtils.resource("roses_jei");
    }

    @Override
    public void registerRecipes(IRecipeRegistration iRecipeRegistration) {
        IIngredientManager iIngredientManager = iRecipeRegistration.getIngredientManager();

        RosesRecipes rosesRecipes = new RosesRecipes(iIngredientManager);

        iRecipeRegistration.addRecipes(RecipeTypes.CRAFTING, rosesRecipes.createCopperHornRecipes());
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration iSubtypeRegistration) {
        iSubtypeRegistration.registerSubtypeInterpreter(RosesItems.COPPER_HORN.get(), CopperHornSubtypeInterpreter.INSTANCE);
    }
}
