package willatendo.roses.server.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class RosesEntities {
	public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(BuiltInRegistries.ENTITY_TYPE, RosesUtils.ID);

	public static final RegistryHolder<EntityType<Chair>> CHAIR = ENTITY_TYPES.register("chair", () -> EntityType.Builder.<Chair>of(Chair::new, MobCategory.MISC).sized(0.0001F, 0.0001F).build("chair"));

	public static void init() {
	}
}
