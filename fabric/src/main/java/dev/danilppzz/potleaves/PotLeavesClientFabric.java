package dev.danilppzz.potleaves;

import net.fabricmc.api.ClientModInitializer;

public class PotLeavesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PotLeavesClient.init();
    }
}
