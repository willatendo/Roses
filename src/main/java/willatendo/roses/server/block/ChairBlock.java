package willatendo.roses.server.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.roses.server.entity.Chair;
import willatendo.roses.server.entity.RosesEntities;

public class ChairBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
	private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public ChairBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.SOUTH));
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState offsetState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos offsetBlockPos) {
		if (blockState.getValue(WATERLOGGED)) {
			levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
		}

		return super.updateShape(blockState, direction, offsetState, levelAccessor, blockPos, offsetBlockPos);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		LevelAccessor levelAccessor = blockPlaceContext.getLevel();
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(levelAccessor.getFluidState(blockPlaceContext.getClickedPos()).getType() == Fluids.WATER)).setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		if (!level.isClientSide()) {
			if (isPlayerInRange(player, blockPos)) {
				Chair chair = RosesEntities.CHAIR.get().create(level);
				chair.setChairPos(blockPos);
				level.addFreshEntity(chair);
				player.startRiding(chair);
				return InteractionResult.SUCCESS;
			}
		}

		return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
	}

	private static boolean isPlayerInRange(Player player, BlockPos blockPos) {
		BlockPos playerPos = player.blockPosition();
		int blockReachDistance = 2;

		if (blockReachDistance == 0) {
			return playerPos.getY() - blockPos.getY() <= 1 && playerPos.getX() - blockPos.getX() == 0 && playerPos.getZ() - blockPos.getZ() == 0;
		}

		AABB range = new AABB(blockPos.getX() + blockReachDistance, blockPos.getY() + blockReachDistance, blockPos.getZ() + blockReachDistance, blockPos.getX() - blockReachDistance, blockPos.getY() - blockReachDistance, blockPos.getZ() - blockReachDistance);
		return range.minX <= playerPos.getX() && range.minY <= playerPos.getY() && range.minZ <= playerPos.getZ() && range.maxX >= playerPos.getX() && range.maxY >= playerPos.getY() && range.maxZ >= playerPos.getZ();
	}

	@Override
	public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newState, boolean isMoving) {
		double x = blockPos.getX();
		double y = blockPos.getY();
		double z = blockPos.getZ();
		List<Chair> entities = level.getEntitiesOfClass(Chair.class, new AABB(x, y, z, x + 1, y + 1, z + 1));
		for (Chair entity : entities) {
			entity.remove(Entity.RemovalReason.DISCARDED);
		}
		super.onRemove(blockState, level, blockPos, newState, isMoving);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, FACING);
	}
}
