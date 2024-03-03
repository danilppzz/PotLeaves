package dev.tonimatas.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.tonimatas.menu.ExtraDataMenuProvider;
import net.minecraft.server.level.ServerPlayer;
import org.apache.commons.lang3.NotImplementedException;

@SuppressWarnings("unused")
public class Hooks {
    @ExpectPlatform
    public static void openMenu(ServerPlayer player, ExtraDataMenuProvider provider) {
        throw new NotImplementedException();
    }
}
