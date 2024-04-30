package dev.danilppzz.potleaves.neoforge.datagen.provider.server;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ModRecipeProvider extends RecipeProvider {
    private RecipeOutput output;
    
    public ModRecipeProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(arg, completableFuture);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput arg) {
        this.output = arg;
        
        shaped(ModBlocks.BIG_LEAVE_POT, 1, ModBlocks.WOODEN_POT, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.SHORT_GRASS)
                .pattern("AAA")
                .pattern("#  "));
    }
    
    private void shaped(RegistrySupplier<? extends ItemLike> result, int count, RegistrySupplier<? extends ItemLike> main, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                        .define('#', main.get())
                        .unlockedBy("has_" + result.getId().getPath(), has(main.get())))
                .save(output);
    }
}
