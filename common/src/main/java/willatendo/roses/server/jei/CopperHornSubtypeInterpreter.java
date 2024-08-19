package willatendo.roses.server.jei;

import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.roses.server.item.RosesDataComponents;

public class CopperHornSubtypeInterpreter implements IIngredientSubtypeInterpreter<ItemStack> {
    public static final CopperHornSubtypeInterpreter INSTANCE = new CopperHornSubtypeInterpreter();

    private CopperHornSubtypeInterpreter() {
    }

    @Override
    public String apply(ItemStack itemStack, UidContext uidContext) {
        Holder<CopperHornInstrument> copperHornInstrument = itemStack.get(RosesDataComponents.COPPER_HORN_INSTRUMENT.get());
        return copperHornInstrument.value().useDuration() + "";
    }
}
