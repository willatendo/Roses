package willatendo.roses.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import willatendo.roses.server.block.CogBlock;
import willatendo.roses.server.gameevent.RosesGameEvents;

public class CogBlockEntity extends BlockEntity {
    private int noiseTick = 0;

    public CogBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RosesBlockEntities.COG.get(), blockPos, blockState);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, CogBlockEntity cogBlockEntity) {
        if (blockState.getValue(CogBlock.POWERED) == true) {
            if (cogBlockEntity.noiseTick == 40) {
                level.gameEvent(RosesGameEvents.COG_RUMBLES, blockPos, Context.of(blockState));
                cogBlockEntity.noiseTick = 0;
            } else {
                cogBlockEntity.noiseTick++;
            }
        } else {
            cogBlockEntity.noiseTick = 0;
        }
    }

    @Override
    public void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.noiseTick = compoundTag.getInt("NoiseTick");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("NoiseTick", this.noiseTick);
    }
}
