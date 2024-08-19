package willatendo.roses.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.InstrumentTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.InstrumentTags;
import net.minecraft.world.item.Instruments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import willatendo.roses.server.RosesRegistries;
import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.roses.server.item.RosesCopperHornInstrumentTags;
import willatendo.roses.server.item.RosesCopperHornInstruments;
import willatendo.roses.server.item.RosesInstruments;

import java.util.concurrent.CompletableFuture;

public class RosesInstrumentTagsProvider extends InstrumentTagsProvider {
    public RosesInstrumentTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(InstrumentTags.REGULAR_GOAT_HORNS).add(RosesInstruments.FLY.getKey());
        this.tag(InstrumentTags.SCREAMING_GOAT_HORNS).add(RosesInstruments.RESIST.getKey());
    }
}
