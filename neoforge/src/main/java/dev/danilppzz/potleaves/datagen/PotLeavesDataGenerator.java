package dev.danilppzz.potleaves.datagen;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.datagen.provider.server.ModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = PotLeaves.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PotLeavesDataGenerator {
    
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
    }
}
