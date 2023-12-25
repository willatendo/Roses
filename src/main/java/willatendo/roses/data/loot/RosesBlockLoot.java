package willatendo.roses.data.loot;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.simplelibrary.server.registry.RegistryHolder;

public class RosesBlockLoot extends BlockLootSubProvider {
	public RosesBlockLoot() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
		this.generate();
		HashSet<ResourceLocation> set = new HashSet<ResourceLocation>();
		for (RegistryHolder<? extends Block> block : RosesBlocks.BLOCKS.getEntries()) {
			ResourceLocation resourceLocation;
			if (!block.get().isEnabled(this.enabledFeatures) || (resourceLocation = block.get().getLootTable()) == BuiltInLootTables.EMPTY || !set.add(resourceLocation))
				continue;
			LootTable.Builder builder = this.map.remove(resourceLocation);
			if (builder == null) {
				throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", resourceLocation, BuiltInRegistries.BLOCK.getKey(block.get())));
			}
			biConsumer.accept(resourceLocation, builder);
		}
		if (!this.map.isEmpty()) {
			throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
		}
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

//	@Override
//	protected Iterable<Block> getKnownBlocks() {
//		return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> RosesUtils.ID.equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace())).collect(Collectors.toSet());
//	}
}
