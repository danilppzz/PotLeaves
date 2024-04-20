package dev.danilppzz.potleaves.menu;


import dev.danilppzz.potleaves.blockentity.util.BaseBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class BaseMenu<T extends BaseBlockEntity> extends AbstractContainerMenu {
    protected final T blockEntity;
    protected final Level level;
    protected final Player player;

    public BaseMenu(MenuType<?> type, int syncId, Inventory inventory, T entity, Slot[] slots) {
        super(type, syncId);
        this.blockEntity = entity;
        this.level = entity.getLevel();
        this.player = inventory.player;

        checkContainerSize(inventory, this.blockEntity.getContainerSize());

        this.blockEntity.startOpen(inventory.player);

        for (Slot slot : slots) {
            this.addSlot(slot);
        }

        this.setPlayerInventory(inventory);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.blockEntity.stillValid(player);
    }

    protected void setPlayerInventory(Inventory inventory) {
        int m;
        int l;

        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                addSlot(new Slot(inventory, l + m * 9 + 9, 8 + l * 18, 84 - 2 + m * 18));
            }
        }

        for (m = 0; m < 9; ++m) {
            addSlot(new Slot(inventory, m, 8 + m * 18, 142 -2));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (index < this.blockEntity.getContainerSize()) {
                if (!this.moveItemStackTo(originalStack, this.blockEntity.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.blockEntity.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return newStack;
    }

    @Override
    public void clicked(int slotIndex, int button, @NotNull ClickType actionType, @NotNull Player player) {
        super.clicked(slotIndex, button, actionType, player);
        this.broadcastFullState();
    }
}
