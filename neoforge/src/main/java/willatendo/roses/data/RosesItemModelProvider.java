package willatendo.roses.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;

import java.util.Objects;

public class RosesItemModelProvider extends ItemModelProvider {
    public RosesItemModelProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(RosesItems.RUBY.get());
        this.basicItem(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get());
        this.basicItem(RosesBlocks.ROSE.get().asItem(), this.modLoc("block/rose"));
        this.basicItem(RosesBlocks.CYAN_FLOWER.get().asItem(), this.modLoc("block/cyan_flower"));
        this.basicBlock(RosesBlocks.CAPRI_CLOTH.get());
        this.basicBlock(RosesBlocks.CHARTREUSE_CLOTH.get());
        this.basicBlock(RosesBlocks.CYAN_CLOTH.get());
        this.basicBlock(RosesBlocks.DARK_GRAY_CLOTH.get());
        this.basicBlock(RosesBlocks.GREEN_CLOTH.get());
        this.basicBlock(RosesBlocks.LIGHT_GRAY_CLOTH.get());
        this.basicBlock(RosesBlocks.MAGENTA_CLOTH.get());
        this.basicBlock(RosesBlocks.ORANGE_CLOTH.get());
        this.basicBlock(RosesBlocks.PURPLE_CLOTH.get());
        this.basicBlock(RosesBlocks.RED_CLOTH.get());
        this.basicBlock(RosesBlocks.ROSE_CLOTH.get());
        this.basicBlock(RosesBlocks.SPRING_GREEN_CLOTH.get());
        this.basicBlock(RosesBlocks.ULTRAMARINE_CLOTH.get());
        this.basicBlock(RosesBlocks.VIOLET_CLOTH.get());
        this.basicBlock(RosesBlocks.WHITE_CLOTH.get());
        this.basicBlock(RosesBlocks.YELLOW_CLOTH.get());
        this.basicBlock(RosesBlocks.OAK_CHAIR.get());
        this.basicBlock(RosesBlocks.SPRUCE_CHAIR.get());
        this.basicBlock(RosesBlocks.BIRCH_CHAIR.get());
        this.basicBlock(RosesBlocks.JUNGLE_CHAIR.get());
        this.basicBlock(RosesBlocks.ACACIA_CHAIR.get());
        this.basicBlock(RosesBlocks.DARK_OAK_CHAIR.get());
        this.basicBlock(RosesBlocks.CRIMSON_CHAIR.get());
        this.basicBlock(RosesBlocks.WARPED_CHAIR.get());
        this.basicBlock(RosesBlocks.MANGROVE_CHAIR.get());
        this.basicBlock(RosesBlocks.CHERRY_CHAIR.get());
        this.basicBlock(RosesBlocks.BAMBOO_CHAIR.get());
        this.basicBlock(RosesBlocks.OAK_TABLE.get());
        this.basicBlock(RosesBlocks.SPRUCE_TABLE.get());
        this.basicBlock(RosesBlocks.BIRCH_TABLE.get());
        this.basicBlock(RosesBlocks.JUNGLE_TABLE.get());
        this.basicBlock(RosesBlocks.ACACIA_TABLE.get());
        this.basicBlock(RosesBlocks.DARK_OAK_TABLE.get());
        this.basicBlock(RosesBlocks.CRIMSON_TABLE.get());
        this.basicBlock(RosesBlocks.WARPED_TABLE.get());
        this.basicBlock(RosesBlocks.MANGROVE_TABLE.get());
        this.basicBlock(RosesBlocks.CHERRY_TABLE.get());
        this.basicBlock(RosesBlocks.BAMBOO_TABLE.get());
        this.basicBlock(RosesBlocks.RUBY_ORE.get());
        this.basicBlock(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
        this.basicBlock(RosesBlocks.RUBY_BLOCK.get());
        this.basicItem(RosesBlocks.COG.get().asItem(), this.modLoc("block/cog"));
    }

    public ItemModelBuilder handheldItem(Item item) {
        return this.handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), new ResourceLocation(BuiltInRegistries.ITEM.getKey(item).getNamespace(), "item/" + BuiltInRegistries.ITEM.getKey(item).getPath()));
    }

    public ItemModelBuilder handheldItem(Item item, ResourceLocation texture) {
        return this.handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), texture);
    }

    public ItemModelBuilder basicItem(Item item, ResourceLocation texture) {
        return this.basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), texture);
    }

    public ItemModelBuilder basicItem(ResourceLocation item, ResourceLocation texture) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", texture);
    }

    public ItemModelBuilder handheldItem(ResourceLocation item, ResourceLocation texture) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/handheld")).texture("layer0", texture);
    }

    public ItemModelBuilder handheldItem(Item item, ResourceLocation[] textures) {
        return this.handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), textures);
    }

    public ItemModelBuilder basicItem(Item item, ResourceLocation[] textures) {
        return this.basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), textures);
    }

    public ItemModelBuilder basicItem(ResourceLocation item, ResourceLocation[] textures) {
        ItemModelBuilder itemModelBuilder = this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/generated"));
        for (int i = 0; i < textures.length; i++) {
            itemModelBuilder.texture("layer" + i, textures[i]);
        }
        return itemModelBuilder;
    }

    public ItemModelBuilder handheldItem(ResourceLocation item, ResourceLocation[] textures) {
        ItemModelBuilder itemModelBuilder = this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/handheld"));
        for (int i = 0; i < textures.length; i++) {
            itemModelBuilder.texture("layer" + i, textures[i]);
        }
        return itemModelBuilder;
    }

    public ItemModelBuilder spawnEggItem(Item item) {
        return this.spawnEggItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }

    public ItemModelBuilder spawnEggItem(ResourceLocation item) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }

    public void basicBlock(Block block) {
        this.getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath()).parent(new ModelFile.UncheckedModelFile(this.modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath())));
    }
}
