package dev.danilppzz.potleaves.blocks;

import dev.danilppzz.potleaves.blocks.base.PotBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class DesertPot extends PotBase {

    public DesertPot(Properties properties) {
        super(properties.dynamicShape().noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Block.box(5,0,5,11,6,11);
    }

    public enum Type {
        DESERT("desert_pot", SoundType.STONE);

        public final String extension;
        public final SoundType soundType;

        Type(String extension, SoundType soundType) {
            this.extension = extension;
            this.soundType = soundType;
        }
    }
}
