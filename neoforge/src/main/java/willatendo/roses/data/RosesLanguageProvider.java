package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class RosesLanguageProvider extends SimpleLanguageProvider {
    private final String modId;

    public RosesLanguageProvider(PackOutput packOutput, String modId, String locale) {
        super(packOutput, modId, locale);
        this.modId = modId;
    }

    @Override
    protected void addTranslations() {
        this.add("instrument.roses.fly", "Fly");
        this.add("instrument.roses.resist", "Resist");
        this.add(RosesItems.RUBY.get());
        this.add(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get(), "Music Disc");
        this.add("jukebox_song.roses.magnetic_circuit", "Notch - Magnetic Circuit");
        this.add(RosesItems.MUSIC_DISC_DOG.get(), "Music Disc");
        this.add("jukebox_song.roses.dog", "C418 - Dog");
        this.add(RosesItems.COPPER_HORN.get(), "Copper Horn");
        this.add("copper_horn.roses.great_sky_falling", "Great Sky Falling");
        this.add("copper_horn.roses.old_hymn_resting", "Old Hym Resting");
        this.add("copper_horn.roses.pure_water_desire", "Pure Water Desire");
        this.add("copper_horn.roses.humble_fire_memory", "Humble Fire Memory");
        this.add("copper_horn.roses.dry_urge_anger", "Dry Urge Anger");
        this.add("copper_horn.roses.clear_temper_journey", "Clear Temper Journey");
        this.add("copper_horn.roses.fresh_nest_thought", "Fresh Nest Thought");
        this.add("copper_horn.roses.secret_lake_tear", "Secret Lake Tear");
        this.add("copper_horn.roses.fearless_river_gift", "Fearless River Gift");
        this.add("copper_horn.roses.sweet_moon_love", "Sweet Moon Love");
        this.add(RosesBlocks.ROSE.get());
        this.add(RosesBlocks.POTTED_ROSE.get());
        this.add(RosesBlocks.CYAN_FLOWER.get());
        this.add(RosesBlocks.POTTED_CYAN_FLOWER.get());
        this.add(RosesBlocks.CAPRI_CLOTH.get());
        this.add(RosesBlocks.CHARTREUSE_CLOTH.get());
        this.add(RosesBlocks.CYAN_CLOTH.get());
        this.add(RosesBlocks.DARK_GRAY_CLOTH.get());
        this.add(RosesBlocks.GREEN_CLOTH.get());
        this.add(RosesBlocks.LIGHT_GRAY_CLOTH.get());
        this.add(RosesBlocks.MAGENTA_CLOTH.get());
        this.add(RosesBlocks.ORANGE_CLOTH.get());
        this.add(RosesBlocks.PURPLE_CLOTH.get());
        this.add(RosesBlocks.RED_CLOTH.get());
        this.add(RosesBlocks.ROSE_CLOTH.get());
        this.add(RosesBlocks.SPRING_GREEN_CLOTH.get());
        this.add(RosesBlocks.ULTRAMARINE_CLOTH.get());
        this.add(RosesBlocks.VIOLET_CLOTH.get());
        this.add(RosesBlocks.WHITE_CLOTH.get());
        this.add(RosesBlocks.YELLOW_CLOTH.get());
        this.add(RosesBlocks.OAK_CHAIR.get());
        this.add(RosesBlocks.SPRUCE_CHAIR.get());
        this.add(RosesBlocks.BIRCH_CHAIR.get());
        this.add(RosesBlocks.JUNGLE_CHAIR.get());
        this.add(RosesBlocks.ACACIA_CHAIR.get());
        this.add(RosesBlocks.DARK_OAK_CHAIR.get());
        this.add(RosesBlocks.CRIMSON_CHAIR.get());
        this.add(RosesBlocks.WARPED_CHAIR.get());
        this.add(RosesBlocks.MANGROVE_CHAIR.get());
        this.add(RosesBlocks.CHERRY_CHAIR.get());
        this.add(RosesBlocks.BAMBOO_CHAIR.get());
        this.add(RosesBlocks.OAK_TABLE.get());
        this.add(RosesBlocks.SPRUCE_TABLE.get());
        this.add(RosesBlocks.BIRCH_TABLE.get());
        this.add(RosesBlocks.JUNGLE_TABLE.get());
        this.add(RosesBlocks.ACACIA_TABLE.get());
        this.add(RosesBlocks.DARK_OAK_TABLE.get());
        this.add(RosesBlocks.CRIMSON_TABLE.get());
        this.add(RosesBlocks.WARPED_TABLE.get());
        this.add(RosesBlocks.MANGROVE_TABLE.get());
        this.add(RosesBlocks.CHERRY_TABLE.get());
        this.add(RosesBlocks.BAMBOO_TABLE.get());
        this.add(RosesBlocks.RUBY_ORE.get());
        this.add(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
        this.add(RosesBlocks.RUBY_BLOCK.get(), "Block of Ruby");
        this.add(RosesBlocks.COG.get());
        this.addDesc(RosesBlocks.COG.get(), "Distracting Vibrations");
        this.add(RosesCreativeModeTabs.ROSES.get(), "Roses");
    }
}
