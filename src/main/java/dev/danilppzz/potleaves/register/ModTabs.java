package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotLeaves.MODID);

    public static final RegistryObject<CreativeModeTab> POTLEAVES = TABS.register(PotLeaves.MODID, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModBlocks.SMALL_LEAVE_POT.get()))
            .title(Component.translatable("itemGroup.potleaves"))
            .displayItems(((itemDisplayParameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))).build());
}
