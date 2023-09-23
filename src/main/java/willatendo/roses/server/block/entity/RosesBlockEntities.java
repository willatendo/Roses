package willatendo.roses.server.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.util.RosesUtils;

public class RosesBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RosesUtils.ID);

	public static final RegistryObject<BlockEntityType<CogBlockEntity>> COG = BLOCK_ENTITY_TYPE.register("cog", () -> BlockEntityType.Builder.of(CogBlockEntity::new, RosesBlocks.COG.get()).build(null));
}
