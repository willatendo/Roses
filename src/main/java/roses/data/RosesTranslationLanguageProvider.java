package roses.data;

import java.util.function.Supplier;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import roses.RosesMod;

public class RosesTranslationLanguageProvider extends LanguageProvider {
	private final AddTranslations translations;

	public RosesTranslationLanguageProvider(DataGenerator dataGenerator, String local, AddTranslations addTranslations) {
		super(dataGenerator, RosesMod.ID, local);
		this.translations = addTranslations;
	}

	@Override
	protected void addTranslations() {
		this.translations.run(this);
	}

	public void addAdvancement(String advancement, String title, String description) {
		this.add("advancement." + RosesMod.ID + "." + advancement + ".title", title);
		this.add("advancement." + RosesMod.ID + "." + advancement + ".desc", description);
	}

	public void addMusicDisc(Supplier<RecordItem> musicDisc, String name, String description) {
		this.addItem(musicDisc, name);
		this.add("item." + RosesMod.ID + "." + ForgeRegistries.ITEMS.getKey(musicDisc.get()).getPath() + ".desc", description);
	}

	public static interface AddTranslations {
		void run(RosesTranslationLanguageProvider languageProvider);
	}
}
