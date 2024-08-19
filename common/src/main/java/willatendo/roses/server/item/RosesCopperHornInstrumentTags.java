package willatendo.roses.server.item;

import net.minecraft.tags.TagKey;
import willatendo.roses.server.RosesRegistries;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class RosesCopperHornInstrumentTags {
    public static final TagRegister<CopperHornInstrument> COPPER_HORN_INSTRUMENT_TAGS = TagRegister.create(RosesRegistries.COPPER_HORN_INSTRUMENTS, RosesUtils.ID);

    public static final TagKey<CopperHornInstrument> COPPER_HORNS = COPPER_HORN_INSTRUMENT_TAGS.register("copper_horns");
}
