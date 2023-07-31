package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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
		this.block(RosesBlocks.CAPRI_CLOTH.get());
		this.block(RosesBlocks.CHARTREUSE_CLOTH.get());
		this.block(RosesBlocks.CYAN_CLOTH.get());
		this.block(RosesBlocks.DARK_GRAY_CLOTH.get());
		this.block(RosesBlocks.GREEN_CLOTH.get());
		this.block(RosesBlocks.LIGHT_GRAY_CLOTH.get());
		this.block(RosesBlocks.MAGNETA_CLOTH.get());
		this.block(RosesBlocks.ORANGE_CLOTH.get());
		this.block(RosesBlocks.PURPLE_CLOTH.get());
		this.block(RosesBlocks.RED_CLOTH.get());
		this.block(RosesBlocks.ROSE_CLOTH.get());
		this.block(RosesBlocks.SPRING_GREEN_CLOTH.get());
		this.block(RosesBlocks.ULTRAMARINE_CLOTH.get());
		this.block(RosesBlocks.VIOLET_CLOTH.get());
		this.block(RosesBlocks.WHITE_CLOTH.get());
		this.block(RosesBlocks.YELLOW_CLOTH.get());
		this.block(RosesBlocks.OAK_CHAIR.get());
		this.block(RosesBlocks.SPRUCE_CHAIR.get());
		this.block(RosesBlocks.BIRCH_CHAIR.get());
		this.block(RosesBlocks.JUNGLE_CHAIR.get());
		this.block(RosesBlocks.ACACIA_CHAIR.get());
		this.block(RosesBlocks.DARK_OAK_CHAIR.get());
		this.block(RosesBlocks.CRIMSON_CHAIR.get());
		this.block(RosesBlocks.WARPED_CHAIR.get());
		this.block(RosesBlocks.MANGROVE_CHAIR.get());
		this.block(RosesBlocks.CHERRY_CHAIR.get());
		this.block(RosesBlocks.BAMBOO_CHAIR.get());
		this.block(RosesBlocks.RUBY_ORE.get());
		this.block(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
		this.block(RosesBlocks.RUBY_BLOCK.get());
		this.basicItem(RosesBlocks.COG.get().asItem(), this.modLoc("block/cog"));
	}

	public void block(Block block) {
		this.getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath()).parent(new ModelFile.UncheckedModelFile(this.modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath())));
	}
}
