package willatendo.roses.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import willatendo.roses.server.sound.RosesSoundEvents;
import willatendo.roses.server.util.RosesUtils;

public class RosesJukeboxSongs {
    public static final ResourceKey<JukeboxSong> MAGNETIC_CIRCUIT = create("magnetic_circuit");
    public static final ResourceKey<JukeboxSong> DOG = create("dog");

    public static ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, RosesUtils.resource(name));
    }

    private static void register(BootstrapContext<JukeboxSong> bootstrapContext, ResourceKey<JukeboxSong> jukeboxSong, Holder<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        bootstrapContext.register(jukeboxSong, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", jukeboxSong.location())), (float) lengthInSeconds, comparatorOutput));
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> bootstrapContext) {
        register(bootstrapContext, RosesJukeboxSongs.MAGNETIC_CIRCUIT, RosesSoundEvents.MAGNETIC_CIRCUIT, 193, 1);
        register(bootstrapContext, RosesJukeboxSongs.DOG, RosesSoundEvents.DOG, 143, 2);
    }
}
