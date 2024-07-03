package dev.danilppzz.potleaves.neoforge;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.client.PotLeavesClient;
import dev.danilppzz.potleaves.client.screens.WoodenBoxScreen;
import dev.danilppzz.potleaves.register.ModMenus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = PotLeaves.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class PotLeavesClientNeoForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        PotLeavesClient.init(false);
    }
    
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenus.WOODEN_BOX.get(), WoodenBoxScreen::new);
    }
}
