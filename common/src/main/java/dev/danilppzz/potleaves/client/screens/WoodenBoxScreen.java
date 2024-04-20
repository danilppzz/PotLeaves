package dev.danilppzz.potleaves.client.screens;

import dev.danilppzz.potleaves.menu.WoodenBoxMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class WoodenBoxScreen extends BaseScreen<WoodenBoxMenu> {
    public WoodenBoxScreen(WoodenBoxMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component, 0, 0, "gui");
    }
}
