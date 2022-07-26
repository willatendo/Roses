package roses.server.block;

import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import roses.server.game_event.RosesGameEvents;

public class CogBlock extends MultifaceBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty ON = BooleanProperty.create("on");

	public CogBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(ON, Boolean.valueOf(false)));
	}

	@Override
	public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		if (blockState.getValue(ON)) {
			serverLevel.gameEvent(RosesGameEvents.COG_RUMBLES.get(), blockPos, Context.of(blockState));
		}
	}

	private void updatePower(Level level, BlockPos blockPos, BlockState blockState) {
		for (Direction direction : Direction.values()) {
			BlockState offsetBlockState = level.getBlockState(blockPos.relative(direction));
			if (offsetBlockState.is(this) && offsetBlockState.getValue(ON)) {
				level.setBlock(blockPos, blockState.setValue(ON, true), 3);
				return;
			}

			if (offsetBlockState.is(this) && !offsetBlockState.getValue(ON)) {
				level.setBlock(blockPos, blockState.setValue(ON, false), 3);
				return;
			}

			if (offsetBlockState.is(Blocks.LEVER) && offsetBlockState.getValue(LeverBlock.POWERED)) {
				level.setBlock(blockPos, blockState.setValue(ON, true), 3);
				return;
			}

			if (offsetBlockState.is(Blocks.LEVER) && !offsetBlockState.getValue(LeverBlock.POWERED)) {
				level.setBlock(blockPos, blockState.setValue(ON, false), 3);
				return;
			}
		}
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		List<Direction> directionsToCheck = Lists.newArrayList();

		for (Direction directions : Direction.Plane.HORIZONTAL) {
			BlockState blockStateOnOffset = levelReader.getBlockState(blockPos.relative(directions));
			if (blockStateOnOffset.is(this)) {
				directionsToCheck.add(directions);
			}
		}

		if (directionsToCheck.size() > 2) {
			if (directionsToCheck.get(0) != null && directionsToCheck.get(2) != null) {
				if (!(directionsToCheck.get(0).getOpposite() == directionsToCheck.get(2))) {
					return false;
				}
				if (directionsToCheck.size() > 3) {
					if (!(directionsToCheck.get(1).getOpposite() == directionsToCheck.get(3))) {
						return false;
					}
				}
			}
		}
		return super.canSurvive(blockState, levelReader, blockPos);
	}

	@Override
	public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState offsetBlockState, boolean flags) {
		this.updatePower(level, blockPos, blockState);
		super.onPlace(blockState, level, blockPos, offsetBlockState, flags);
	}

	@Override
	public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos offsetBlockPos, boolean flags) {
		this.updatePower(level, blockPos, blockState);
		super.neighborChanged(blockState, level, blockPos, block, offsetBlockPos, flags);
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED, ON);
	}

	@Override
	public MultifaceSpreader getSpreader() {
		return new MultifaceSpreader(this);
	}

	@Override
	public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
		return blockPlaceContext.getItemInHand().is(this.asItem());
	}
}
