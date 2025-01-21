package dev.danilppzz.potleaves.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(PotLeaves.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> POT_LEAVES = TABS.register(PotLeaves.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModBlocks.MUSA_WOODEN_POT.get()))
            .title(Component.translatable("itemGroup.potleaves"))
            .displayItems(((itemDisplayParameters, output) -> ModItems.ITEMS.forEach(itemRegistrySupplier -> output.accept(itemRegistrySupplier.get()))))
            .build());
}
