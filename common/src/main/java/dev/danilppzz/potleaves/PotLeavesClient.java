package dev.danilppzz.potleaves;

import dev.danilppzz.potleaves.register.ModBlocks;
import dev.tonimatas.client.ClientHooks;
import net.minecraft.client.renderer.RenderType;

public class PotLeavesClient {
    public static void init() {
        // Slim Wooden Pot
        ClientHooks.setRenderLayer(ModBlocks.SLIM_CACTUS_POT.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.SLIM_PINK_CACTUS_POT.get(), RenderType.cutout());

        // Wooden Pot
        ClientHooks.setRenderLayer(ModBlocks.MINI_WOODEN_POT.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.BIG_LEAVE_POT.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.SMALL_LEAVE_POT.get(), RenderType.cutout());

        // Large Pot
        ClientHooks.setRenderLayer(ModBlocks.LARGE_LEAVE_POT_1.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.LARGE_WOODEN_POT.get(), RenderType.cutout());
    }
}
