package willatendo.roses.server.block;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CogBlock extends Block implements SimpleWaterloggedBlock {
	private static final VoxelShape UP_SHAPE = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	private static final VoxelShape WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_SHAPE = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;
	private static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), (map) -> {
		map.put(Direction.NORTH, NORTH_SHAPE);
		map.put(Direction.EAST, EAST_SHAPE);
		map.put(Direction.SOUTH, SOUTH_SHAPE);
		map.put(Direction.WEST, WEST_SHAPE);
		map.put(Direction.UP, UP_SHAPE);
		map.put(Direction.DOWN, DOWN_SHAPE);
	});
	protected static final Direction[] DIRECTIONS = Direction.values();
	private final ImmutableMap<BlockState, VoxelShape> shapesCache;

	public static final IntegerProperty POWER = BlockStateProperties.POWER;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty ON = BooleanProperty.create("on");

	public CogBlock(Properties properties) {
		super(properties);
		this.shapesCache = this.getShapeForEachState(CogBlock::calculateMultifaceShape);
		this.registerDefaultState(getDefaultMultifaceState(this.stateDefinition).setValue(ON, Boolean.valueOf(false)).setValue(POWER, 0).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return this.shapesCache.get(blockState);
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		boolean flag = false;

		for (Direction direction : DIRECTIONS) {
			if (hasFace(blockState, direction)) {
				BlockPos relativeBlockPos = blockPos.relative(direction);
				if (!canAttachTo(levelReader, direction, relativeBlockPos, levelReader.getBlockState(relativeBlockPos))) {
					return false;
				}

				flag = true;
			}
		}

		return flag;
	}

	@Override
	public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
		return hasAnyVacantFace(blockState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		Level level = blockPlaceContext.getLevel();
		BlockPos blockPos = blockPlaceContext.getClickedPos();
		BlockState blockState = level.getBlockState(blockPos);
		return Arrays.stream(blockPlaceContext.getNearestLookingDirections()).map((p_153865_) -> {
			return this.getStateForPlacement(blockState, level, blockPos, p_153865_);
		}).filter(Objects::nonNull).findFirst().orElse((BlockState) null);
	}

	public BlockState getStateForPlacement(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		if (!this.isValidStateForPlacement(blockGetter, blockState, blockPos, direction)) {
			return null;
		} else {
			BlockState blockstate;
			if (blockState.is(this)) {
				blockstate = blockState;
			} else if (blockState.getFluidState().isSourceOfType(Fluids.WATER)) {
				blockstate = this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true));
			} else {
				blockstate = this.defaultBlockState();
			}

			return blockstate.setValue(getFaceProperty(direction), Boolean.valueOf(true));
		}
	}

	public boolean isValidStateForPlacement(BlockGetter blockGetter, BlockState blockState, BlockPos blockPos, Direction direction) {
		if (this.isFaceSupported(direction) && (!blockState.is(this) || !hasFace(blockState, direction))) {
			BlockPos directedBlockPos = blockPos.relative(direction);
			return canAttachTo(blockGetter, direction, directedBlockPos, blockGetter.getBlockState(directedBlockPos));
		} else {
			return false;
		}
	}

	protected boolean isFaceSupported(Direction direction) {
		return true;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		for (Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				builder.add(getFaceProperty(direction));
			}
		}
		builder.add(POWER, WATERLOGGED, ON);
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState newBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos newBlockPos) {
		if (blockState.getValue(WATERLOGGED)) {
			levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
		}
		if (!hasAnyFace(blockState)) {
			return Blocks.AIR.defaultBlockState();
		} else {
			return hasFace(blockState, direction) && !canAttachTo(levelAccessor, direction, newBlockPos, newBlockState) ? removeFace(blockState, getFaceProperty(direction)) : blockState;
		}
	}

	@Override
	public FluidState getFluidState(BlockState blockState) {
		return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
	}

	public static boolean canAttachTo(BlockGetter blockGetter, Direction direction, BlockPos blockPos, BlockState blockState) {
		return Block.isFaceFull(blockState.getBlockSupportShape(blockGetter, blockPos), direction.getOpposite()) || Block.isFaceFull(blockState.getCollisionShape(blockGetter, blockPos), direction.getOpposite());
	}

	private static BlockState removeFace(BlockState blockState, BooleanProperty booleanProperty) {
		BlockState newState = blockState.setValue(booleanProperty, Boolean.valueOf(false));
		return hasAnyFace(newState) ? newState : Blocks.AIR.defaultBlockState();
	}

	protected static boolean hasAnyFace(BlockState blockState) {
		return Arrays.stream(DIRECTIONS).anyMatch((direction) -> {
			return hasFace(blockState, direction);
		});
	}

	private static VoxelShape calculateMultifaceShape(BlockState blockState) {
		VoxelShape voxelShape = Shapes.empty();

		for (Direction direction : DIRECTIONS) {
			if (hasFace(blockState, direction)) {
				voxelShape = Shapes.or(voxelShape, SHAPE_BY_DIRECTION.get(direction));
			}
		}

		return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
	}

	public static boolean hasFace(BlockState blockState, Direction direction) {
		BooleanProperty booleanProperty = getFaceProperty(direction);
		return blockState.hasProperty(booleanProperty) && blockState.getValue(booleanProperty);
	}

	private static boolean hasAnyVacantFace(BlockState blockState) {
		return Arrays.stream(DIRECTIONS).anyMatch((direction) -> {
			return !hasFace(blockState, direction);
		});
	}

	public static BooleanProperty getFaceProperty(Direction direction) {
		return PROPERTY_BY_DIRECTION.get(direction);
	}

	private static BlockState getDefaultMultifaceState(StateDefinition<Block, BlockState> stateDefinition) {
		BlockState blockState = stateDefinition.any();

		for (BooleanProperty booleanProperty : PROPERTY_BY_DIRECTION.values()) {
			if (blockState.hasProperty(booleanProperty)) {
				blockState = blockState.setValue(booleanProperty, Boolean.valueOf(false));
			}
		}

		return blockState;
	}
}
