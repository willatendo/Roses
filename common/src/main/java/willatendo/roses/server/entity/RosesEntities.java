package willatendo.roses.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;

public class RosesEntities {
    public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(Registries.ENTITY_TYPE, RosesUtils.ID);

    public static final SimpleHolder<EntityType<Chair>> CHAIR = ENTITY_TYPES.register("chair", () -> SimpleUtils.entityTypeBuilder("chair", Chair::new, MobCategory.MISC, 0.0001F, 0.0001F));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(ENTITY_TYPES);
    }
}
