package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import dev.tonimatas.registry.PotRegistries;
import dev.tonimatas.registry.PotRegistry;
import dev.tonimatas.registry.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final PotRegistry<CreativeModeTab> TABS = PotRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, PotLeaves.MOD_ID);

    public static final RegistryEntry<CreativeModeTab> POTLEAVES = TABS.register(PotLeaves.MOD_ID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModBlocks.SMALL_LEAVE_POT.get()))
            .title(Component.translatable("itemGroup.potleaves"))
            .displayItems(((itemDisplayParameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))).build());
}
