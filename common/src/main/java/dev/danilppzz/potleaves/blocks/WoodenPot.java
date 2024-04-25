package dev.danilppzz.potleaves.blocks;

import dev.danilppzz.potleaves.blocks.base.PotBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class WoodenPot extends PotBase {

    public WoodenPot(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Block.box(4,0,4,12,7,12);
    }
}
