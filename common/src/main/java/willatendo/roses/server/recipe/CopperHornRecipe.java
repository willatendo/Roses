package willatendo.roses.server.recipe;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import willatendo.roses.server.item.RosesCopperHornInstruments;
import willatendo.roses.server.item.RosesDataComponents;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.recipe.serializer.RosesRecipeSerializers;

public class CopperHornRecipe extends CustomRecipe {
    public CopperHornRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        if (!this.canCraftInDimensions(craftingInput.width(), craftingInput.height())) {
            return false;
        } else {
            if (craftingInput.getItem(0).is(Items.COPPER_INGOT) && craftingInput.getItem(1).is(Items.GOAT_HORN) && craftingInput.getItem(2).is(Items.COPPER_INGOT) && craftingInput.getItem(3).isEmpty() && craftingInput.getItem(4).is(Items.COPPER_INGOT) && craftingInput.getItem(5).isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        ItemStack goatHorn = ItemStack.EMPTY;
        ItemStack copperHorn = new ItemStack(RosesItems.COPPER_HORN.get());
        if (craftingInput.getItem(1).is(Items.GOAT_HORN)) {
            goatHorn = craftingInput.getItem(1);
        } else if (craftingInput.getItem(4).is(Items.GOAT_HORN)) {
            goatHorn = craftingInput.getItem(4);
        }
        Holder<Instrument> instrument = goatHorn.get(DataComponents.INSTRUMENT);
        copperHorn.set(RosesDataComponents.COPPER_HORN_INSTRUMENT.get(), Holder.direct(RosesCopperHornInstruments.getInstruments().get(BuiltInRegistries.INSTRUMENT.getKey(instrument.value()))));
        return copperHorn;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 3 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RosesRecipeSerializers.COPPER_HORN.get();
    }
}
