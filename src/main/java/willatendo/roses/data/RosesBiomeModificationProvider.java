package willatendo.roses.data;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

public class RosesBiomeModificationProvider implements DataProvider {
	private final PackOutput packOutput;
	private final String modid;

	public RosesBiomeModificationProvider(PackOutput packOutput, String modid) {
		this.packOutput = packOutput;
		this.modid = modid;
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		Path path = this.packOutput.getOutputFolder();
		ArrayList<CompletableFuture> completableFutures = Lists.newArrayList();

		// Rose Patches
		JsonObject rosePatches = new JsonObject();
		rosePatches.addProperty("type", "forge:add_features");
		rosePatches.addProperty("biomes", "#roses:has_rose");
		rosePatches.addProperty("features", "roses:rose_patch");
		rosePatches.addProperty("step", "vegetal_decoration");
		completableFutures.add(DataProvider.saveStable(cachedOutput, rosePatches, path.resolve("data/" + this.modid + "/forge/biome_modifier/add_rose_patches.json")));
		
		// Cyan Flower Patches
		JsonObject cyanFlowerPatches = new JsonObject();
		cyanFlowerPatches.addProperty("type", "forge:add_features");
		cyanFlowerPatches.addProperty("biomes", "#roses:has_cyan_flower");
		cyanFlowerPatches.addProperty("features", "roses:cyan_flower_patch");
		cyanFlowerPatches.addProperty("step", "vegetal_decoration");
		completableFutures.add(DataProvider.saveStable(cachedOutput, cyanFlowerPatches, path.resolve("data/" + this.modid + "/forge/biome_modifier/add_cyan_flower_patches.json")));
		
		// Music Changes
		JsonObject beachMusic = new JsonObject();
		beachMusic.addProperty("type", "roses:change_music");
		beachMusic.addProperty("biomes", "#roses:uses_music/beach_music");
		JsonObject beachMusicMusic = new JsonObject();
		beachMusicMusic.addProperty("sound", "roses:music.sound.beach");
		beachMusicMusic.addProperty("min_delay", 12000);
		beachMusicMusic.addProperty("max_delay", 24000);
		beachMusicMusic.addProperty("replace_current_music", true);
		beachMusic.add("music", beachMusicMusic);
		completableFutures.add(DataProvider.saveStable(cachedOutput, beachMusic, path.resolve("data/" + this.modid + "/forge/biome_modifier/beach_music.json")));

		JsonObject birchForestMusic = new JsonObject();
		birchForestMusic.addProperty("type", "roses:change_music");
		birchForestMusic.addProperty("biomes", "#roses:uses_music/birch_forest_music");
		JsonObject birchForestMusicMusic = new JsonObject();
		birchForestMusicMusic.addProperty("sound", "roses:music.sound.birch_forest");
		birchForestMusicMusic.addProperty("min_delay", 12000);
		birchForestMusicMusic.addProperty("max_delay", 24000);
		birchForestMusicMusic.addProperty("replace_current_music", true);
		birchForestMusic.add("music", birchForestMusicMusic);
		completableFutures.add(DataProvider.saveStable(cachedOutput, birchForestMusic, path.resolve("data/" + this.modid + "/forge/biome_modifier/birch_forest_music.json")));

		JsonObject deepDarkMusic = new JsonObject();
		deepDarkMusic.addProperty("type", "roses:change_music");
		deepDarkMusic.addProperty("biomes", "#roses:uses_music/deep_dark_music");
		JsonObject deepDarkForestMusicMusic = new JsonObject();
		deepDarkForestMusicMusic.addProperty("sound", "roses:music.sound.deep_dark");
		deepDarkForestMusicMusic.addProperty("min_delay", 12000);
		deepDarkForestMusicMusic.addProperty("max_delay", 24000);
		deepDarkForestMusicMusic.addProperty("replace_current_music", true);
		deepDarkMusic.add("music", deepDarkForestMusicMusic);
		completableFutures.add(DataProvider.saveStable(cachedOutput, deepDarkMusic, path.resolve("data/" + this.modid + "/forge/biome_modifier/deep_dark_music.json")));

		return CompletableFuture.allOf(completableFutures.stream().toArray(CompletableFuture[]::new));
	}

	@Override
	public String getName() {
		return this.modid + ": Biome Modifiers";
	}
}
