package willatendo.roses.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.VibrationFrequency;
import willatendo.roses.server.gameevent.RosesGameEvents;

import java.util.concurrent.CompletableFuture;

public class RosesDataMapProvider extends DataMapProvider {
    protected RosesDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.VIBRATION_FREQUENCIES).add(RosesGameEvents.COG_RUMBLES.getKey(), new VibrationFrequency(10), false);
    }
}
