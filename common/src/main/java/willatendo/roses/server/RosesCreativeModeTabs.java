package willatendo.roses.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.CopperHornInstrument;
import willatendo.roses.server.item.CopperHornItem;
import willatendo.roses.server.item.RosesCopperHornInstrumentTags;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;
import java.util.function.Supplier;

public class RosesCreativeModeTabs {
    public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(Registries.CREATIVE_MODE_TAB, RosesUtils.ID);

    public static final Supplier<CreativeModeTab> ROSES = CREATIVE_MODE_TABS.register("roses", () -> SimpleUtils.create(RosesUtils.ID, RosesUtils.ID, () -> RosesItems.RUBY.get(), (itemDisplayParameters, output) -> {
        output.accept(RosesItems.RUBY.get());
        output.accept(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get());
        output.accept(RosesItems.MUSIC_DISC_DOG.get());
        itemDisplayParameters.holders().lookup(RosesRegistries.COPPER_HORN_INSTRUMENTS).ifPresent(copperHornInstrumentRegistryLookup -> {
            RosesCreativeModeTabs.generateCopperHornInstrumentTypes(output, copperHornInstrumentRegistryLookup, RosesItems.COPPER_HORN.get(), RosesCopperHornInstrumentTags.COPPER_HORNS);
        });
        output.accept(RosesBlocks.ROSE.get());
        output.accept(RosesBlocks.CYAN_FLOWER.get());
        output.accept(RosesBlocks.CAPRI_CLOTH.get());
        output.accept(RosesBlocks.CHARTREUSE_CLOTH.get());
        output.accept(RosesBlocks.CYAN_CLOTH.get());
        output.accept(RosesBlocks.DARK_GRAY_CLOTH.get());
        output.accept(RosesBlocks.GREEN_CLOTH.get());
        output.accept(RosesBlocks.LIGHT_GRAY_CLOTH.get());
        output.accept(RosesBlocks.MAGENTA_CLOTH.get());
        output.accept(RosesBlocks.ORANGE_CLOTH.get());
        output.accept(RosesBlocks.PURPLE_CLOTH.get());
        output.accept(RosesBlocks.RED_CLOTH.get());
        output.accept(RosesBlocks.ROSE_CLOTH.get());
        output.accept(RosesBlocks.SPRING_GREEN_CLOTH.get());
        output.accept(RosesBlocks.ULTRAMARINE_CLOTH.get());
        output.accept(RosesBlocks.VIOLET_CLOTH.get());
        output.accept(RosesBlocks.WHITE_CLOTH.get());
        output.accept(RosesBlocks.YELLOW_CLOTH.get());
        output.accept(RosesBlocks.OAK_CHAIR.get());
        output.accept(RosesBlocks.SPRUCE_CHAIR.get());
        output.accept(RosesBlocks.BIRCH_CHAIR.get());
        output.accept(RosesBlocks.JUNGLE_CHAIR.get());
        output.accept(RosesBlocks.ACACIA_CHAIR.get());
        output.accept(RosesBlocks.DARK_OAK_CHAIR.get());
        output.accept(RosesBlocks.CRIMSON_CHAIR.get());
        output.accept(RosesBlocks.WARPED_CHAIR.get());
        output.accept(RosesBlocks.MANGROVE_CHAIR.get());
        output.accept(RosesBlocks.CHERRY_CHAIR.get());
        output.accept(RosesBlocks.BAMBOO_CHAIR.get());
        output.accept(RosesBlocks.OAK_TABLE.get());
        output.accept(RosesBlocks.SPRUCE_TABLE.get());
        output.accept(RosesBlocks.BIRCH_TABLE.get());
        output.accept(RosesBlocks.JUNGLE_TABLE.get());
        output.accept(RosesBlocks.ACACIA_TABLE.get());
        output.accept(RosesBlocks.DARK_OAK_TABLE.get());
        output.accept(RosesBlocks.CRIMSON_TABLE.get());
        output.accept(RosesBlocks.WARPED_TABLE.get());
        output.accept(RosesBlocks.MANGROVE_TABLE.get());
        output.accept(RosesBlocks.CHERRY_TABLE.get());
        output.accept(RosesBlocks.BAMBOO_TABLE.get());
        output.accept(RosesBlocks.RUBY_ORE.get());
        output.accept(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
        output.accept(RosesBlocks.RUBY_BLOCK.get());
        output.accept(RosesBlocks.COG.get());
    }).build());

    private static void generateCopperHornInstrumentTypes(CreativeModeTab.Output output, HolderLookup<CopperHornInstrument> copperHornInstrumentHolderLookup, Item item, TagKey<CopperHornInstrument> copperHornInstrumentTagKey) {
        copperHornInstrumentHolderLookup.get(copperHornInstrumentTagKey).ifPresent(copperHornInstrumentNamed -> {
            copperHornInstrumentNamed.stream().map(copperHornInstrumentHolder -> {
                return CopperHornItem.create(item, copperHornInstrumentHolder);
            }).forEach((itemStack) -> {
                output.accept(itemStack);
            });
        });
    }


    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(CREATIVE_MODE_TABS);
    }
}
