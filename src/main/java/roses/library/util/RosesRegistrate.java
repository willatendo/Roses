package roses.library.util;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RosesRegistrate extends AbstractRegistrate<RosesRegistrate> {
	protected RosesRegistrate(String modid) {
		super(modid);
	}
	
	public static NonNullSupplier<RosesRegistrate> lazy(String modid) {
		return NonNullSupplier.of(() -> new RosesRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus()));
	}
}
