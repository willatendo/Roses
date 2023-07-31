package willatendo.roses.server.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.sounds.Music;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.util.RosesUtils;

public class RosesBiomeModifierSerializers {
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, RosesUtils.ID);

	public static final RegistryObject<Codec<ChangeMusicFeaturesBiomeModifer>> CHANGE_MUSIC = BIOME_MODIFIER_SERIALIZERS.register("change_music", () -> RecordCodecBuilder.create(builder -> builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(ChangeMusicFeaturesBiomeModifer::biomes), Music.CODEC.fieldOf("music").forGetter(ChangeMusicFeaturesBiomeModifer::music)).apply(builder, ChangeMusicFeaturesBiomeModifer::new)));
}
