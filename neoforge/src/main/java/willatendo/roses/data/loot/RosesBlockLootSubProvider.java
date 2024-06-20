package willatendo.roses.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.data.loot.SimpleBlockLootSubProvider;

import java.util.stream.Collectors;

public class RosesBlockLootSubProvider extends SimpleBlockLootSubProvider {
    public RosesBlockLootSubProvider(HolderLookup.Provider registries) {
        super(registries, RosesUtils.ID);
    }

    @Override
    public void generate() {
        this.dropSelf(RosesBlocks.ROSE.get());
        this.dropPottedContents(RosesBlocks.POTTED_ROSE.get());
        this.dropSelf(RosesBlocks.CYAN_FLOWER.get());
        this.dropPottedContents(RosesBlocks.POTTED_CYAN_FLOWER.get());
        this.dropSelf(RosesBlocks.CAPRI_CLOTH.get());
        this.dropSelf(RosesBlocks.CHARTREUSE_CLOTH.get());
        this.dropSelf(RosesBlocks.CYAN_CLOTH.get());
        this.dropSelf(RosesBlocks.DARK_GRAY_CLOTH.get());
        this.dropSelf(RosesBlocks.GREEN_CLOTH.get());
        this.dropSelf(RosesBlocks.LIGHT_GRAY_CLOTH.get());
        this.dropSelf(RosesBlocks.MAGENTA_CLOTH.get());
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
        this.dropSelf(RosesBlocks.OAK_TABLE.get());
        this.dropSelf(RosesBlocks.SPRUCE_TABLE.get());
        this.dropSelf(RosesBlocks.BIRCH_TABLE.get());
        this.dropSelf(RosesBlocks.JUNGLE_TABLE.get());
        this.dropSelf(RosesBlocks.ACACIA_TABLE.get());
        this.dropSelf(RosesBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(RosesBlocks.CRIMSON_TABLE.get());
        this.dropSelf(RosesBlocks.WARPED_TABLE.get());
        this.dropSelf(RosesBlocks.MANGROVE_TABLE.get());
        this.dropSelf(RosesBlocks.CHERRY_TABLE.get());
        this.dropSelf(RosesBlocks.BAMBOO_TABLE.get());
        this.dropSelf(RosesBlocks.RUBY_ORE.get());
        this.dropSelf(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
        this.dropSelf(RosesBlocks.RUBY_BLOCK.get());
        this.dropSelf(RosesBlocks.COG.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> RosesUtils.ID.equals(BuiltInRegistries.BLOCK.getKey(block).getNamespace())).collect(Collectors.toSet());
    }
}
