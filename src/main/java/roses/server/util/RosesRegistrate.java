package roses.server.util;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import roses.RosesMod;
import roses.server.RosesTags;
import roses.server.block.RosesBlocks;

public class RosesRegistrate extends AbstractRegistrate<RosesRegistrate> {
	protected RosesRegistrate(String modid) {
		super(modid);

		this.recipes();
		this.itemTags();
		this.blockTags();
		this.lang();
	}

	public static NonNullSupplier<RosesRegistrate> lazy(String modid) {
		return NonNullSupplier.lazy(() -> new RosesRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus()));
	}

	public void recipes() {
		this.addDataGenerator(ProviderType.RECIPE, provider -> ShapelessRecipeBuilder.shapeless(Items.RED_DYE, 2).requires(RosesBlocks.ROSE.get()).unlockedBy("has_rose", provider.has(RosesBlocks.ROSE.get())).save(provider, RosesMod.rL("rose_red")));
		this.addDataGenerator(ProviderType.RECIPE, provider -> ShapelessRecipeBuilder.shapeless(Items.CYAN_DYE, 2).requires(RosesBlocks.CYAN_FLOWER.get()).unlockedBy("has_cyan_flower", provider.has(RosesBlocks.CYAN_FLOWER.get())).save(provider, RosesMod.rL("cyan_dye_from_flower")));
	}

	public void itemTags() {
		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(BlockTags.WOOL, ItemTags.WOOL));
		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS));
		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(RosesTags.Blocks.LEGACY_BLOCKS, RosesTags.Items.LEGACY_BLOCKS));
		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(RosesTags.Blocks.CHAIRS, RosesTags.Items.CHAIRS));
		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(RosesTags.Blocks.CLOTH, RosesTags.Items.CLOTH));
	}

	public void blockTags() {
		this.addDataGenerator(ProviderType.BLOCK_TAGS, provider -> provider.tag(RosesTags.Blocks.LEGACY_BLOCKS).addTag(RosesTags.Blocks.CHAIRS).addTag(RosesTags.Blocks.CLOTH));
	}

	public void lang() {
		this.addDataGenerator(ProviderType.LANG, provider -> provider.add("advancement.roses.root", "Legacy Player"));
		this.addDataGenerator(ProviderType.LANG, provider -> provider.add("advancement.roses.root.desc", "You've got nostalgia for the rose."));
	}
}
