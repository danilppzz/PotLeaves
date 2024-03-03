package dev.tonimatas.util.fabric;

import dev.tonimatas.menu.ExtraDataMenuProvider;
import dev.tonimatas.menu.ExtraDataMenuProviderWrapper;
import net.minecraft.server.level.ServerPlayer;

@SuppressWarnings("unused")
public class HooksImpl {
    public static void openMenu(ServerPlayer player, ExtraDataMenuProvider provider) {
        player.openMenu(new ExtraDataMenuProviderWrapper(provider));
    }
}
