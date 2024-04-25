package dev.danilppzz.potleaves.blocks;

import dev.danilppzz.potleaves.blocks.base.BlockBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class LargeWoodenPot extends BlockBase {

    public LargeWoodenPot(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        if (direction != Direction.NORTH && direction != Direction.SOUTH) {
            return Shapes.or(
                    Block.box(3, 0, 11, 13, 1, 13),
                    Block.box(3, 1, 0, 13, 6, 16),
                    Block.box(3, 7, 0, 13, 8, 2),
                    Block.box(11, 6, 0, 13, 7, 2),
                    Block.box(3, 6, 0, 5, 7, 2),
                    Block.box(11, 6, 14, 13, 7, 16),
                    Block.box(3, 6, 14, 5, 7, 16),
                    Block.box(3, 7, 14, 13, 8, 16),
                    Block.box(3, 0, 3, 13, 1, 5)
            );
        }

        return Shapes.or(
                Block.box(3, 0, 3, 5, 1, 13),
                Block.box(0, 1, 3, 16, 6, 13),
                Block.box(14, 7, 3, 16, 8, 13),
                Block.box(14, 6, 11, 16, 7, 13),
                Block.box(14, 6, 3, 16, 7, 5),
                Block.box(0, 6, 11, 2, 7, 13),
                Block.box(0, 6, 3, 2, 7, 5),
                Block.box(0, 7, 3, 2, 8, 13),
                Block.box(11, 0, 3, 13, 1, 13)
        );
    }
}
