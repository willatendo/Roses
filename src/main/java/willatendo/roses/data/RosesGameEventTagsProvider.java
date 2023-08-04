package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.GameEventTagsProvider;
import net.minecraft.tags.GameEventTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.game_event.RosesGameEvents;

public class RosesGameEventTagsProvider extends GameEventTagsProvider {
	public RosesGameEventTagsProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(GameEventTags.VIBRATIONS).add(RosesGameEvents.COG_RUMBLES.get());
		this.tag(GameEventTags.WARDEN_CAN_LISTEN).add(RosesGameEvents.COG_RUMBLES.get());
	}
}
