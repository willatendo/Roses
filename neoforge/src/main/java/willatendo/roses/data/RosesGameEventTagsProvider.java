package willatendo.roses.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.GameEventTagsProvider;
import net.minecraft.tags.GameEventTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.roses.server.gameevent.RosesGameEvents;

import java.util.concurrent.CompletableFuture;

public class RosesGameEventTagsProvider extends GameEventTagsProvider {
    public RosesGameEventTagsProvider(PackOutput packOutput, CompletableFuture<Provider> registries, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(GameEventTags.VIBRATIONS).add(RosesGameEvents.COG_RUMBLES.get());
        this.tag(GameEventTags.WARDEN_CAN_LISTEN).add(RosesGameEvents.COG_RUMBLES.get());
    }
}
