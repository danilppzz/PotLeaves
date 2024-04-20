package dev.danilppzz.potleaves.blocks;

import dev.danilppzz.potleaves.register.ModBlockEntity;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WoodenBox extends AbstractEntityBlock {
    public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public WoodenBox(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    //@Override
    //public @NotNull VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
    //    Direction $$1 = p_60555_.getValue(FACING);
    //    if ($$1 != Direction.NORTH && $$1 != Direction.SOUTH) {
    //        return Block.box(4,0,2,12,7,14);
    //    }
//
    //    return Block.box(2,0,4,14,7,12);
    //}

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ModBlockEntity.WOODEN_BOX.get().create(blockPos, blockState);
    }
}
