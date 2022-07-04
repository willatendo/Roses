package roses.server.util;

public class RosesRegistrate {
}// extends AbstractRegistrate<RosesRegistrate> {
//	protected RosesRegistrate(String modid) {
//		super(modid);
//
//		this.addDataGenerator(ProviderType.RECIPE, provider -> ShapelessRecipeBuilder.shapeless(Items.RED_DYE, 2).requires(RosesRegistry.ROSE.get()).unlockedBy("has_rose", provider.has(RosesRegistry.ROSE.get())).save(provider, RosesMod.rL("rose_red")));
//		this.addDataGenerator(ProviderType.RECIPE, provider -> ShapelessRecipeBuilder.shapeless(Items.CYAN_DYE, 2).requires(RosesRegistry.CYAN_FLOWER.get()).unlockedBy("has_cyan_flower", provider.has(RosesRegistry.CYAN_FLOWER.get())).save(provider, RosesMod.rL("cyan_dye_from_flower")));
//		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(BlockTags.WOOL, ItemTags.WOOL));
//		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS));
//		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(RosesTags.Blocks.LEGACY_BLOCKS, RosesTags.Items.LEGACY_BLOCKS));
//		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(RosesTags.Blocks.CHAIRS, RosesTags.Items.CHAIRS));
//		this.addDataGenerator(ProviderType.ITEM_TAGS, provider -> provider.copy(RosesTags.Blocks.CLOTH, RosesTags.Items.CLOTH));
//		this.addDataGenerator(ProviderType.BLOCK_TAGS, provider -> provider.tag(RosesTags.Blocks.LEGACY_BLOCKS).addTag(RosesTags.Blocks.CHAIRS).addTag(RosesTags.Blocks.CLOTH));
//		this.addDataGenerator(ProviderType.LANG, provider -> provider.add("advancement.roses.root", "Legacy Player"));
//		this.addDataGenerator(ProviderType.LANG, provider -> provider.add("advancement.roses.root.desc", "You've got nostalgia for the rose."));
//	}
//
//	public static NonNullSupplier<RosesRegistrate> lazy(String modid) {
//		return NonNullSupplier.of(() -> new RosesRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus()));
//	}
//}
