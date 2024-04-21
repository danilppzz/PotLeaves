package dev.danilppzz.potleaves.register;

import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.menu.WoodenBoxMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(PotLeaves.MOD_ID, Registry.MENU_REGISTRY);

    public static final RegistrySupplier<MenuType<WoodenBoxMenu>> WOODEN_BOX = MENUS.register("wooden_box_menu", () ->
            MenuRegistry.ofExtended(WoodenBoxMenu::new));
}
