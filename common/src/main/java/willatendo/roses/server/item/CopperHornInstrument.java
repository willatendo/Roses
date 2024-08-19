package willatendo.roses.server.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Instrument;
import willatendo.roses.server.RosesRegistries;

public record CopperHornInstrument(Holder<SoundEvent> call, Holder<SoundEvent> melody, Holder<SoundEvent> bass,
                                   int useDuration, float range) {
    public static final Codec<CopperHornInstrument> DIRECT_CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(SoundEvent.CODEC.fieldOf("call").forGetter(CopperHornInstrument::call), SoundEvent.CODEC.fieldOf("melody").forGetter(CopperHornInstrument::melody), SoundEvent.CODEC.fieldOf("bass").forGetter(CopperHornInstrument::bass), ExtraCodecs.POSITIVE_INT.fieldOf("use_duration").forGetter(CopperHornInstrument::useDuration), ExtraCodecs.POSITIVE_FLOAT.fieldOf("range").forGetter(CopperHornInstrument::range)).apply(instance, CopperHornInstrument::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, CopperHornInstrument> DIRECT_STREAM_CODEC = StreamCodec.composite(SoundEvent.STREAM_CODEC, CopperHornInstrument::call, SoundEvent.STREAM_CODEC, CopperHornInstrument::melody, SoundEvent.STREAM_CODEC, CopperHornInstrument::bass, ByteBufCodecs.VAR_INT, CopperHornInstrument::useDuration, ByteBufCodecs.FLOAT, CopperHornInstrument::range, CopperHornInstrument::new);
    public static final Codec<Holder<CopperHornInstrument>> CODEC = RegistryFileCodec.create(RosesRegistries.COPPER_HORN_INSTRUMENTS, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<CopperHornInstrument>> STREAM_CODEC = ByteBufCodecs.holder(RosesRegistries.COPPER_HORN_INSTRUMENTS, DIRECT_STREAM_CODEC);
}
