package willatendo.roses;

import willatendo.roses.server.RosesBuiltInRegistries;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.block.entity.RosesBlockEntities;
import willatendo.roses.server.entity.RosesEntities;
import willatendo.roses.server.gameevent.RosesGameEvents;
import willatendo.roses.server.item.RosesCopperHornInstruments;
import willatendo.roses.server.item.RosesDataComponents;
import willatendo.roses.server.item.RosesInstruments;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.recipe.serializer.RosesRecipeSerializers;
import willatendo.roses.server.sound.RosesSoundEvents;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesMod {
    public static void onInitialize(List<SimpleRegistry<?>> simpleRegistries) {
        RosesBuiltInRegistries.init();

        RosesRecipeSerializers.init(simpleRegistries);
        RosesSoundEvents.init(simpleRegistries);
        RosesGameEvents.init(simpleRegistries);
        RosesBlocks.init(simpleRegistries);
        RosesDataComponents.init(simpleRegistries);
        RosesInstruments.init(simpleRegistries);
        RosesCopperHornInstruments.init(simpleRegistries);
        RosesItems.init(simpleRegistries);
        RosesBlockEntities.init(simpleRegistries);
        RosesCreativeModeTabs.init(simpleRegistries);
        RosesEntities.init(simpleRegistries);
    }
}
