package roses.server.biome;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import roses.RosesMod;

public class RosesPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, RosesMod.ID);

	public static final RegistryObject<PlacedFeature> PLACED_ROSE_AND_CYAN_FLOWER = PLACED_FEATURES.register("placed_rose_and_cyan_flower", () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>) RosesConfiguredFeatures.ROSE_AND_CYAN_FLOWER, List.of(CountPlacement.of(3), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
}
