package dev.danilppzz.potleaves.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CustomLargeWoodenPot extends Block {
    public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public CustomLargeWoodenPot(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return (BlockState)this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
        return (BlockState)p_48722_.setValue(FACING, p_48723_.rotate((Direction)p_48722_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_48719_, Mirror p_48720_) {
        return p_48719_.rotate(p_48720_.getRotation((Direction)p_48719_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        p_48725_.add(new Property[]{FACING});
    }
    public RenderShape getRenderShape(BlockState p_48727_) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        Direction $$1 = (Direction)p_60555_.getValue(FACING);
        if ($$1 != Direction.NORTH && $$1 != Direction.SOUTH) {
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

    static {
        FACING = BlockStateProperties.FACING;
    }
}
