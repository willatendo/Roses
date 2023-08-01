package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.data.SimpleItemModelProvider;

public class RosesItemModelProvider extends SimpleItemModelProvider {
	public RosesItemModelProvider(PackOutput packOutput, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		this.basicItem(RosesItems.RUBY.get());
		this.basicItem(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get());
		this.basicItem(RosesBlocks.ROSE.get().asItem(), this.modLoc("block/rose"));
		this.basicItem(RosesBlocks.CYAN_FLOWER.get().asItem(), this.modLoc("block/cyan_flower"));
		this.basicBlock(RosesBlocks.CAPRI_CLOTH.get());
		this.basicBlock(RosesBlocks.CHARTREUSE_CLOTH.get());
		this.basicBlock(RosesBlocks.CYAN_CLOTH.get());
		this.basicBlock(RosesBlocks.DARK_GRAY_CLOTH.get());
		this.basicBlock(RosesBlocks.GREEN_CLOTH.get());
		this.basicBlock(RosesBlocks.LIGHT_GRAY_CLOTH.get());
		this.basicBlock(RosesBlocks.MAGNETA_CLOTH.get());
		this.basicBlock(RosesBlocks.ORANGE_CLOTH.get());
		this.basicBlock(RosesBlocks.PURPLE_CLOTH.get());
		this.basicBlock(RosesBlocks.RED_CLOTH.get());
		this.basicBlock(RosesBlocks.ROSE_CLOTH.get());
		this.basicBlock(RosesBlocks.SPRING_GREEN_CLOTH.get());
		this.basicBlock(RosesBlocks.ULTRAMARINE_CLOTH.get());
		this.basicBlock(RosesBlocks.VIOLET_CLOTH.get());
		this.basicBlock(RosesBlocks.WHITE_CLOTH.get());
		this.basicBlock(RosesBlocks.YELLOW_CLOTH.get());
		this.basicBlock(RosesBlocks.OAK_CHAIR.get());
		this.basicBlock(RosesBlocks.SPRUCE_CHAIR.get());
		this.basicBlock(RosesBlocks.BIRCH_CHAIR.get());
		this.basicBlock(RosesBlocks.JUNGLE_CHAIR.get());
		this.basicBlock(RosesBlocks.ACACIA_CHAIR.get());
		this.basicBlock(RosesBlocks.DARK_OAK_CHAIR.get());
		this.basicBlock(RosesBlocks.CRIMSON_CHAIR.get());
		this.basicBlock(RosesBlocks.WARPED_CHAIR.get());
		this.basicBlock(RosesBlocks.MANGROVE_CHAIR.get());
		this.basicBlock(RosesBlocks.CHERRY_CHAIR.get());
		this.basicBlock(RosesBlocks.BAMBOO_CHAIR.get());
		this.basicBlock(RosesBlocks.OAK_TABLE.get());
		this.basicBlock(RosesBlocks.SPRUCE_TABLE.get());
		this.basicBlock(RosesBlocks.BIRCH_TABLE.get());
		this.basicBlock(RosesBlocks.JUNGLE_TABLE.get());
		this.basicBlock(RosesBlocks.ACACIA_TABLE.get());
		this.basicBlock(RosesBlocks.DARK_OAK_TABLE.get());
		this.basicBlock(RosesBlocks.CRIMSON_TABLE.get());
		this.basicBlock(RosesBlocks.WARPED_TABLE.get());
		this.basicBlock(RosesBlocks.MANGROVE_TABLE.get());
		this.basicBlock(RosesBlocks.CHERRY_TABLE.get());
		this.basicBlock(RosesBlocks.BAMBOO_TABLE.get());
		this.basicBlock(RosesBlocks.RUBY_ORE.get());
		this.basicBlock(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
		this.basicBlock(RosesBlocks.RUBY_BLOCK.get());
		this.basicItem(RosesBlocks.COG.get().asItem(), this.modLoc("block/cog"));
	}
}
