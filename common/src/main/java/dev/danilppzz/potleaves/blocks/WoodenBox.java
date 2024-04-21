package dev.danilppzz.potleaves.blocks;

import com.mojang.serialization.MapCodec;
import dev.danilppzz.potleaves.blocks.base.BlockEntityBase;
import dev.danilppzz.potleaves.register.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WoodenBox extends BlockEntityBase {
    private static final MapCodec<WoodenBox> CODEC = simpleCodec(WoodenBox::new);

    public WoodenBox(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
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

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return !levelReader.getBlockState(blockPos.below()).isAir();
    }
}
