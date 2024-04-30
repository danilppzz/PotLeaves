package dev.danilppzz.potleaves.neoforge.datagen.provider.server;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
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
        
        shaped(ModBlocks.BIG_LEAVE_POT, 1, ModBlocks.WOODEN_POT.get(), shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.SHORT_GRASS)
                .pattern("AAA")
                .pattern("#  "));
        
        shaped(ModBlocks.MINI_WOODEN_POT, 1, ModBlocks.WOODEN_POT.get(), shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.OAK_SAPLING)
                .pattern("A")
                .pattern("#"));
        
        shaped(ModBlocks.SLIM_CACTUS_POT, 1, ModBlocks.SLIM_WOODEN_POT.get(), shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.CACTUS)
                .pattern("#A"));
        
        shaped(ModBlocks.LARGE_WOODEN_POT, 1, Blocks.SPRUCE_PLANKS, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .define('B', Items.STICK)
                .pattern("BAB")
                .pattern("###"));
        
        shaped(ModBlocks.SLIM_PINK_CACTUS_POT, 1, ModBlocks.WOODEN_POT.get(), shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.CACTUS)
                .define('B', Items.MAGENTA_DYE)
                .pattern(" B")
                .pattern("#A"));
        
        shaped(ModBlocks.SLIM_WOODEN_POT, 1, Blocks.SPRUCE_SLAB, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .pattern("#A#")
                .pattern(" # "));
        
        shaped(ModBlocks.WOODEN_BOX, 1, Blocks.SPRUCE_SLAB, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Items.STICK)
                .pattern("A A")
                .pattern("A A")
                .pattern("###"));
        
        shaped(ModBlocks.SMALL_LEAVE_POT, 1, ModBlocks.WOODEN_POT.get(), shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.SHORT_GRASS)
                .pattern("A")
                .pattern("#"));
        
        shaped(ModBlocks.LARGE_LEAVE_POT_1, 1, ModBlocks.LARGE_WOODEN_POT.get(), shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.SHORT_GRASS)
                .define('B', Items.ALLIUM)
                .pattern("AAB")
                .pattern(" # "));
        
        shaped(ModBlocks.WOODEN_POT, 1, Blocks.SPRUCE_PLANKS, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .pattern("#A#")
                .pattern(" # "));
    }
    
    private void shaped(RegistrySupplier<? extends ItemLike> result, int count, ItemLike main, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                        .define('#', main)
                        .unlockedBy("has_" + result.getId().getPath(), has(main)))
                .save(output);
    }
}
