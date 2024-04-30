package dev.danilppzz.potleaves;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@SuppressWarnings("unused")
@Mod(PotLeaves.MOD_ID)
public class PotLeavesNeoForge {
    public PotLeavesNeoForge(IEventBus eventBus) {
        PotLeaves.init();
    }
}
