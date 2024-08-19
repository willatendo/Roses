package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import willatendo.roses.server.sound.RosesSoundEvents;
import willatendo.roses.server.util.RosesUtils;

public class RosesSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public RosesSoundDefinitionsProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        this.add(RosesSoundEvents.MAGNETIC_CIRCUIT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("disc.sound.magnetic_circuit"))));
        this.add(RosesSoundEvents.DOG.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("disc.sound.dog"))));

        this.add(RosesSoundEvents.COG_RUMBLES.get(), SoundDefinition.definition().subtitle(RosesUtils.translation("sound", "cog_rumbles").getString()).with(this.sound(RosesUtils.resource("cog.rumbles"))));

        this.add(RosesSoundEvents.FLY.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.goat_horn.sound.call.8"))));
        this.add(RosesSoundEvents.RESIST.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.goat_horn.sound.call.9"))));

        this.add(RosesSoundEvents.GREAT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.0"))));
        this.add(RosesSoundEvents.SKY.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.0"))));
        this.add(RosesSoundEvents.FALLING.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.0"))));
        this.add(RosesSoundEvents.OLD.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.1"))));
        this.add(RosesSoundEvents.HYMN.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.1"))));
        this.add(RosesSoundEvents.RESTING.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.1"))));
        this.add(RosesSoundEvents.PURE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.2"))));
        this.add(RosesSoundEvents.WATER.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.2"))));
        this.add(RosesSoundEvents.DESIRE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.2"))));
        this.add(RosesSoundEvents.HUMBLE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.3"))));
        this.add(RosesSoundEvents.FIRE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.3"))));
        this.add(RosesSoundEvents.MEMORY.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.3"))));
        this.add(RosesSoundEvents.DRY.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.4"))));
        this.add(RosesSoundEvents.URGE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.4"))));
        this.add(RosesSoundEvents.ANGER.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.4"))));
        this.add(RosesSoundEvents.CLEAR.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.5"))));
        this.add(RosesSoundEvents.TEMPER.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.5"))));
        this.add(RosesSoundEvents.JOURNEY.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.5"))));
        this.add(RosesSoundEvents.FRESH.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.6"))));
        this.add(RosesSoundEvents.NEST.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.6"))));
        this.add(RosesSoundEvents.THOUGHT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.6"))));
        this.add(RosesSoundEvents.SECRET.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.7"))));
        this.add(RosesSoundEvents.LAKE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.7"))));
        this.add(RosesSoundEvents.TEAR.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.7"))));
        this.add(RosesSoundEvents.FEARLESS.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.8"))));
        this.add(RosesSoundEvents.RIVER.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.8"))));
        this.add(RosesSoundEvents.GIFT.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.8"))));
        this.add(RosesSoundEvents.SWEET.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.call.9"))));
        this.add(RosesSoundEvents.MOON.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.melody.9"))));
        this.add(RosesSoundEvents.LOVE.get(), SoundDefinition.definition().with(this.sound(RosesUtils.resource("item.copper_horn.sound.bass.9"))));
    }
}
