package dev.danilppzz.potleaves.client;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import dev.danilppzz.potleaves.client.screens.WoodenBoxScreen;
import dev.danilppzz.potleaves.register.ModBlocks;
import dev.danilppzz.potleaves.register.ModMenus;
import net.minecraft.client.renderer.RenderType;

public class PotLeavesClient {
    public static void init() {
        RenderTypeRegistry.register(RenderType.cutout(),
                ModBlocks.SLIM_CACTUS_POT.get(),
                ModBlocks.SLIM_PINK_CACTUS_POT.get(),
                ModBlocks.MINI_WOODEN_POT.get(),
                ModBlocks.BIG_LEAVE_POT.get(),
                ModBlocks.SMALL_LEAVE_POT.get(),
                ModBlocks.LARGE_LEAVE_POT_1.get(),
                ModBlocks.LARGE_WOODEN_POT.get());

        MenuRegistry.registerScreenFactory(ModMenus.WOODEN_BOX.get(), WoodenBoxScreen::new);
    }
}
