package dev.tonimatas.inventory;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface ModInventory extends Container {
    static ModInventory of(NonNullList<ItemStack> items) {
        return () -> items;
    }

    static ModInventory create(final int slots) {
        return new ModInventory() {
            private final NonNullList<ItemStack> inventory;

            {
                this.inventory = NonNullList.withSize(slots, ItemStack.EMPTY);
            }

            public NonNullList<ItemStack> getItems() {
                return this.inventory;
            }
        };
    }

    NonNullList<ItemStack> getItems();

    default int getContainerSize() {
        return this.getItems().size();
    }

    default boolean isEmpty() {
        for(int i = 0; i < this.getContainerSize(); ++i) {
            ItemStack stack = this.getItem(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    default @NotNull ItemStack getItem(int slot) {
        return this.getItems().get(slot);
    }

    default @NotNull ItemStack removeItem(int slot, int count) {
        ItemStack result = ContainerHelper.removeItem(this.getItems(), slot, count);
        if (!result.isEmpty()) {
            this.setChanged();
        }

        return result;
    }

    default @NotNull ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.getItems(), slot);
    }

    default void setItem(int slot, ItemStack stack) {
        this.getItems().set(slot, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

    }

    default void clearContent() {
        this.getItems().clear();
    }

    default void setChanged() {
    }

    default boolean stillValid(Player player) {
        return true;
    }
}
