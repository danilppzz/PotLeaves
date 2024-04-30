package dev.danilppzz.potleaves.neoforge;

import dev.danilppzz.potleaves.PotLeaves;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@SuppressWarnings("unused")
@Mod(PotLeaves.MOD_ID)
public class PotLeavesNeoForge {
    public PotLeavesNeoForge(IEventBus eventBus) {
        PotLeaves.init();
    }
}
