package willatendo.roses;

import willatendo.roses.client.sound.RosesSounds;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.block.entity.RosesBlockEntities;
import willatendo.roses.server.entity.RosesEntities;
import willatendo.roses.server.gameevent.RosesGameEvents;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesMod {
    public static void onInitialize(List<SimpleRegistry<?>> simpleRegistries) {
        RosesSounds.init(simpleRegistries);
        RosesGameEvents.init(simpleRegistries);
        RosesBlocks.init(simpleRegistries);
        RosesItems.init(simpleRegistries);
        RosesBlockEntities.init(simpleRegistries);
        RosesCreativeModeTabs.init(simpleRegistries);
        RosesEntities.init(simpleRegistries);
    }
}
