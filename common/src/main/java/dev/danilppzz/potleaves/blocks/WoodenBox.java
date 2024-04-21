package dev.danilppzz.potleaves.blocks;

import dev.danilppzz.potleaves.blocks.base.BlockEntityBase;
import dev.danilppzz.potleaves.register.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WoodenBox extends BlockEntityBase {

    public WoodenBox(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        if (direction != Direction.NORTH && direction != Direction.SOUTH) {
            return Block.box(4,0,2,12,7,14);
        }

        return Block.box(2,0,4,14,7,12);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ModBlockEntity.WOODEN_BOX.get().create(blockPos, blockState);
    }
}
