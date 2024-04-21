package dev.danilppzz.potleaves.blockentity.util;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.danilppzz.potleaves.inventory.ModInventory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
public abstract class BaseBlockEntity extends BlockEntity implements ModInventory, WorldlyContainer, ExtendedMenuProvider {
    public final NonNullList<ItemStack> inventory;

    public BaseBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        inventory = NonNullList.withSize(getInventorySize(), ItemStack.EMPTY);
    }

    public abstract void tick();
    

    public int getInventorySize() {
        return 0;
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("");
    }

    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.getBlockPos());
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        if (getInventorySize() > 0) {
            ContainerHelper.loadAllItems(compoundTag, this.inventory);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (getInventorySize() > 0) {
            ContainerHelper.saveAllItems(compoundTag, this.inventory);
        }
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
        ItemStack slotStack = this.getItem(slot);
        return slotStack.isEmpty() || (slotStack.is(stack.getItem()) && slotStack.getCount() <= slotStack.getMaxStackSize());
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }
    
    
}
