package roses.world.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import roses.world.init.ModFeatures;

public class ModBiomeMaker 
{
	private static int calculateSkyColor(float p_244206_0_) {
	      float lvt_1_1_ = p_244206_0_ / 3.0F;
	      lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
	      return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	   }
	
	public static Biome rosePlainsBiome() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.plainsSpawns(mobspawninfo$builder);
		mobspawninfo$builder.setPlayerCanSpawn();
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		biomegenerationsettings$builder.addStructureStart(StructureFeatures.VILLAGE_PLAINS).addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addPlainGrass(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.ROSE_PLAINS);
		
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addPlainVegetation(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
		
		DefaultBiomeFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
	      
		DefaultBiomeFeatures.addDefaultSprings(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.8F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
}
