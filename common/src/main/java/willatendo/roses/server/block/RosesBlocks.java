package willatendo.roses.server.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;
import java.util.function.Supplier;

public class RosesBlocks {
    public static final SimpleRegistry<Block> BLOCKS = SimpleRegistry.create(Registries.BLOCK, RosesUtils.ID);

    public static final SimpleHolder<FlowerBlock> ROSE = BLOCKS.register("rose", () -> new FlowerBlock(MobEffects.LUCK, 13, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FlowerPotBlock> POTTED_ROSE = BLOCKS.register("potted_rose", () -> new FlowerPotBlock(RosesBlocks.ROSE.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FlowerBlock> CYAN_FLOWER = BLOCKS.register("cyan_flower", () -> new FlowerBlock(MobEffects.CONDUIT_POWER, 3, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FlowerPotBlock> POTTED_CYAN_FLOWER = BLOCKS.register("potted_cyan_flower", () -> new FlowerPotBlock(RosesBlocks.CYAN_FLOWER.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<Block> CAPRI_CLOTH = BLOCKS.register("capri_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> CHARTREUSE_CLOTH = BLOCKS.register("chartreuse_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> CYAN_CLOTH = BLOCKS.register("cyan_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> DARK_GRAY_CLOTH = BLOCKS.register("dark_gray_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> GREEN_CLOTH = BLOCKS.register("green_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> LIGHT_GRAY_CLOTH = BLOCKS.register("light_gray_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> MAGENTA_CLOTH = BLOCKS.register("magenta_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> ORANGE_CLOTH = BLOCKS.register("orange_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> PURPLE_CLOTH = BLOCKS.register("purple_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> RED_CLOTH = BLOCKS.register("red_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> ROSE_CLOTH = BLOCKS.register("rose_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> SPRING_GREEN_CLOTH = BLOCKS.register("spring_green_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> ULTRAMARINE_CLOTH = BLOCKS.register("ultramarine_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> VIOLET_CLOTH = BLOCKS.register("violet_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> WHITE_CLOTH = BLOCKS.register("white_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<Block> YELLOW_CLOTH = BLOCKS.register("yellow_cloth", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final SimpleHolder<ChairBlock> OAK_CHAIR = BLOCKS.register("oak_chair", chair(() -> Blocks.OAK_PLANKS));
    public static final SimpleHolder<ChairBlock> SPRUCE_CHAIR = BLOCKS.register("spruce_chair", chair(() -> Blocks.SPRUCE_PLANKS));
    public static final SimpleHolder<ChairBlock> BIRCH_CHAIR = BLOCKS.register("birch_chair", chair(() -> Blocks.BIRCH_PLANKS));
    public static final SimpleHolder<ChairBlock> JUNGLE_CHAIR = BLOCKS.register("jungle_chair", chair(() -> Blocks.JUNGLE_PLANKS));
    public static final SimpleHolder<ChairBlock> ACACIA_CHAIR = BLOCKS.register("acacia_chair", chair(() -> Blocks.ACACIA_PLANKS));
    public static final SimpleHolder<ChairBlock> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair", chair(() -> Blocks.DARK_OAK_PLANKS));
    public static final SimpleHolder<ChairBlock> CRIMSON_CHAIR = BLOCKS.register("crimson_chair", chair(() -> Blocks.CRIMSON_PLANKS));
    public static final SimpleHolder<ChairBlock> WARPED_CHAIR = BLOCKS.register("warped_chair", chair(() -> Blocks.WARPED_PLANKS));
    public static final SimpleHolder<ChairBlock> MANGROVE_CHAIR = BLOCKS.register("mangrove_chair", chair(() -> Blocks.MANGROVE_PLANKS));
    public static final SimpleHolder<ChairBlock> CHERRY_CHAIR = BLOCKS.register("cherry_chair", chair(() -> Blocks.CHERRY_PLANKS));
    public static final SimpleHolder<ChairBlock> BAMBOO_CHAIR = BLOCKS.register("bamboo_chair", chair(() -> Blocks.BAMBOO_PLANKS));
    public static final SimpleHolder<TableBlock> OAK_TABLE = BLOCKS.register("oak_table", table(() -> Blocks.OAK_PLANKS));
    public static final SimpleHolder<TableBlock> SPRUCE_TABLE = BLOCKS.register("spruce_table", table(() -> Blocks.SPRUCE_PLANKS));
    public static final SimpleHolder<TableBlock> BIRCH_TABLE = BLOCKS.register("birch_table", table(() -> Blocks.BIRCH_PLANKS));
    public static final SimpleHolder<TableBlock> JUNGLE_TABLE = BLOCKS.register("jungle_table", table(() -> Blocks.JUNGLE_PLANKS));
    public static final SimpleHolder<TableBlock> ACACIA_TABLE = BLOCKS.register("acacia_table", table(() -> Blocks.ACACIA_PLANKS));
    public static final SimpleHolder<TableBlock> DARK_OAK_TABLE = BLOCKS.register("dark_oak_table", table(() -> Blocks.DARK_OAK_PLANKS));
    public static final SimpleHolder<TableBlock> CRIMSON_TABLE = BLOCKS.register("crimson_table", table(() -> Blocks.CRIMSON_PLANKS));
    public static final SimpleHolder<TableBlock> WARPED_TABLE = BLOCKS.register("warped_table", table(() -> Blocks.WARPED_PLANKS));
    public static final SimpleHolder<TableBlock> MANGROVE_TABLE = BLOCKS.register("mangrove_table", table(() -> Blocks.MANGROVE_PLANKS));
    public static final SimpleHolder<TableBlock> CHERRY_TABLE = BLOCKS.register("cherry_table", table(() -> Blocks.CHERRY_PLANKS));
    public static final SimpleHolder<TableBlock> BAMBOO_TABLE = BLOCKS.register("bamboo_table", table(() -> Blocks.BAMBOO_PLANKS));
    public static final SimpleHolder<DropExperienceBlock> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final SimpleHolder<DropExperienceBlock> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(RosesBlocks.RUBY_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final SimpleHolder<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final SimpleHolder<CogBlock> COG = BLOCKS.register("cog", () -> new CogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).randomTicks().strength(0.5F, 1.0F).noCollission().noOcclusion()));

    public static Supplier<ChairBlock> chair(Supplier<Block> base) {
        return () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(base.get()));
    }

    public static Supplier<TableBlock> table(Supplier<Block> base) {
        return () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(base.get()));
    }

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(BLOCKS);
    }
}
