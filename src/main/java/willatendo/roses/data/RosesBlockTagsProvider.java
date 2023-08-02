package willatendo.roses.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.block.RosesBlockTags;
import willatendo.roses.server.block.RosesBlocks;

public class RosesBlockTagsProvider extends BlockTagsProvider {
	public RosesBlockTagsProvider(PackOutput packOutput, CompletableFuture<Provider> procider, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, procider, modid, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(RosesBlockTags.LEGACY_BLOCKS).add(RosesBlocks.ROSE.get(), RosesBlocks.CYAN_FLOWER.get(), RosesBlocks.CAPRI_CLOTH.get(), RosesBlocks.CHARTREUSE_CLOTH.get(), RosesBlocks.CYAN_CLOTH.get(), RosesBlocks.DARK_GRAY_CLOTH.get(), RosesBlocks.GREEN_CLOTH.get(), RosesBlocks.LIGHT_GRAY_CLOTH.get(), RosesBlocks.MAGNETA_CLOTH.get(), RosesBlocks.ORANGE_CLOTH.get(), RosesBlocks.PURPLE_CLOTH.get(), RosesBlocks.RED_CLOTH.get(), RosesBlocks.ROSE_CLOTH.get(), RosesBlocks.SPRING_GREEN_CLOTH.get(), RosesBlocks.ULTRAMARINE_CLOTH.get(), RosesBlocks.VIOLET_CLOTH.get(), RosesBlocks.WHITE_CLOTH.get(), RosesBlocks.YELLOW_CLOTH.get(), RosesBlocks.OAK_CHAIR.get(), RosesBlocks.SPRUCE_CHAIR.get(), RosesBlocks.BIRCH_CHAIR.get(), RosesBlocks.JUNGLE_CHAIR.get(), RosesBlocks.ACACIA_CHAIR.get(), RosesBlocks.DARK_OAK_CHAIR.get(), RosesBlocks.CRIMSON_CHAIR.get(), RosesBlocks.WARPED_CHAIR.get(), RosesBlocks.MANGROVE_CHAIR.get(), RosesBlocks.CHERRY_CHAIR.get(), RosesBlocks.BAMBOO_CHAIR.get(), RosesBlocks.OAK_TABLE.get(), RosesBlocks.SPRUCE_TABLE.get(), RosesBlocks.BIRCH_TABLE.get(), RosesBlocks.JUNGLE_TABLE.get(), RosesBlocks.ACACIA_TABLE.get(), RosesBlocks.DARK_OAK_TABLE.get(), RosesBlocks.CRIMSON_TABLE.get(), RosesBlocks.WARPED_TABLE.get(), RosesBlocks.MANGROVE_TABLE.get(), RosesBlocks.CHERRY_TABLE.get(), RosesBlocks.BAMBOO_TABLE.get(), RosesBlocks.RUBY_ORE.get(), RosesBlocks.DEEPSLATE_RUBY_ORE.get(), RosesBlocks.RUBY_BLOCK.get(), RosesBlocks.COG.get());
		this.tag(RosesBlockTags.CHAIRS).add(RosesBlocks.OAK_CHAIR.get(), RosesBlocks.SPRUCE_CHAIR.get(), RosesBlocks.BIRCH_CHAIR.get(), RosesBlocks.JUNGLE_CHAIR.get(), RosesBlocks.ACACIA_CHAIR.get(), RosesBlocks.DARK_OAK_CHAIR.get(), RosesBlocks.CRIMSON_CHAIR.get(), RosesBlocks.WARPED_CHAIR.get(), RosesBlocks.MANGROVE_CHAIR.get(), RosesBlocks.CHERRY_CHAIR.get(), RosesBlocks.BAMBOO_CHAIR.get());
		this.tag(RosesBlockTags.TABLES).add(RosesBlocks.OAK_TABLE.get(), RosesBlocks.SPRUCE_TABLE.get(), RosesBlocks.BIRCH_TABLE.get(), RosesBlocks.JUNGLE_TABLE.get(), RosesBlocks.ACACIA_TABLE.get(), RosesBlocks.DARK_OAK_TABLE.get(), RosesBlocks.CRIMSON_TABLE.get(), RosesBlocks.WARPED_TABLE.get(), RosesBlocks.MANGROVE_TABLE.get(), RosesBlocks.CHERRY_TABLE.get(), RosesBlocks.BAMBOO_TABLE.get());
		this.tag(RosesBlockTags.CLOTH).add(RosesBlocks.CAPRI_CLOTH.get(), RosesBlocks.CHARTREUSE_CLOTH.get(), RosesBlocks.CYAN_CLOTH.get(), RosesBlocks.DARK_GRAY_CLOTH.get(), RosesBlocks.GREEN_CLOTH.get(), RosesBlocks.LIGHT_GRAY_CLOTH.get(), RosesBlocks.MAGNETA_CLOTH.get(), RosesBlocks.ORANGE_CLOTH.get(), RosesBlocks.PURPLE_CLOTH.get(), RosesBlocks.RED_CLOTH.get(), RosesBlocks.ROSE_CLOTH.get(), RosesBlocks.SPRING_GREEN_CLOTH.get(), RosesBlocks.ULTRAMARINE_CLOTH.get(), RosesBlocks.VIOLET_CLOTH.get(), RosesBlocks.WHITE_CLOTH.get(), RosesBlocks.YELLOW_CLOTH.get());
		this.tag(RosesBlockTags.COGS).add(RosesBlocks.COG.get());
	}
}
