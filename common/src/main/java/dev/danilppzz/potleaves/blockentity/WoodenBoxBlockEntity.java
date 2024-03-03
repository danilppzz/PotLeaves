package dev.danilppzz.potleaves.blockentity;

import dev.danilppzz.potleaves.register.ModBlockEntity;
import dev.tonimatas.inventory.ModInventory;
import dev.tonimatas.menu.ExtraDataMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WoodenBoxBlockEntity extends BlockEntity implements ExtraDataMenuProvider, ModInventory, WorldlyContainer {

    public WoodenBoxBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntity.WOODEN_BOX.get(), blockPos, blockState);
    }

    @Override
    public void writeExtraData(ServerPlayer player, FriendlyByteBuf buffer) {
        
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("Wooden Box"); // TODO: Finish it
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    public int @NotNull [] getSlotsForFace(Direction direction) {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return false;
    }
}
