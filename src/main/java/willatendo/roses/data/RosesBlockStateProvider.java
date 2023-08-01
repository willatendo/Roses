package willatendo.roses.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.block.RosesBlocks;

public class RosesBlockStateProvider extends BlockStateProvider {
	public RosesBlockStateProvider(PackOutput packOutput, String modid, ExistingFileHelper existingFileHelper) {
		super(packOutput, modid, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlock(RosesBlocks.ROSE.get(), this.models().cross("rose", this.modLoc("block/rose")).renderType("cutout"));
		this.simpleBlock(RosesBlocks.POTTED_ROSE.get(), this.models().withExistingParent("potted_rose", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/rose")).renderType("cutout"));
		this.simpleBlock(RosesBlocks.CYAN_FLOWER.get(), this.models().cross("cyan_flower", this.modLoc("block/cyan_flower")).renderType("cutout"));
		this.simpleBlock(RosesBlocks.POTTED_CYAN_FLOWER.get(), this.models().withExistingParent("potted_cyan_flower", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/cyan_flower")).renderType("cutout"));
		this.simpleBlock(RosesBlocks.CAPRI_CLOTH.get());
		this.simpleBlock(RosesBlocks.CHARTREUSE_CLOTH.get());
		this.simpleBlock(RosesBlocks.CYAN_CLOTH.get());
		this.simpleBlock(RosesBlocks.DARK_GRAY_CLOTH.get());
		this.simpleBlock(RosesBlocks.GREEN_CLOTH.get());
		this.simpleBlock(RosesBlocks.LIGHT_GRAY_CLOTH.get());
		this.simpleBlock(RosesBlocks.MAGNETA_CLOTH.get());
		this.simpleBlock(RosesBlocks.ORANGE_CLOTH.get());
		this.simpleBlock(RosesBlocks.PURPLE_CLOTH.get());
		this.simpleBlock(RosesBlocks.RED_CLOTH.get());
		this.simpleBlock(RosesBlocks.ROSE_CLOTH.get());
		this.simpleBlock(RosesBlocks.SPRING_GREEN_CLOTH.get());
		this.simpleBlock(RosesBlocks.ULTRAMARINE_CLOTH.get());
		this.simpleBlock(RosesBlocks.VIOLET_CLOTH.get());
		this.simpleBlock(RosesBlocks.WHITE_CLOTH.get());
		this.simpleBlock(RosesBlocks.YELLOW_CLOTH.get());
		this.horizontalBlock(RosesBlocks.OAK_CHAIR.get(), blockState -> this.models().withExistingParent("oak_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/oak_planks")));
		this.horizontalBlock(RosesBlocks.SPRUCE_CHAIR.get(), blockState -> this.models().withExistingParent("spruce_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/spruce_planks")));
		this.horizontalBlock(RosesBlocks.BIRCH_CHAIR.get(), blockState -> this.models().withExistingParent("birch_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/birch_planks")));
		this.horizontalBlock(RosesBlocks.JUNGLE_CHAIR.get(), blockState -> this.models().withExistingParent("jungle_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/jungle_planks")));
		this.horizontalBlock(RosesBlocks.ACACIA_CHAIR.get(), blockState -> this.models().withExistingParent("acacia_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/acacia_planks")));
		this.horizontalBlock(RosesBlocks.DARK_OAK_CHAIR.get(), blockState -> this.models().withExistingParent("dark_oak_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/dark_oak_planks")));
		this.horizontalBlock(RosesBlocks.CRIMSON_CHAIR.get(), blockState -> this.models().withExistingParent("crimson_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/crimson_planks")));
		this.horizontalBlock(RosesBlocks.WARPED_CHAIR.get(), blockState -> this.models().withExistingParent("warped_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/warped_planks")));
		this.horizontalBlock(RosesBlocks.MANGROVE_CHAIR.get(), blockState -> this.models().withExistingParent("mangrove_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/mangrove_planks")));
		this.horizontalBlock(RosesBlocks.CHERRY_CHAIR.get(), blockState -> this.models().withExistingParent("cherry_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/cherry_planks")));
		this.horizontalBlock(RosesBlocks.BAMBOO_CHAIR.get(), blockState -> this.models().withExistingParent("bamboo_chair", this.modLoc("block/template_chair")).texture("wood", this.mcLoc("block/bamboo_planks")));
		this.simpleBlock(RosesBlocks.OAK_TABLE.get(), this.models().withExistingParent("oak_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/oak_planks")));
		this.simpleBlock(RosesBlocks.SPRUCE_TABLE.get(), this.models().withExistingParent("spruce_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/spruce_planks")));
		this.simpleBlock(RosesBlocks.BIRCH_TABLE.get(), this.models().withExistingParent("birch_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/birch_planks")));
		this.simpleBlock(RosesBlocks.JUNGLE_TABLE.get(), this.models().withExistingParent("jungle_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/jungle_planks")));
		this.simpleBlock(RosesBlocks.ACACIA_TABLE.get(), this.models().withExistingParent("acacia_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/acacia_planks")));
		this.simpleBlock(RosesBlocks.DARK_OAK_TABLE.get(), this.models().withExistingParent("dark_oak_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/dark_oak_planks")));
		this.simpleBlock(RosesBlocks.CRIMSON_TABLE.get(), this.models().withExistingParent("crimson_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/crimson_planks")));
		this.simpleBlock(RosesBlocks.WARPED_TABLE.get(), this.models().withExistingParent("warped_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/warped_planks")));
		this.simpleBlock(RosesBlocks.MANGROVE_TABLE.get(), this.models().withExistingParent("mangrove_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/mangrove_planks")));
		this.simpleBlock(RosesBlocks.CHERRY_TABLE.get(), this.models().withExistingParent("cherry_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/cherry_planks")));
		this.simpleBlock(RosesBlocks.BAMBOO_TABLE.get(), this.models().withExistingParent("bamboo_table", this.modLoc("block/template_table")).texture("wood", this.mcLoc("block/bamboo_planks")));
		this.simpleBlock(RosesBlocks.RUBY_ORE.get());
		this.simpleBlock(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
		this.simpleBlock(RosesBlocks.RUBY_BLOCK.get());
//		ModelFile cog = this.models().withExistingParent("cog", new ResourceLocation("sculk_vein")).texture("sculk_vein", this.modLoc("block/cog")).texture("particle", this.modLoc("block/cog")).renderType("cutout");
//		ModelFile spinningCog = this.models().withExistingParent("spinning_cog", new ResourceLocation("sculk_vein")).texture("sculk_vein", this.modLoc("block/spinning_cog")).texture("particle", this.modLoc("block/spinning_cog")).renderType("cutout");
//		this.getMultipartBuilder(RosesBlocks.COG.get()).part().modelFile(cog).addModel().condition(PipeBlock.NORTH, true).condition(CogBlock.ON, false).end().part().modelFile(cog).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.EAST, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.SOUTH, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.WEST, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.UP, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(90).uvLock(true).addModel().condition(PipeBlock.DOWN, true).condition(CogBlock.ON, false).end().part().modelFile(cog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, false).end().part().modelFile(spinningCog).addModel().condition(PipeBlock.NORTH, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.EAST, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(90).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.SOUTH, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(180).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.WEST, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationY(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.UP, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(90).uvLock(true).addModel().condition(PipeBlock.DOWN, true).condition(CogBlock.ON, true).end().part().modelFile(spinningCog).rotationX(270).uvLock(true).addModel().condition(PipeBlock.DOWN, false).condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false).condition(PipeBlock.SOUTH, false).condition(PipeBlock.UP, false).condition(PipeBlock.WEST, false).condition(CogBlock.ON, true).end();

	}
}
