package roses.server.block;

import java.util.Arrays;
import java.util.Objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import roses.server.game_event.RosesGameEvents;

public class CogBlock extends MultifaceBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty ON = BooleanProperty.create("on");

	public CogBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(ON, Boolean.valueOf(false)));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		Level level = blockPlaceContext.getLevel();
		BlockPos blockpos = blockPlaceContext.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		return Arrays.stream(blockPlaceContext.getNearestLookingDirections()).map((direction) -> {
			return this.getStateForPlacement(blockstate, level, blockpos, direction).setValue(ON, Boolean.valueOf(Boolean.valueOf(level.hasNeighborSignal(blockPlaceContext.getClickedPos()))));
		}).filter(Objects::nonNull).findFirst().orElse((BlockState) null);
	}

	@Override
	public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block neighbourBlock, BlockPos neighbourBlockState, boolean flags) {
		if (!level.isClientSide()) {
			boolean flag = blockState.getValue(ON);
			if (flag != level.hasNeighborSignal(blockPos)) {
				if (flag) {
					level.scheduleTick(blockPos, this, 4);
				} else {
					level.setBlock(blockPos, blockState.cycle(ON), 2);
				}
			}
		}
	}

	@Override
	public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		if (blockState.getValue(ON)) {
			serverLevel.gameEvent(RosesGameEvents.COG_RUMBLES.get(), blockPos, Context.of(blockState));
		}

		if (blockState.getValue(ON) && !serverLevel.hasNeighborSignal(blockPos)) {
			serverLevel.setBlock(blockPos, blockState.cycle(ON), 2);
		}
	}

	public FluidState getFluidState(BlockState blockState) {
		return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState offsetState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos offsetBlockPos) {
		if (blockState.getValue(WATERLOGGED)) {
			levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
		}

		return super.updateShape(blockState, direction, offsetState, levelAccessor, blockPos, offsetBlockPos);
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
