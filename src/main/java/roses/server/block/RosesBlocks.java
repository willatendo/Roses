package roses.server.block;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import roses.RosesMod;
import roses.server.RosesTags;
import roses.server.item.ModBlockItem;
import roses.server.item.RosesItems;
import roses.server.util.RosesRegistrate;

public class RosesBlocks {
	public static final RosesRegistrate REGISTRATE = RosesMod.getRegistrate().creativeModeTab(() -> RosesMod.ROSES_TAB);

	// 1.0.0 Content
	public static final BlockEntry<FlowerBlock> ROSE = REGISTRATE.block("rose", properties -> new FlowerBlock(MobEffects.LUCK, 13, properties)).blockstate((context, provider) -> flower(provider, context.get())).item().model((context, provider) -> provider.blockSprite(() -> context.get()).renderType("cutout")).build().initialProperties(() -> Blocks.POPPY).tag(BlockTags.SMALL_FLOWERS, RosesTags.Blocks.LEGACY_BLOCKS).register();
	public static final BlockEntry<FlowerPotBlock> POTTED_ROSE = REGISTRATE.block("potted_rose", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> RosesBlocks.ROSE.get(), properties)).blockstate((context, provider) -> flowerPot(provider, context.get(), "rose")).loot((provider, block) -> {
		Builder builder = LootTable.lootTable();
		LootItemCondition.Builder survivesExplosion = ExplosionCondition.survivesExplosion();
		provider.add(block, builder.withPool(LootPool.lootPool().when(survivesExplosion).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.FLOWER_POT)).add(LootItem.lootTableItem(RosesBlocks.ROSE.get()))));
	}).tag(BlockTags.FLOWER_POTS).register();

	// 2.0.0 Content
	public static final BlockEntry<FlowerBlock> CYAN_FLOWER = REGISTRATE.block("cyan_flower", properties -> new FlowerBlock(MobEffects.CONDUIT_POWER, 3, properties)).blockstate((context, provider) -> flower(provider, context.get())).item().model((context, provider) -> provider.blockSprite(() -> context.get()).renderType("cutout")).build().initialProperties(() -> Blocks.POPPY).tag(BlockTags.SMALL_FLOWERS, RosesTags.Blocks.LEGACY_BLOCKS).register();
	public static final BlockEntry<FlowerPotBlock> POTTED_CYAN_FLOWER = REGISTRATE.block("potted_cyan_flower", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> CYAN_FLOWER.get(), properties)).blockstate((context, provider) -> flowerPot(provider, context.get(), "cyan_flower")).loot((provider, block) -> {
		Builder builder = LootTable.lootTable();
		LootItemCondition.Builder survivesExplosion = ExplosionCondition.survivesExplosion();
		provider.add(block, builder.withPool(LootPool.lootPool().when(survivesExplosion).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.FLOWER_POT)).add(LootItem.lootTableItem(RosesBlocks.CYAN_FLOWER.get()))));
	}).tag(BlockTags.FLOWER_POTS).register();

	// 3.1.0 Content
	public static final BlockEntry<Block> CAPRI_CLOTH = REGISTRATE.block("capri_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> CHARTRUESE_CLOTH = REGISTRATE.block("chartruese_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIME_DYE).requires(Items.YELLOW_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> CYAN_CLOTH = REGISTRATE.block("cyan_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_BLUE_DYE).requires(Items.WHITE_DYE).requires(Items.WHITE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> DARK_GRAY_CLOTH = REGISTRATE.block("dark_gray_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.GRAY_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> GREEN_CLOTH = REGISTRATE.block("green_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIME_DYE).requires(Items.GREEN_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> LIGHT_GRAY_CLOTH = REGISTRATE.block("light_gray_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.LIGHT_GRAY_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> MAGNETA_CLOTH = REGISTRATE.block("magenta_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PINK_DYE).requires(Items.MAGENTA_DYE).requires(Items.RED_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> ORANGE_CLOTH = REGISTRATE.block("orange_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.ORANGE_DYE).requires(Items.GRAY_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> PURPLE_CLOTH = REGISTRATE.block("purple_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.MAGENTA_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> RED_CLOTH = REGISTRATE.block("red_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.RED_DYE).requires(Items.PINK_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> ROSE_CLOTH = REGISTRATE.block("rose_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PINK_DYE).requires(Items.PURPLE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> SPRING_GREEN_CLOTH = REGISTRATE.block("spring_green_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.GREEN_DYE).requires(Items.WHITE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> ULTRAMARINE_CLOTH = REGISTRATE.block("ultramarine_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.BLUE_DYE).requires(Items.PURPLE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> VIOLET_CLOTH = REGISTRATE.block("violet_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.PURPLE_DYE).requires(Items.PURPLE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();
	public static final BlockEntry<Block> WHITE_CLOTH = REGISTRATE.block("white_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get(), 4).group("cloth").pattern("###").pattern("###").pattern("###").define('#', Items.STRING).unlockedBy("has_item", provider.has(Items.STRING)).save(provider)).register();
	public static final BlockEntry<Block> YELLOW_CLOTH = REGISTRATE.block("yellow_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().tag(BlockTags.WOOL, RosesTags.Blocks.CLOTH).recipe((block, provider) -> ShapelessRecipeBuilder.shapeless(block.get()).group("cloth").requires(RosesBlocks.WHITE_CLOTH.get()).requires(Items.YELLOW_DYE).requires(Items.ORANGE_DYE).unlockedBy("has_item", provider.has(RosesBlocks.WHITE_CLOTH.get())).save(provider)).register();

	// 3.2.0 Content
	public static final BlockEntry<ChairBlock> OAK_CHAIR = REGISTRATE.block("oak_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.WOOD)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.OAK_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.OAK_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "oak")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> SPRUCE_CHAIR = REGISTRATE.block("spruce_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.PODZOL)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.SPRUCE_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.SPRUCE_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "spruce")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> BIRCH_CHAIR = REGISTRATE.block("birch_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.SAND)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.BIRCH_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.BIRCH_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "birch")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> JUNGLE_CHAIR = REGISTRATE.block("jungle_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.DIRT)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.JUNGLE_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.JUNGLE_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "jungle")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> ACACIA_CHAIR = REGISTRATE.block("acacia_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.COLOR_ORANGE)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.ACACIA_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.ACACIA_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "acacia")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> DARK_OAK_CHAIR = REGISTRATE.block("dark_oak_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.COLOR_BROWN)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.DARK_OAK_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.DARK_OAK_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "dark_oak")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> CRIMSON_CHAIR = REGISTRATE.block("crimson_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.CRIMSON_STEM)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.CRIMSON_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.CRIMSON_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "crimson")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();
	public static final BlockEntry<ChairBlock> WARPED_CHAIR = REGISTRATE.block("warped_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.WARPED_STEM)).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern("#  ").pattern("###").pattern("@ @").define('#', Ingredient.of(Blocks.WARPED_PLANKS)).define('@', Ingredient.of(Items.STICK)).unlockedBy("has_item", provider.has(Blocks.WARPED_PLANKS)).save(provider)).blockstate((context, provider) -> chair(provider, context.get(), "warped")).item(ModBlockItem::new).build().tag(BlockTags.MINEABLE_WITH_AXE, RosesTags.Blocks.CHAIRS).register();

	// 3.3.0 Content
	public static final BlockEntry<DropExperienceBlock> RUBY_ORE = REGISTRATE.block("ruby_ore", properties -> new DropExperienceBlock(properties, UniformInt.of(3, 7))).loot((provider, block) -> provider.add(block, provider.createOreDrop(block, RosesItems.RUBY.get()))).simpleItem().tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL).register();
	public static final BlockEntry<DropExperienceBlock> DEEPSLATE_RUBY_ORE = REGISTRATE.block("deepslate_ruby_ore", properties -> new DropExperienceBlock(properties, UniformInt.of(3, 7))).loot((provider, block) -> provider.add(block, provider.createOreDrop(block, RosesItems.RUBY.get()))).simpleItem().tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL).register();
	public static final BlockEntry<Block> RUBY_BLOCK = REGISTRATE.block("ruby_block", Block::new).recipe((block, provider) -> provider.storage(() -> RosesItems.RUBY.get(), () -> block.get())).simpleItem().tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, RosesTags.Blocks.LEGACY_BLOCKS).register();

	// 4.0.0 Content
	public static final BlockEntry<CogBlock> COG = REGISTRATE.block("cog", CogBlock::new).properties(properties -> properties.of(Material.METAL).randomTicks().strength(0.5F, 1.0F).noCollission().noOcclusion()).tag(BlockTags.MINEABLE_WITH_PICKAXE).blockstate((block, provider) -> {
		ModelFile cog = provider.models().withExistingParent("cog", new ResourceLocation("sculk_vein")).texture("sculk_vein", RosesMod.rL("block/cog")).texture("particle", RosesMod.rL("block/cog")).renderType("cutout");
		ModelFile spinningCog = provider.models().withExistingParent("spinning_cog", new ResourceLocation("sculk_vein")).texture("sculk_vein", RosesMod.rL("block/spinning_cog")).texture("particle", RosesMod.rL("block/spinning_cog")).renderType("cutout");
		provider.getMultipartBuilder(block.get()).part().modelFile(cog).addModel().condition(PipeBlock.NORTH, true).condition(CogBlock.ON, false).end().part().modelFile(cog).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.EAST, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.SOUTH, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.WEST, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.UP, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(90).uvLock(true).addModel().condition(PipeBlock.DOWN, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(spinningCog).addModel().condition(PipeBlock.NORTH, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.EAST, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.SOUTH, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.WEST, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.UP, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(90).uvLock(true).addModel().condition(PipeBlock.DOWN, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end();
	}).recipe((block, provider) -> ShapedRecipeBuilder.shaped(block.get()).pattern(" # ").pattern("# #").pattern(" # ").define('#', Items.IRON_INGOT).unlockedBy("has_item", provider.has(Items.IRON_INGOT)).save(provider)).item().model((block, provider) -> provider.generated(() -> block.get(), RosesMod.rL("block/cog"))).build().register();

	public static BlockBehaviour.Properties chair(MaterialColor mapColour) {
		return BlockBehaviour.Properties.of(Material.WOOD, mapColour).strength(2.0F, 3.0F).sound(SoundType.WOOD);
	}

	private static void chair(RegistrateBlockstateProvider provider, Block block, String planks) {
		ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
		ModelFile file = provider.models().singleTexture(name.getPath(), new ResourceLocation(RosesMod.ID, "block/template_chair"), "wood", new ResourceLocation("block/" + planks + "_planks"));
		provider.getVariantBuilder(block).forAllStatesExcept(state -> ConfiguredModel.builder().modelFile(file).rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360).build(), BlockStateProperties.WATERLOGGED);

	}

	private static void flower(RegistrateBlockstateProvider provider, Block block) {
		ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
		provider.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(provider.models().cross(name.getPath(), new ResourceLocation(name.getNamespace(), "block/" + name.getPath()))));
	}

	private static void flowerPot(RegistrateBlockstateProvider provider, Block block, String flower) {
		ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
		provider.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(provider.models().singleTexture(name.getPath(), new ResourceLocation("block/flower_pot_cross"), "plant", new ResourceLocation(name.getNamespace(), "block/" + flower)).renderType("cutout")));
	}

	public static void init() {
	}
}
