package willatendo.roses.server.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.util.RosesUtils;

public class RosesEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RosesUtils.ID);

	public static final RegistryObject<EntityType<Chair>> CHAIR = ENTITY_TYPES.register("chair", () -> EntityType.Builder.<Chair>of(Chair::new, MobCategory.MISC).sized(0.0001F, 0.0001F).build("chair"));
}
