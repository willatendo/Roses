package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.GameEventTags;
import willatendo.roses.server.gameevent.RosesGameEvents;
import willatendo.simplelibrary.data.SimpleGameEventTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class RosesGameEventTagsProvider extends SimpleGameEventTagsProvider {
	public RosesGameEventTagsProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modid, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(GameEventTags.VIBRATIONS).add(RosesGameEvents.COG_RUMBLES.get());
		this.tag(GameEventTags.WARDEN_CAN_LISTEN).add(RosesGameEvents.COG_RUMBLES.get());
	}
}
