package willatendo.roses.server.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.roses.server.block.entity.CogBlockEntity;
import willatendo.roses.server.block.entity.RosesBlockEntities;
import willatendo.roses.server.util.RosesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CogBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
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

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public CogBlock(Properties properties) {
        super(properties);
        this.shapesCache = this.getShapeForEachState(CogBlock::calculateMultifaceShape);
        this.registerDefaultState(getDefaultMultifaceState(this.stateDefinition).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(POWERED, Boolean.valueOf(false)));
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos neighbourBlockPos, boolean flag) {
        if (!level.isClientSide) {
            boolean isPowered = blockState.getValue(POWERED);
            if (isPowered != level.hasNeighborSignal(blockPos)) {
                if (isPowered) {
                    level.scheduleTick(blockPos, this, 4);
                } else {
                    level.setBlock(blockPos, blockState.cycle(POWERED), 2);
                }
            }
        }
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(POWERED) && !serverLevel.hasNeighborSignal(blockPos)) {
            serverLevel.setBlock(blockPos, blockState.cycle(POWERED), 2);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return RosesBlockEntities.COG.get().create(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : SimpleUtils.createTickerHelper(blockEntityType, RosesBlockEntities.COG.get(), CogBlockEntity::serverTick);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext blockGetter, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(RosesUtils.translation("block", "cog.desc").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(itemStack, blockGetter, components, tooltipFlag);
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
        return Arrays.stream(blockPlaceContext.getNearestLookingDirections()).map((direction) -> {
            return this.getStateForPlacement(blockState, level, blockPos, direction);
        }).filter(Objects::nonNull).findFirst().orElse((BlockState) null);
    }

    public BlockState getStateForPlacement(BlockState blockState, Level level, BlockPos blockPos, Direction direction) {
        if (!this.isValidStateForPlacement(level, blockState, blockPos, direction)) {
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

            return blockstate.setValue(getFaceProperty(direction), Boolean.valueOf(true)).setValue(POWERED, Boolean.valueOf(level.hasNeighborSignal(blockPos)));
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
        builder.add(WATERLOGGED, POWERED);
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
