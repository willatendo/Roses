package roses;

import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import roses.data.RosesAdvancements;
import roses.data.RosesBiomeTags;
import roses.server.biome.RosesBiomeModifierSerializers;
import roses.server.block.RosesBlocks;
import roses.server.entity.RosesEntities;
import roses.server.item.RosesItems;
import roses.server.sound.RosesSounds;
import roses.server.util.RosesRegistrate;

@Mod(RosesMod.ID)
public class RosesMod {
	public static final String ID = "roses";

	private static final NonNullSupplier<RosesRegistrate> REGISTRATE = RosesRegistrate.lazy(RosesMod.ID);

	public static final CreativeModeTab ROSES_TAB = new CreativeModeTab(RosesMod.ID + "." + RosesMod.ID) {
		@Override
		public ItemStack makeIcon() {
			return RosesBlocks.ROSE.asStack();
		}

		@Override
		public String getRecipeFolderName() {
			return "roses/roses";
		}
	};

	public RosesMod() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();

		RosesSounds.SOUND_EVENTS.register(bus);
		RosesItems.init();
		RosesBlocks.init();
		RosesEntities.init();
		RosesBiomeModifierSerializers.BIOME_MODIFIER_SERIALIZERS.register(bus);

		bus.addListener(this::dataSetup);
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		dataGenerator.addProvider(true, new RosesAdvancements(dataGenerator));
		dataGenerator.addProvider(true, new RosesBiomeTags(dataGenerator, existingFileHelper));
	}

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}

	public static RosesRegistrate getRegistrate() {
		return REGISTRATE.get();
	}
}
