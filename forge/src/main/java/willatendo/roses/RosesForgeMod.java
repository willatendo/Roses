package willatendo.roses;

import net.minecraftforge.fml.common.Mod;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod(RosesUtils.ID)
public class RosesForgeMod {
    public static final List<SimpleRegistry<?>> REGISTRIES = new ArrayList<>();

    public RosesForgeMod() {
        RosesMod.onInitialize(REGISTRIES);
    }
}
