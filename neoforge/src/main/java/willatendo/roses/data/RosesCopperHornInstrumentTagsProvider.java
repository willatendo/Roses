package willatendo.roses.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.roses.server.RosesRegistries;
import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.roses.server.item.RosesCopperHornInstrumentTags;
import willatendo.roses.server.item.RosesCopperHornInstruments;

import java.util.concurrent.CompletableFuture;

public class RosesCopperHornInstrumentTagsProvider extends TagsProvider<CopperHornInstrument> {
    public RosesCopperHornInstrumentTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, RosesRegistries.COPPER_HORN_INSTRUMENTS, registries, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(RosesCopperHornInstrumentTags.COPPER_HORNS).add(RosesCopperHornInstruments.GREAT_SKY_FALLING.getKey(), RosesCopperHornInstruments.OLD_HYMN_RESTING.getKey(), RosesCopperHornInstruments.PURE_WATER_DESIRE.getKey(), RosesCopperHornInstruments.HUMBLE_FIRE_MEMORY.getKey(), RosesCopperHornInstruments.DRY_URGE_ANGER.getKey(), RosesCopperHornInstruments.CLEAR_TEMPER_JOURNEY.getKey(), RosesCopperHornInstruments.FRESH_NEST_THOUGHT.getKey(), RosesCopperHornInstruments.SECRET_LAKE_TEAR.getKey(), RosesCopperHornInstruments.FEARLESS_RIVER_GIFT.getKey(), RosesCopperHornInstruments.SWEET_MOON_LOVE.getKey());
    }
}
