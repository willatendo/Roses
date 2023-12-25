package willatendo.roses.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceLocation;
import willatendo.roses.client.sound.RosesSounds;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.data.SimpleSoundDefinitionsProvider;
import willatendo.simplelibrary.data.sounds.SoundDefinition;

public class RosesSoundDefinitionsProvider extends SimpleSoundDefinitionsProvider {
	public RosesSoundDefinitionsProvider(FabricDataOutput fabricDataOutput, String modid) {
		super(fabricDataOutput, modid);
	}

	@Override
	public void registerSounds() {
		this.add(RosesSounds.MAGNETIC_CIRCUIT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("disc.sound.magnetic_circuit"))));
		this.add(RosesSounds.COG_RUMBLES.get(), SoundDefinition.definition().subtitle(RosesUtils.translation("sound", "cog_rumbles").getString()).with(this.sound(new ResourceLocation("minecart.inside"))));
	}
}
