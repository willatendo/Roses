package willatendo.roses;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.SculkSensorFrequencyRegistry;
import net.minecraft.world.level.levelgen.GenerationStep;
import willatendo.roses.server.biome.RosesBiomeTags;
import willatendo.roses.server.features.RosesPlacedFeatures;
import willatendo.roses.server.gameevent.RosesGameEvents;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

public class RosesFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        List<SimpleRegistry<?>> simpleRegistries = new ArrayList<>();
        RosesMod.onInitialize(simpleRegistries);
        FabricRegister.register(simpleRegistries.toArray(SimpleRegistry[]::new));

        SculkSensorFrequencyRegistry.register(RosesGameEvents.COG_RUMBLES.getKey(), 10);

        BiomeModifications.addFeature(BiomeSelectors.tag(RosesBiomeTags.HAS_CYAN_FLOWER), GenerationStep.Decoration.VEGETAL_DECORATION, RosesPlacedFeatures.CYAN_FLOWER_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.tag(RosesBiomeTags.HAS_ROSE), GenerationStep.Decoration.VEGETAL_DECORATION, RosesPlacedFeatures.ROSE_PATCH);
    }
}
