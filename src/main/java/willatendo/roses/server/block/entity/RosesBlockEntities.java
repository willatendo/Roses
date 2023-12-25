package willatendo.roses.server.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class RosesBlockEntities {
	public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPE = SimpleRegistry.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, RosesUtils.ID);

	public static final RegistryHolder<BlockEntityType<CogBlockEntity>> COG = BLOCK_ENTITY_TYPE.register("cog", () -> BlockEntityType.Builder.of(CogBlockEntity::new, RosesBlocks.COG.get()).build(null));

	public static void init() {
	}
}
