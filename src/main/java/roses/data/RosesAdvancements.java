package roses.data;

import static roses.RosesMod.ID;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import roses.server.RosesRegistry;
import roses.server.RosesTags;

public class RosesAdvancements implements DataProvider {
	private static final String LANG = "advancement." + ID + ".";
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	private final DataGenerator generator;

	public RosesAdvancements(DataGenerator generator) {
		this.generator = generator;
	}

	public void register(Consumer<Advancement> consumer) {
		Advancement.Builder.advancement().display(RosesRegistry.ROSE.asStack(), new TranslatableComponent(LANG + "root"), new TranslatableComponent(LANG + "root.desc"), new ResourceLocation(ID, "textures/gui/advancements.png"), FrameType.TASK, false, false, false).addCriterion("has_legacy_content", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(RosesTags.Items.LEGACY_BLOCKS).build())).save(consumer, ID + ":root");
	}

	@Override
	public void run(HashCache cache) throws IOException {
		Path path = this.generator.getOutputFolder();
		Set<ResourceLocation> set = Sets.newHashSet();
		Consumer<Advancement> consumer = (p_204017_3_) -> {
			if (!set.add(p_204017_3_.getId()))
				throw new IllegalStateException("Duplicate advancement " + p_204017_3_.getId());

			Path path1 = getPath(path, p_204017_3_);

			try {
				DataProvider.save(GSON, cache, p_204017_3_.deconstruct().serializeToJson(), path1);
			} catch (IOException ioexception) {
				LOGGER.error("Couldn't save advancement {}", path1, ioexception);
			}
		};

		register(consumer);
	}

	private static Path getPath(Path path, Advancement advancement) {
		return path.resolve("data/" + advancement.getId().getNamespace() + "/advancements/legacy/" + advancement.getId().getPath() + ".json");
	}

	@Override
	public String getName() {
		return "Roses Advancements";
	}
}
