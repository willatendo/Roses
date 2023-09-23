package willatendo.roses.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TableBlock extends Block {
	public static final VoxelShape SHAPE = Shapes.or(Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 13.0D, 15.0D));

	public TableBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFlammable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return true;
	}

	@Override
	public int getFlammability(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return 20;
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}
}
