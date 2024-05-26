package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import willatendo.roses.client.sound.RosesSounds;
import willatendo.roses.server.util.RosesUtils;

public class RosesSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public RosesSoundDefinitionsProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        this.add(RosesSounds.MAGNETIC_CIRCUIT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("disc.sound.magnetic_circuit"))));
        this.add(RosesSounds.COG_RUMBLES.get(), SoundDefinition.definition().subtitle(RosesUtils.translation("sound", "cog_rumbles").getString()).with(this.sound(RosesUtils.resource("cog.rumbles"))));
    }
}
