package dev.danilppzz.potleaves.blockentity;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.danilppzz.potleaves.blockentity.util.BaseBlockEntity;
import dev.danilppzz.potleaves.menu.WoodenBoxMenu;
import dev.danilppzz.potleaves.register.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WoodenBoxBlockEntity extends BaseBlockEntity implements ExtendedMenuProvider {

    public WoodenBoxBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntity.WOODEN_BOX.get(), blockPos, blockState);
    }

    @Override
    public void tick() {
        
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new WoodenBoxMenu(i, inventory, this);
    }

    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        super.saveExtraData(buf);
    }

    @Override
    public int getInventorySize() {
        return 18;
    }
}
