package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import willatendo.roses.client.sound.RosesSounds;
import willatendo.roses.server.util.RosesUtils;

public class RosesSoundDefinitionsProvider extends SoundDefinitionsProvider {
	public RosesSoundDefinitionsProvider(PackOutput packOutput, String modid, ExistingFileHelper existingFileHelpere) {
		super(packOutput, modid, existingFileHelpere);
	}

	@Override
	public void registerSounds() {
		this.add(RosesSounds.MAGNETIC_CIRCUIT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("disc.sound.magnetic_circuit"))));
		this.add(RosesSounds.BEACH.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("music.sound.beach"))));
		this.add(RosesSounds.BIRCH_FOREST.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("music.sound.birch_forest"))));
		this.add(RosesSounds.DEEP_DARK.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("music.sound.deep_dark"))));
	}
}
