package dev.danilppzz.potleaves.neoforge.datagen.provider.client;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PotLeaves.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        horizontalBlock(ModBlocks.ALOE_VERA_POT);
        horizontalBlock(ModBlocks.BIG_LEAVE_POT);
        horizontalBlock(ModBlocks.LARGE_LEAVE_POT_1);
        horizontalBlock(ModBlocks.LARGE_WOODEN_POT);
        horizontalBlock(ModBlocks.MINI_WOODEN_POT);
        horizontalBlock(ModBlocks.SLIM_CACTUS_POT);
        horizontalBlock(ModBlocks.SLIM_PINK_CACTUS_POT);
        horizontalBlock(ModBlocks.SLIM_WOODEN_POT);
        horizontalBlock(ModBlocks.SMALL_LEAVE_POT);
        horizontalBlock(ModBlocks.WOODEN_BOX);
        horizontalBlock(ModBlocks.WOODEN_POT);
    }
    
    private void horizontalBlock(RegistrySupplier<? extends Block> block) {
        horizontalBlock(block.get(), models().getExistingFile(modLoc("block/" + block.getId().getPath())));
    }
}
