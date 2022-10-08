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
import roses.data.RosesGameEventsTags;
import roses.data.RosesTranslationLanguageProvider;
import roses.server.biome.RosesBiomeModifierSerializers;
import roses.server.block.RosesBlocks;
import roses.server.entity.RosesEntities;
import roses.server.game_event.RosesGameEvents;
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
		RosesGameEvents.GAME_EVENTS.register(bus);

		bus.addListener(this::dataSetup);
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		dataGenerator.addProvider(true, new RosesAdvancements(dataGenerator));
		dataGenerator.addProvider(true, new RosesBiomeTags(dataGenerator, existingFileHelper));
		dataGenerator.addProvider(true, new RosesGameEventsTags(dataGenerator, existingFileHelper));
		dataGenerator.addProvider(true, new RosesTranslationLanguageProvider(dataGenerator, "sv_se", provider -> {
			provider.addItem(RosesItems.RUBY, "Rubin");
			provider.addMusicDisc(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT, "Musikskiva", "Notch - Magnetic Circuit");
			provider.addBlock(RosesBlocks.ROSE, "Rosa");
			provider.addBlock(RosesBlocks.CYAN_FLOWER, "Turkosblomma");
			provider.addBlock(RosesBlocks.CAPRI_CLOTH, "Turkosazurtyg");
			provider.addBlock(RosesBlocks.CHARTREUSE_CLOTH, "Chartreusetyg");
			provider.addBlock(RosesBlocks.CYAN_CLOTH, "Turkostyg");
			provider.addBlock(RosesBlocks.DARK_GRAY_CLOTH, "Mörkgråtyg");
			provider.addBlock(RosesBlocks.GREEN_CLOTH, "Gröntyg");
			provider.addBlock(RosesBlocks.LIGHT_GRAY_CLOTH, "Lättgråtyg");
			provider.addBlock(RosesBlocks.MAGNETA_CLOTH, "Ljuslilatyg");
			provider.addBlock(RosesBlocks.ORANGE_CLOTH, "Orangetyg");
			provider.addBlock(RosesBlocks.PURPLE_CLOTH, "Lilatyg");
			provider.addBlock(RosesBlocks.RED_CLOTH, "Rödtyg");
			provider.addBlock(RosesBlocks.ROSE_CLOTH, "Rosatyg");
			provider.addBlock(RosesBlocks.SPRING_GREEN_CLOTH, "Vårgröntyg");
			provider.addBlock(RosesBlocks.ULTRAMARINE_CLOTH, "Ultramarintyg");
			provider.addBlock(RosesBlocks.VIOLET_CLOTH, "Violetttyg");
			provider.addBlock(RosesBlocks.WHITE_CLOTH, "Vittyg");
			provider.addBlock(RosesBlocks.YELLOW_CLOTH, "Gultyg");
			provider.addBlock(RosesBlocks.ACACIA_CHAIR, "Akaciastol");
			provider.addBlock(RosesBlocks.BIRCH_CHAIR, "Björkstol");
			provider.addBlock(RosesBlocks.CRIMSON_CHAIR, "Karmosinstol");
			provider.addBlock(RosesBlocks.DARK_OAK_CHAIR, "Mörka Ekstol");
			provider.addBlock(RosesBlocks.JUNGLE_CHAIR, "Djungelstol");
			provider.addBlock(RosesBlocks.MANGROVE_CHAIR, "Mangrovestol");
			provider.addBlock(RosesBlocks.OAK_CHAIR, "Ekstol");
			provider.addBlock(RosesBlocks.SPRUCE_CHAIR, "Granstol");
			provider.addBlock(RosesBlocks.WARPED_CHAIR, "Förvrängda stol");
			provider.addBlock(RosesBlocks.RUBY_ORE, "Rubinmalm");
			provider.addBlock(RosesBlocks.DEEPSLATE_RUBY_ORE, "Djupskifferinbäddad rubinmalm");
			provider.addBlock(RosesBlocks.RUBY_BLOCK, "Rubinblock");
			provider.addBlock(RosesBlocks.COG, "Kugge");
			provider.add("itemGroup.roses.roses", "Rosaer");
		}));
	}

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}

	public static RosesRegistrate getRegistrate() {
		return REGISTRATE.get();
	}
}
