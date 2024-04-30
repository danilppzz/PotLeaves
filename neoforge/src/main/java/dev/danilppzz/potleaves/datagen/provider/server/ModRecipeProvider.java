package dev.danilppzz.potleaves.datagen.provider.server;

import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(arg, completableFuture);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput arg) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BIG_LEAVE_POT.get(), 1)
                .pattern("BBB")
                .pattern("A")
                .define('A', ModBlocks.WOODEN_POT.get())
                .define('B', Blocks.SHORT_GRASS)
                .save(arg);
    }
}
