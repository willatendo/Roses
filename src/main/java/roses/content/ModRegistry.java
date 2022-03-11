package roses.content;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import roses.library.block.ChairBlock;
import roses.library.entity.SittingEntity;
import tyrannotitanlib.core.content.Util;
import tyrannotitanlib.library.item.TyrannoArmourMaterial;
import tyrannotitanlib.library.itemgroup.BasicCreativeTab;

public class ModRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Util.ROSES_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Util.ROSES_ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Util.ROSES_ID);

	public static final BasicCreativeTab ROSES_TAB = new BasicCreativeTab(Util.ROSES_ID, "roses_tab");

	// 1.0.0 Content
	public static final RegistryObject<Block> ROSE = BLOCKS.register("rose", () -> new FlowerBlock(MobEffects.LUCK, 13, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_ROSE = BLOCKS.register("potted_rose", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> ModRegistry.ROSE.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	// 2.0.0 Content
	public static final RegistryObject<Block> CYAN_FLOWER = BLOCKS.register("cyan_flower", () -> new FlowerBlock(MobEffects.CONDUIT_POWER, 3, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_CYAN_FLOWER = BLOCKS.register("potted_cyan_flower", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> CYAN_FLOWER.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	// 3.1.0 Content
	private static final BlockBehaviour.Properties CLOTH_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.SNOW).strength(0.8F).sound(SoundType.WOOL);
	public static final RegistryObject<Block> CAPRI_CLOTH = BLOCKS.register("capri_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> CHARTRUESE_CLOTH = BLOCKS.register("chartruese_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> CYAN_CLOTH = BLOCKS.register("cyan_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> DARK_GRAY_CLOTH = BLOCKS.register("dark_gray_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> GREEN_CLOTH = BLOCKS.register("green_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> LIGHT_GRAY_CLOTH = BLOCKS.register("light_gray_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> MAGNETA_CLOTH = BLOCKS.register("magenta_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> ORANGE_CLOTH = BLOCKS.register("orange_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> PURPLE_CLOTH = BLOCKS.register("purple_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> RED_CLOTH = BLOCKS.register("red_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> ROSE_CLOTH = BLOCKS.register("rose_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> SPRING_GREEN_CLOTH = BLOCKS.register("spring_green_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> ULTRAMARINE_CLOTH = BLOCKS.register("ultramarine_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> VIOLET_CLOTH = BLOCKS.register("violet_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> WHITE_CLOTH = BLOCKS.register("white_cloth", () -> new Block(CLOTH_PROPERTIES));
	public static final RegistryObject<Block> YELLOW_CLOTH = BLOCKS.register("yellow_cloth", () -> new Block(CLOTH_PROPERTIES));

	// 3.2.0 Content
	public static final RegistryObject<Block> OAK_CHAIR = BLOCKS.register("oak_chair", () -> new ChairBlock(chair(MaterialColor.WOOD)));
	public static final RegistryObject<Block> SPRUCE_CHAIR = BLOCKS.register("spruce_chair", () -> new ChairBlock(chair(MaterialColor.PODZOL)));
	public static final RegistryObject<Block> BIRCH_CHAIR = BLOCKS.register("birch_chair", () -> new ChairBlock(chair(MaterialColor.SAND)));
	public static final RegistryObject<Block> JUNGLE_CHAIR = BLOCKS.register("jungle_chair", () -> new ChairBlock(chair(MaterialColor.DIRT)));
	public static final RegistryObject<Block> ACACIA_CHAIR = BLOCKS.register("acacia_chair", () -> new ChairBlock(chair(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair", () -> new ChairBlock(chair(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> CRIMSON_CHAIR = BLOCKS.register("crimson_chair", () -> new ChairBlock(chair(MaterialColor.CRIMSON_STEM)));
	public static final RegistryObject<Block> WARPED_CHAIR = BLOCKS.register("warped_chair", () -> new ChairBlock(chair(MaterialColor.WARPED_STEM)));

	public static final RegistryObject<EntityType<SittingEntity>> CHAIR_ENTITY = ENTITIES.register("chair", () -> EntityType.Builder.of(SittingEntity.factory, MobCategory.MISC).sized(0, 0).clientTrackingRange(256).updateInterval(20).sized(0.0001F, 0.0001F).build("chair"));

	// 3.3.0 Content
	public static final TyrannoArmourMaterial STUDED_ARMOUR = new TyrannoArmourMaterial(Util.ROSES_UTILS.resource("studed_armour"), 15, new int[] { 2, 3, 5, 2 }, 13, () -> SoundEvents.ARMOR_EQUIP_LEATHER, 0.5F, 0.01F, () -> {
		return Ingredient.of(Items.CHAIN);
	});

	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<Item> STUDED_HELMET = ITEMS.register("studed_helmet", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.HEAD, new Properties().tab(ROSES_TAB)));
	public static final RegistryObject<Item> STUDED_CHESTPLATE = ITEMS.register("studed_chestplate", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.CHEST, new Properties().tab(ROSES_TAB)));
	public static final RegistryObject<Item> STUDED_LEGGINGS = ITEMS.register("studed_leggings", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.LEGS, new Properties().tab(ROSES_TAB)));
	public static final RegistryObject<Item> STUDED_BOOTS = ITEMS.register("studed_boots", () -> new ArmorItem(STUDED_ARMOUR, EquipmentSlot.FEET, new Properties().tab(ROSES_TAB)));

	public static BlockBehaviour.Properties chair(MaterialColor mapColour) {
		return BlockBehaviour.Properties.of(Material.WOOD, mapColour).strength(2.0F, 3.0F).sound(SoundType.WOOD);
	}

	public static void registry(IEventBus bus) {
		BLOCKS.register(bus);
		ITEMS.register(bus);
		ENTITIES.register(bus);
	}
}
