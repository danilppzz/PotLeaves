package dev.danilppzz.potleaves.neoforge.datagen.provider.client;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PotLeaves.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModBlocks.BLOCKS.forEach(registrySupplier -> {
            String id = registrySupplier.getId().getPath();
            basic(id);
        });
    }
    
    private void basic(String id) {
        withExistingParent(id, modLoc("block/" + id));
    }
}
