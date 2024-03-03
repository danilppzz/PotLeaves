package dev.danilppzz.potleaves;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = PotLeaves.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotLeavesClientForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        PotLeavesClient.init();
    }
}
