package willatendo.roses.server.biome;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.BiomeSpecialEffectsBuilder;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;

public record ChangeMusicFeaturesBiomeModifer(HolderSet<Biome> biomes, Music music) implements BiomeModifier {
	@Override
	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD && this.biomes.contains(biome)) {
			BiomeSpecialEffectsBuilder biomeSpecialEffectsBuilder = builder.getSpecialEffects();
			biomeSpecialEffectsBuilder.backgroundMusic(this.music);
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return RosesBiomeModifierSerializers.CHANGE_MUSIC.get();
	}
}
