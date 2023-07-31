package willatendo.roses.server;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.item.RosesItems;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RosesUtils.ID);

	public static final RegistryObject<CreativeModeTab> ROSES = CREATIVE_MODE_TABS.register("roses", () -> CreativeModeTab.builder().title(RosesUtils.translation("itemGroup", RosesUtils.ID)).icon(() -> RosesItems.RUBY.get().asItem().getDefaultInstance()).displayItems((itemDisplayParameters, output) -> {
		SimpleUtils.fillCreativeTab(RosesItems.ITEMS, itemDisplayParameters, output);
	}).build());
}
