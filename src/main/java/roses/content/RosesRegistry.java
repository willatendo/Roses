package roses.content;

import static roses.RosesMod.CENTRAL_REGISTRATE;
import static roses.RosesMod.UTILS;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.EntityEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import roses.RosesMod;
import roses.library.block.ChairBlock;
import roses.library.entity.EmptyRenderer;
import roses.library.entity.SittingEntity;
import roses.library.util.RosesRegistrate;
import tyrannotitanlib.library.item.TyrannoArmourMaterial;
import tyrannotitanlib.library.itemgroup.BasicCreativeTab;

public class RosesRegistry {
	public static final RosesRegistrate REGISTRATE = CENTRAL_REGISTRATE.get().creativeModeTab(() -> RosesRegistry.ROSES_TAB);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RosesMod.ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RosesMod.ID);

	public static final BasicCreativeTab ROSES_TAB = new BasicCreativeTab(RosesMod.ID, "roses_tab");

	// 1.0.0 Content
	public static final BlockEntry<FlowerBlock> ROSE = REGISTRATE.block("rose", properties -> new FlowerBlock(MobEffects.LUCK, 13, properties)).blockstate((context, provider) -> flower(provider, context.get())).item().model((context, provider) -> provider.blockSprite(() -> context.get())).build().initialProperties(() -> Blocks.POPPY).register();
	public static final BlockEntry<FlowerPotBlock> POTTED_ROSE = REGISTRATE.block("potted_rose", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> RosesRegistry.ROSE.get(), properties)).blockstate((context, provider) -> flowerPot(provider, context.get(), "rose")).loot((provider, block) -> {
		Builder builder = LootTable.lootTable();
		LootItemCondition.Builder survivesExplosion = ExplosionCondition.survivesExplosion();
		provider.add(block, builder.withPool(LootPool.lootPool().when(survivesExplosion).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.FLOWER_POT)).add(LootItem.lootTableItem(RosesRegistry.ROSE.get()))));
	}).register();

	// 2.0.0 Content
	public static final BlockEntry<FlowerBlock> CYAN_FLOWER = REGISTRATE.block("cyan_flower", properties -> new FlowerBlock(MobEffects.CONDUIT_POWER, 3, properties)).blockstate((context, provider) -> flower(provider, context.get())).item().model((context, provider) -> provider.blockSprite(() -> context.get())).build().initialProperties(() -> Blocks.POPPY).register();
	public static final BlockEntry<FlowerPotBlock> POTTED_CYAN_FLOWER = REGISTRATE.block("potted_cyan_flower", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> CYAN_FLOWER.get(), properties)).blockstate((context, provider) -> flowerPot(provider, context.get(), "cyan_flower")).loot((provider, block) -> provider.createPotFlowerItemTable(RosesRegistry.CYAN_FLOWER.get())).register();

	// 3.1.0 Content
	public static final BlockEntry<Block> CAPRI_CLOTH = REGISTRATE.block("capri_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> CHARTRUESE_CLOTH = REGISTRATE.block("chartruese_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> CYAN_CLOTH = REGISTRATE.block("cyan_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> DARK_GRAY_CLOTH = REGISTRATE.block("dark_gray_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> GREEN_CLOTH = REGISTRATE.block("green_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> LIGHT_GRAY_CLOTH = REGISTRATE.block("light_gray_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> MAGNETA_CLOTH = REGISTRATE.block("magenta_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> ORANGE_CLOTH = REGISTRATE.block("orange_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> PURPLE_CLOTH = REGISTRATE.block("purple_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> RED_CLOTH = REGISTRATE.block("red_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> ROSE_CLOTH = REGISTRATE.block("rose_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> SPRING_GREEN_CLOTH = REGISTRATE.block("spring_green_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> ULTRAMARINE_CLOTH = REGISTRATE.block("ultramarine_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> VIOLET_CLOTH = REGISTRATE.block("violet_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> WHITE_CLOTH = REGISTRATE.block("white_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();
	public static final BlockEntry<Block> YELLOW_CLOTH = REGISTRATE.block("yellow_cloth", Block::new).initialProperties(() -> Blocks.WHITE_WOOL).simpleItem().register();

	// 3.2.0 Content
	public static final BlockEntry<ChairBlock> OAK_CHAIR = REGISTRATE.block("oak_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.WOOD)).blockstate((context, provider) -> chair(provider, context.get(), "oak")).simpleItem().register();
	public static final BlockEntry<ChairBlock> SPRUCE_CHAIR = REGISTRATE.block("spruce_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.PODZOL)).blockstate((context, provider) -> chair(provider, context.get(), "spruce")).simpleItem().register();
	public static final BlockEntry<ChairBlock> BIRCH_CHAIR = REGISTRATE.block("birch_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.SAND)).blockstate((context, provider) -> chair(provider, context.get(), "birch")).simpleItem().register();
	public static final BlockEntry<ChairBlock> JUNGLE_CHAIR = REGISTRATE.block("jungle_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.DIRT)).blockstate((context, provider) -> chair(provider, context.get(), "jungle")).simpleItem().register();
	public static final BlockEntry<ChairBlock> ACACIA_CHAIR = REGISTRATE.block("acacia_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.COLOR_ORANGE)).blockstate((context, provider) -> chair(provider, context.get(), "acacia")).simpleItem().register();
	public static final BlockEntry<ChairBlock> DARK_OAK_CHAIR = REGISTRATE.block("dark_oak_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.COLOR_BROWN)).blockstate((context, provider) -> chair(provider, context.get(), "dark_oak")).simpleItem().register();
	public static final BlockEntry<ChairBlock> CRIMSON_CHAIR = REGISTRATE.block("crimson_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.CRIMSON_STEM)).blockstate((context, provider) -> chair(provider, context.get(), "crimson")).simpleItem().register();
	public static final BlockEntry<ChairBlock> WARPED_CHAIR = REGISTRATE.block("warped_chair", ChairBlock::new).properties(properties -> chair(MaterialColor.WARPED_STEM)).blockstate((context, provider) -> chair(provider, context.get(), "warped")).simpleItem().register();

	public static final EntityEntry<SittingEntity> CHAIR_ENTITY = REGISTRATE.entity("chair", SittingEntity.factory, MobCategory.MISC).renderer(() -> EmptyRenderer::new).register();//.sized(0, 0).clientTrackingRange(256).updateInterval(20).sized(0.0001F, 0.0001F).build("chair"));

	// 3.3.0 Content
	public static final TyrannoArmourMaterial STUDED_ARMOUR = new TyrannoArmourMaterial(UTILS.mod("studed_armour"), 15, new int[] { 2, 3, 5, 2 }, 13, () -> SoundEvents.ARMOR_EQUIP_LEATHER, 0.5F, 0.01F, () -> {
		return Ingredient.of(Items.CHAIN);
	});

	public static final ItemEntry<Item> RUBY = REGISTRATE.item("ruby", Item::new).register();
	public static final BlockEntry<OreBlock> RUBY_ORE = REGISTRATE.block("ruby_ore", properties -> new OreBlock(properties, UniformInt.of(3, 7))).simpleItem().register();
	public static final BlockEntry<OreBlock> DEEPSLATE_RUBY_ORE = REGISTRATE.block("deepslate_ruby_ore", properties -> new OreBlock(properties, UniformInt.of(3, 7))).simpleItem().register();
	public static final BlockEntry<Block> RUBY_BLOCK = REGISTRATE.block("ruby_block", Block::new).register();

	public static final RegistryObject<Item> STUDED_HELMET = ITEMS.register("studed_helmet", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.HEAD, new Properties().tab(ROSES_TAB)));
	public static final RegistryObject<Item> STUDED_CHESTPLATE = ITEMS.register("studed_chestplate", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.CHEST, new Properties().tab(ROSES_TAB)));
	public static final RegistryObject<Item> STUDED_LEGGINGS = ITEMS.register("studed_leggings", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.LEGS, new Properties().tab(ROSES_TAB)));
	public static final RegistryObject<Item> STUDED_BOOTS = ITEMS.register("studed_boots", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.FEET, new Properties().tab(ROSES_TAB)));

	public static BlockBehaviour.Properties chair(MaterialColor mapColour) {
		return BlockBehaviour.Properties.of(Material.WOOD, mapColour).strength(2.0F, 3.0F).sound(SoundType.WOOD);
	}

	private static void chair(RegistrateBlockstateProvider provider, Block block, String planks) {
		ResourceLocation name = block.getRegistryName();
		provider.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(provider.models().singleTexture(name.getPath(), new ResourceLocation(RosesMod.ID, "block/template_chair"), "wood", new ResourceLocation("block/" + planks + "_planks"))));
	}

	private static void flower(RegistrateBlockstateProvider provider, Block block) {
		ResourceLocation name = block.getRegistryName();
		provider.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(provider.models().cross(name.getPath(), new ResourceLocation(name.getNamespace(), "block/" + block.getRegistryName().getPath()))));
	}

	private static void flowerPot(RegistrateBlockstateProvider provider, Block block, String flower) {
		ResourceLocation name = block.getRegistryName();
		provider.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(provider.models().singleTexture(name.getPath(), new ResourceLocation("block/flower_pot_cross"), "plant", new ResourceLocation(name.getNamespace(), "block/" + flower))));
	}

	public static void registry(IEventBus bus) {
		ITEMS.register(bus);
		ENTITIES.register(bus);
	}
}
