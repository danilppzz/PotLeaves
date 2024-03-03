package dev.tonimatas.util.forge;

import dev.tonimatas.menu.ExtraDataMenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkHooks;

@SuppressWarnings("unused")
public class HooksImpl {
    public static void openMenu(ServerPlayer player, ExtraDataMenuProvider provider) {
        NetworkHooks.openScreen(player, provider, (data) -> provider.writeExtraData(player, data));
    }
}
