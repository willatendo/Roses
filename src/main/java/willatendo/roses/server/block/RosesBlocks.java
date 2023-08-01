package willatendo.roses.server.block;

import java.util.function.Supplier;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.util.RosesUtils;

public class RosesBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RosesUtils.ID);

	public static final RegistryObject<FlowerBlock> ROSE = BLOCKS.register("rose", () -> new FlowerBlock(() -> MobEffects.LUCK, 13, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> POTTED_ROSE = BLOCKS.register("potted_rose", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> RosesBlocks.ROSE.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<FlowerBlock> CYAN_FLOWER = BLOCKS.register("cyan_flower", () -> new FlowerBlock(() -> MobEffects.CONDUIT_POWER, 3, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> POTTED_CYAN_FLOWER = BLOCKS.register("potted_cyan_flower", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> RosesBlocks.CYAN_FLOWER.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> CAPRI_CLOTH = BLOCKS.register("capri_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> CHARTREUSE_CLOTH = BLOCKS.register("chartreuse_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> CYAN_CLOTH = BLOCKS.register("cyan_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> DARK_GRAY_CLOTH = BLOCKS.register("dark_gray_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> GREEN_CLOTH = BLOCKS.register("green_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> LIGHT_GRAY_CLOTH = BLOCKS.register("light_gray_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> MAGNETA_CLOTH = BLOCKS.register("magenta_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> ORANGE_CLOTH = BLOCKS.register("orange_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> PURPLE_CLOTH = BLOCKS.register("purple_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> RED_CLOTH = BLOCKS.register("red_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> ROSE_CLOTH = BLOCKS.register("rose_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> SPRING_GREEN_CLOTH = BLOCKS.register("spring_green_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> ULTRAMARINE_CLOTH = BLOCKS.register("ultramarine_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> VIOLET_CLOTH = BLOCKS.register("violet_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> WHITE_CLOTH = BLOCKS.register("white_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<Block> YELLOW_CLOTH = BLOCKS.register("yellow_cloth", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	public static final RegistryObject<ChairBlock> OAK_CHAIR = BLOCKS.register("oak_chair", chair(() -> Blocks.OAK_PLANKS));
	public static final RegistryObject<ChairBlock> SPRUCE_CHAIR = BLOCKS.register("spruce_chair", chair(() -> Blocks.SPRUCE_PLANKS));
	public static final RegistryObject<ChairBlock> BIRCH_CHAIR = BLOCKS.register("birch_chair", chair(() -> Blocks.BIRCH_PLANKS));
	public static final RegistryObject<ChairBlock> JUNGLE_CHAIR = BLOCKS.register("jungle_chair", chair(() -> Blocks.JUNGLE_PLANKS));
	public static final RegistryObject<ChairBlock> ACACIA_CHAIR = BLOCKS.register("acacia_chair", chair(() -> Blocks.ACACIA_PLANKS));
	public static final RegistryObject<ChairBlock> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair", chair(() -> Blocks.DARK_OAK_PLANKS));
	public static final RegistryObject<ChairBlock> CRIMSON_CHAIR = BLOCKS.register("crimson_chair", chair(() -> Blocks.CRIMSON_PLANKS));
	public static final RegistryObject<ChairBlock> WARPED_CHAIR = BLOCKS.register("warped_chair", chair(() -> Blocks.WARPED_PLANKS));
	public static final RegistryObject<ChairBlock> MANGROVE_CHAIR = BLOCKS.register("mangrove_chair", chair(() -> Blocks.MANGROVE_PLANKS));
	public static final RegistryObject<ChairBlock> CHERRY_CHAIR = BLOCKS.register("cherry_chair", chair(() -> Blocks.CHERRY_PLANKS));
	public static final RegistryObject<ChairBlock> BAMBOO_CHAIR = BLOCKS.register("bamboo_chair", chair(() -> Blocks.BAMBOO_PLANKS));
	public static final RegistryObject<TableBlock> OAK_TABLE = BLOCKS.register("oak_table", table(() -> Blocks.OAK_PLANKS));
	public static final RegistryObject<TableBlock> SPRUCE_TABLE = BLOCKS.register("spruce_table", table(() -> Blocks.SPRUCE_PLANKS));
	public static final RegistryObject<TableBlock> BIRCH_TABLE = BLOCKS.register("birch_table", table(() -> Blocks.BIRCH_PLANKS));
	public static final RegistryObject<TableBlock> JUNGLE_TABLE = BLOCKS.register("jungle_table", table(() -> Blocks.JUNGLE_PLANKS));
	public static final RegistryObject<TableBlock> ACACIA_TABLE = BLOCKS.register("acacia_table", table(() -> Blocks.ACACIA_PLANKS));
	public static final RegistryObject<TableBlock> DARK_OAK_TABLE = BLOCKS.register("dark_oak_table", table(() -> Blocks.DARK_OAK_PLANKS));
	public static final RegistryObject<TableBlock> CRIMSON_TABLE = BLOCKS.register("crimson_table", table(() -> Blocks.CRIMSON_PLANKS));
	public static final RegistryObject<TableBlock> WARPED_TABLE = BLOCKS.register("warped_table", table(() -> Blocks.WARPED_PLANKS));
	public static final RegistryObject<TableBlock> MANGROVE_TABLE = BLOCKS.register("mangrove_table", table(() -> Blocks.MANGROVE_PLANKS));
	public static final RegistryObject<TableBlock> CHERRY_TABLE = BLOCKS.register("cherry_table", table(() -> Blocks.CHERRY_PLANKS));
	public static final RegistryObject<TableBlock> BAMBOO_TABLE = BLOCKS.register("bamboo_table", table(() -> Blocks.BAMBOO_PLANKS));
	public static final RegistryObject<DropExperienceBlock> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
	public static final RegistryObject<DropExperienceBlock> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(RosesBlocks.RUBY_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<CogBlock> COG = BLOCKS.register("cog", () -> new CogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).randomTicks().strength(0.5F, 1.0F).noCollission().noOcclusion()));

	public static Supplier<ChairBlock> chair(Supplier<Block> base) {
		return () -> new ChairBlock(BlockBehaviour.Properties.copy(base.get()));
	}

	public static Supplier<TableBlock> table(Supplier<Block> base) {
		return () -> new TableBlock(BlockBehaviour.Properties.copy(base.get()));
	}
}
