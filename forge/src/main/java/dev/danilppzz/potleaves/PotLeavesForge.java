package dev.danilppzz.potleaves;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(PotLeaves.MOD_ID)
public class PotLeavesForge {
    public PotLeavesForge() {
        EventBuses.registerModEventBus(PotLeaves.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        PotLeaves.init();
    }
}
