package dev.danilppzz.potleaves.neoforge.datagen.provider.client;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PotLeaves.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        horizontalBlock(ModBlocks.ALOE_VERA_WOODEN_POT);
        horizontalBlock(ModBlocks.BIG_LEAVE_WOODEN_POT);
        horizontalBlock(ModBlocks.LARGE_LEAVE_WOODEN_POT);
        horizontalBlock(ModBlocks.LARGE_WOODEN_POT);
        horizontalBlock(ModBlocks.MINI_WOODEN_POT);
        horizontalBlock(ModBlocks.CACTUS_WOODEN_POT);
        horizontalBlock(ModBlocks.PINK_CACTUS_WOODEN_POT);
        horizontalBlock(ModBlocks.SLIM_WOODEN_POT);
        horizontalBlock(ModBlocks.SMALL_LEAVE_WOODEN_POT);
        horizontalBlock(ModBlocks.ALOE_VERA_MARMOL_POT);
        horizontalBlock(ModBlocks.BIG_LEAVE_MARMOL_POT);
        horizontalBlock(ModBlocks.MINI_MARMOL_POT);
        horizontalBlock(ModBlocks.CACTUS_MARMOL_POT);
        horizontalBlock(ModBlocks.PINK_CACTUS_MARMOL_POT);
        horizontalBlock(ModBlocks.SMALL_LEAVE_MARMOL_POT);
        horizontalBlock(ModBlocks.WOODEN_BOX);
        horizontalBlock(ModBlocks.WOODEN_POT);
        horizontalBlock(ModBlocks.MARMOL_POT);
        horizontalBlock(ModBlocks.MUSA_WOODEN_POT);
        horizontalBlock(ModBlocks.MUSA_MARMOL_POT);
        horizontalBlock(ModBlocks.CACTUS_DESERT_POT);
        horizontalBlock(ModBlocks.DESERT_POT);
        horizontalBlock(ModBlocks.BINDWEED_WOODEN_POT);
        horizontalBlock(ModBlocks.BINDWEED_MARMOL_POT);
        
    }
    
    private void horizontalBlock(RegistrySupplier<? extends Block> block) {
        horizontalBlock(block.get(), models().getExistingFile(modLoc("block/" + block.getId().getPath())));
    }
}
