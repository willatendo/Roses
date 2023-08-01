package willatendo.roses.data;

import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;

public class RosesBlockLoot extends BlockLootSubProvider {
	public RosesBlockLoot() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.dropSelf(RosesBlocks.ROSE.get());
		this.dropSelf(RosesBlocks.CYAN_FLOWER.get());
		this.dropSelf(RosesBlocks.CAPRI_CLOTH.get());
		this.dropSelf(RosesBlocks.CHARTREUSE_CLOTH.get());
		this.dropSelf(RosesBlocks.CYAN_CLOTH.get());
		this.dropSelf(RosesBlocks.DARK_GRAY_CLOTH.get());
		this.dropSelf(RosesBlocks.GREEN_CLOTH.get());
		this.dropSelf(RosesBlocks.LIGHT_GRAY_CLOTH.get());
		this.dropSelf(RosesBlocks.MAGNETA_CLOTH.get());
		this.dropSelf(RosesBlocks.ORANGE_CLOTH.get());
		this.dropSelf(RosesBlocks.PURPLE_CLOTH.get());
		this.dropSelf(RosesBlocks.RED_CLOTH.get());
		this.dropSelf(RosesBlocks.ROSE_CLOTH.get());
		this.dropSelf(RosesBlocks.SPRING_GREEN_CLOTH.get());
		this.dropSelf(RosesBlocks.ULTRAMARINE_CLOTH.get());
		this.dropSelf(RosesBlocks.VIOLET_CLOTH.get());
		this.dropSelf(RosesBlocks.WHITE_CLOTH.get());
		this.dropSelf(RosesBlocks.YELLOW_CLOTH.get());
		this.dropSelf(RosesBlocks.OAK_CHAIR.get());
		this.dropSelf(RosesBlocks.SPRUCE_CHAIR.get());
		this.dropSelf(RosesBlocks.BIRCH_CHAIR.get());
		this.dropSelf(RosesBlocks.JUNGLE_CHAIR.get());
		this.dropSelf(RosesBlocks.ACACIA_CHAIR.get());
		this.dropSelf(RosesBlocks.DARK_OAK_CHAIR.get());
		this.dropSelf(RosesBlocks.CRIMSON_CHAIR.get());
		this.dropSelf(RosesBlocks.WARPED_CHAIR.get());
		this.dropSelf(RosesBlocks.MANGROVE_CHAIR.get());
		this.dropSelf(RosesBlocks.CHERRY_CHAIR.get());
		this.dropSelf(RosesBlocks.BAMBOO_CHAIR.get());
		this.dropSelf(RosesBlocks.RUBY_ORE.get());
		this.dropSelf(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
		this.dropSelf(RosesBlocks.RUBY_BLOCK.get());
		this.dropSelf(RosesBlocks.COG.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> RosesUtils.ID.equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace())).collect(Collectors.toSet());
	}
}
