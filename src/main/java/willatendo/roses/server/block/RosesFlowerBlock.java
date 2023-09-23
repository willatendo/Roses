package willatendo.roses.server.block;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RosesFlowerBlock extends FlowerBlock {
	public RosesFlowerBlock(Supplier<MobEffect> mobEffect, int effectLength, Properties properties) {
		super(mobEffect, effectLength, properties);
	}

	@Override
	public boolean isFlammable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return true;
	}

	@Override
	public int getFlammability(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return 100;
	}
}
