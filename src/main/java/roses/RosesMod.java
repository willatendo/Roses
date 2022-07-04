package roses;

import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import roses.data.RosesAdvancements;
import roses.server.RosesRegistry;
import roses.server.util.RosesRegistrate;

@Mod(RosesMod.ID)
public class RosesMod {
	public static final String ID = "roses";
	public static final NonNullSupplier<RosesRegistrate> CENTRAL_REGISTRATE = RosesRegistrate.lazy(RosesMod.ID);

	public RosesMod() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();

		RosesRegistry.init();

		bus.addListener(this::dataSetup);
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		dataGenerator.addProvider(true, new RosesAdvancements(dataGenerator));
	}

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}
}
