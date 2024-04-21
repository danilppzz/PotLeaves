package dev.danilppzz.potleaves.register;

import dev.architectury.registry.CreativeTabRegistry;
import dev.danilppzz.potleaves.PotLeaves;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final CreativeModeTab POT_LEAVES = CreativeTabRegistry.create(
            new ResourceLocation(PotLeaves.MOD_ID, "potleaves"), () ->
                    new ItemStack(ModBlocks.SMALL_LEAVE_POT.get()));
}
