package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class RosesLanguageProvider extends SimpleLanguageProvider {
	public RosesLanguageProvider(PackOutput packOutput, String modid, String locale) {
		super(packOutput, modid, locale);
	}

	@Override
	protected void addTranslations() {
		this.add(RosesItems.RUBY.get());
		this.add(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get(), "Music Disc");
		this.addDesc(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get(), "Notch - Magnetic Circuit");
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
		this.add(RosesBlocks.MAGNETA_CLOTH.get());
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
		this.add("block.roses.cog.desc", "Seams broken and causes extreme vibrations");
		this.add(RosesCreativeModeTabs.ROSES.get(), "Roses");
	}
}
