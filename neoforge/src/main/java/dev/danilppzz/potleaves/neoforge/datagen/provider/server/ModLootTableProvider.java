package dev.danilppzz.potleaves.neoforge.datagen.provider.server;

import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(arg, Set.of(), List.of(new SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)), completableFuture);
    }
    
    public static class BlockLootTables extends BlockLootSubProvider {
        public BlockLootTables(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void generate() {
            ModBlocks.BLOCKS.forEach(registrySupplier -> this.dropSelf(registrySupplier.get()));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            List<Block> blocks = new ArrayList<>();
            ModBlocks.BLOCKS.forEach(registrySupplier -> blocks.add(registrySupplier.get()));
            return blocks;
        }
    }
}
