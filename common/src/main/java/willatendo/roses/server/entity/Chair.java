package willatendo.roses.server.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Chair extends Entity {
    public Chair(EntityType<? extends Chair> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = true;
    }

    public void setChairPos(BlockPos blockPos) {
        this.setPos(blockPos.getX() + 0.5D, blockPos.getY() + 0.25D, blockPos.getZ() + 0.5D);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    protected void removePassenger(Entity entity) {
        super.removePassenger(entity);
        if (!this.isRemoved() && !this.level().isClientSide()) {
            entity.absMoveTo(entity.getX(), entity.getY(), entity.getZ(), entity.yRotO, entity.xRotO);
            this.discard();
        }
    }
}
