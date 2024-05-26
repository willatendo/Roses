package willatendo.roses.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class RosesBlockEntities {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPE = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, RosesUtils.ID);

    public static final SimpleHolder<BlockEntityType<CogBlockEntity>> COG = BLOCK_ENTITY_TYPE.register("cog", () -> BlockEntityType.Builder.of(CogBlockEntity::new, RosesBlocks.COG.get()).build(null));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(BLOCK_ENTITY_TYPE);
    }
}
