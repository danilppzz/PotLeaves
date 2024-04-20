package dev.danilppzz.potleaves;

import dev.danilppzz.potleaves.client.PotLeavesClient;
import net.fabricmc.api.ClientModInitializer;

public class PotLeavesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PotLeavesClient.init();
    }
}
