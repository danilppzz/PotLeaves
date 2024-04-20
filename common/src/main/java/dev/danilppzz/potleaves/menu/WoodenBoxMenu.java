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
                        //new Slot(blockEntity, 0, 0, 0),
                });
    }
}
