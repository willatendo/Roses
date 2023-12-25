package willatendo.roses.server;

import java.util.function.Supplier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesCreativeModeTabs {
	public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(BuiltInRegistries.CREATIVE_MODE_TAB, RosesUtils.ID);

	public static final Supplier<CreativeModeTab> ROSES = CREATIVE_MODE_TABS.register("roses", () -> SimpleUtils.create(RosesUtils.ID, RosesUtils.ID, () -> RosesItems.RUBY.get(), (itemDisplayParameters, output) -> {
		SimpleUtils.fillCreativeTab(RosesItems.ITEMS, itemDisplayParameters, output);
	}).title(RosesUtils.translation("itemGroup", RosesUtils.ID)).build());

	public static void init() {
	}
}
