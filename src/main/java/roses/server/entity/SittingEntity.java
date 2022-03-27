package roses.server.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class SittingEntity extends Entity {
	public static EntityType.EntityFactory<SittingEntity> factory = (type, level) -> new SittingEntity(type, level);

	public SittingEntity(EntityType<? extends SittingEntity> type, Level world) {
		super(type, world);
		this.noPhysics = true;
	}

	public void setSeatPos(BlockPos pos) {
		setPos(pos.getX() + 0.5D, pos.getY() + 0.25D, pos.getZ() + 0.5D);
	}

	@Override
	protected void defineSynchedData() {
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag) {
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag) {
	}

	@Override
	protected void removePassenger(Entity entity) {
		super.removePassenger(entity);
		if (!this.isRemoved() && !this.level.isClientSide()) {
			entity.absMoveTo(entity.getX(), entity.getY(), entity.getZ(), entity.yRotO, entity.xRotO);
			this.discard();
		}
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
