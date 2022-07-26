package roses.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.GameEventTagsProvider;
import net.minecraft.tags.GameEventTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import roses.RosesMod;
import roses.server.game_event.RosesGameEvents;

public class RosesGameEventsTags extends GameEventTagsProvider {
	public RosesGameEventsTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, RosesMod.ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(GameEventTags.VIBRATIONS).add(RosesGameEvents.COG_RUMBLES.get());
		this.tag(GameEventTags.WARDEN_CAN_LISTEN).add(RosesGameEvents.COG_RUMBLES.get());
	}
}
