package dev.danilppzz.potleaves.menu;

import dev.danilppzz.potleaves.blockentity.WoodenBoxBlockEntity;
import dev.danilppzz.potleaves.register.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class WoodenBoxMenu extends BaseMenu<WoodenBoxBlockEntity> {
    
    public WoodenBoxMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (WoodenBoxBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public WoodenBoxMenu(int syncId, Inventory inventory, WoodenBoxBlockEntity blockEntity) {
        super(ModMenus.WOODEN_BOX.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 8, 11),
                        new Slot(blockEntity, 1, 26, 11),
                        new Slot(blockEntity, 2, 44, 11),
                        new Slot(blockEntity, 3, 62, 11),
                        new Slot(blockEntity, 4, 80, 11),
                        new Slot(blockEntity, 5, 98, 11),
                        new Slot(blockEntity, 6, 116, 11),
                        new Slot(blockEntity, 7, 134, 11),
                        new Slot(blockEntity, 8, 152, 11),
                        new Slot(blockEntity, 9, 8, 29),
                        new Slot(blockEntity, 10, 26, 29),
                        new Slot(blockEntity, 11, 44, 29),
                        new Slot(blockEntity, 12, 62, 29),
                        new Slot(blockEntity, 13, 80, 29),
                        new Slot(blockEntity, 14, 98, 29),
                        new Slot(blockEntity, 15, 116, 29),
                        new Slot(blockEntity, 16, 134, 29),
                        new Slot(blockEntity, 17, 152, 29),
                });
    }
}
