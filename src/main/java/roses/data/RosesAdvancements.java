package roses.data;

import static roses.RosesMod.ID;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Sets;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import roses.server.RosesTags;
import roses.server.block.RosesBlocks;

public class RosesAdvancements implements DataProvider {
	private static final String LANG = "advancement." + ID + ".";
	private static final Logger LOGGER = LogManager.getLogger();
	private final DataGenerator generator;

	public RosesAdvancements(DataGenerator generator) {
		this.generator = generator;
	}

	public void register(Consumer<Advancement> consumer) {
		advancement(() -> RosesBlocks.ROSE.getUnchecked(), "root", FrameType.TASK, false, false, false, "has_legacy_content", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(RosesTags.Items.LEGACY_BLOCKS).build()), consumer);
	}

	public void advancement(Supplier<ItemLike> display, String id, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden, String criteria, CriterionTriggerInstance trigger, Consumer<Advancement> consumer) {
		Advancement.Builder.advancement().display(display.get(), Component.translatable(LANG + id + ".title"), Component.translatable(LANG + id + ".desc"), new ResourceLocation(ID, "textures/gui/advancements.png"), frame, showToast, announceToChat, hidden).addCriterion(id, trigger).save(consumer, ID + ":" + id);
	}

	@Override
	public void run(CachedOutput cache) throws IOException {
		Path path = this.generator.getOutputFolder();
		Set<ResourceLocation> set = Sets.newHashSet();
		Consumer<Advancement> consumer = (advancement) -> {
			if (!set.add(advancement.getId())) {
				throw new IllegalStateException("Duplicate advancement " + advancement.getId());
			}

			Path path1 = getPath(path, advancement);

			try {
				DataProvider.saveStable(cache, advancement.deconstruct().serializeToJson(), path1);
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
