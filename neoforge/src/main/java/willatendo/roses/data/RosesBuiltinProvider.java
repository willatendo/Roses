package willatendo.roses.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.roses.server.biome.RosesBiomeTags;
import willatendo.roses.server.features.RosesConfiguredFeatures;
import willatendo.roses.server.features.RosesPlacedFeatures;
import willatendo.roses.server.item.RosesJukeboxSongs;
import willatendo.roses.server.util.RosesUtils;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class RosesBuiltinProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, RosesConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, RosesPlacedFeatures::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, RosesBuiltinProvider::bootstrapBiomeModifiers).add(Registries.JUKEBOX_SONG, RosesJukeboxSongs::bootstrap);

    public RosesBuiltinProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(packOutput, registries, BUILDER, Collections.singleton(modId));
    }

    public static void bootstrapBiomeModifiers(BootstrapContext<BiomeModifier> bootstrapContext) {
        HolderGetter<Biome> biomes = bootstrapContext.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstrapContext.lookup(Registries.PLACED_FEATURE);
        HolderSet<PlacedFeature> rosePatch = HolderSet.direct(placedFeatures.getOrThrow(RosesPlacedFeatures.ROSE_PATCH));
        HolderSet<PlacedFeature> cyanFlowerPatch = HolderSet.direct(placedFeatures.getOrThrow(RosesPlacedFeatures.CYAN_FLOWER_PATCH));
        bootstrapContext.register(createBiomeModifier("add_rose_patch"), new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(RosesBiomeTags.HAS_ROSE), rosePatch, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstrapContext.register(createBiomeModifier("add_cyan_flower_patch"), new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(RosesBiomeTags.HAS_CYAN_FLOWER), cyanFlowerPatch, GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> createBiomeModifier(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, RosesUtils.resource(name));
    }
}
