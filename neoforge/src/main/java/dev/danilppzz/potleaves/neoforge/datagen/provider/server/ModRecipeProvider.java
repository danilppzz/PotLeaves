package dev.danilppzz.potleaves.neoforge.datagen.provider.server;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.register.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.Mod;
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
        
        shaped(ModBlocks.LARGE_WOODEN_POT, 2, Blocks.SPRUCE_PLANKS, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .define('B', Items.STICK)
                .pattern("BAB")
                .pattern("###"));
        
        shaped(ModBlocks.SLIM_WOODEN_POT, 2, Blocks.SPRUCE_SLAB, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .pattern("#A#")
                .pattern(" # "));
        
        shaped(ModBlocks.WOODEN_BOX, 1, Blocks.SPRUCE_SLAB, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Items.STICK)
                .pattern("A A")
                .pattern("A A")
                .pattern("###"));
        
        shaped(ModBlocks.WOODEN_POT, 2, Blocks.SPRUCE_PLANKS, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .pattern("#A#")
                .pattern(" # "));

        shaped(ModBlocks.MARMOL_POT, 2, Blocks.QUARTZ_BLOCK, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('A', Blocks.DIRT)
                .pattern("#A#")
                .pattern(" # "));

        shaped(ModBlocks.DESERT_POT, 2, Items.BRICK, shapedRecipeBuilder -> shapedRecipeBuilder
                .define('B', Blocks.DIRT)
                .define('C', Items.GOLD_INGOT)
                .pattern("#B#")
                .pattern(" C "));

        // STONECUTTER
        stonecutter(ModBlocks.LARGE_LEAVE_WOODEN_POT, ModBlocks.LARGE_WOODEN_POT);

        stonecutter(ModBlocks.CACTUS_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.PINK_CACTUS_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.SMALL_LEAVE_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.BIG_LEAVE_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.MINI_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.ALOE_VERA_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.MUSA_WOODEN_POT, ModBlocks.WOODEN_POT);
        stonecutter(ModBlocks.BINDWEED_WOODEN_POT, ModBlocks.WOODEN_POT);

        stonecutter(ModBlocks.CACTUS_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.PINK_CACTUS_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.SMALL_LEAVE_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.BIG_LEAVE_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.MINI_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.ALOE_VERA_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.MUSA_MARMOL_POT, ModBlocks.MARMOL_POT);
        stonecutter(ModBlocks.BINDWEED_MARMOL_POT, ModBlocks.MARMOL_POT);

        stonecutter(ModBlocks.CACTUS_DESERT_POT, ModBlocks.DESERT_POT);
    }
    
    private void shaped(RegistrySupplier<? extends ItemLike> result, int count, ItemLike main, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                        .define('#', main)
                        .unlockedBy("has_" + result.getId().getPath(), has(main)))
                .save(output);
    }

    private void stonecutter(RegistrySupplier<? extends ItemLike> result, RegistrySupplier<? extends ItemLike> input) {
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(input.get()),  // Input desde ModBlocks
                        RecipeCategory.MISC,         // Categoría
                        result.get()                 // Resultado
                )
                .unlockedBy("has_" + input.get().asItem().getDescriptionId(), has(input.get()))
                .save(output, "stonecutting_" + result.get().asItem().getDescriptionId());
    }
}
