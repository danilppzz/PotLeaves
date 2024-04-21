package dev.danilppzz.potleaves.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.blocks.LargeWoodenPot;
import dev.danilppzz.potleaves.blocks.WoodenBox;
import dev.danilppzz.potleaves.blocks.WoodenPot;
import dev.danilppzz.potleaves.blocks.WoodenSlimPot;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(PotLeaves.MOD_ID, Registries.BLOCK);

    // Here goes the mod blocks
    public static final RegistrySupplier<WoodenSlimPot> SLIM_WOODEN_POT = registerBlock("slim_wooden_pot",
            () -> new WoodenSlimPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    public static final RegistrySupplier<WoodenBox> WOODEN_BOX = registerBlock("wooden_box",
            () -> new WoodenBox(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    // Cactus
    public static final RegistrySupplier<WoodenPot> SLIM_CACTUS_POT = registerBlock("slim_cactus_pot",
            () -> new WoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistrySupplier<WoodenPot> SLIM_PINK_CACTUS_POT = registerBlock("slim_pink_cactus_pot",
            () -> new WoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    // Large Pot
    public static final RegistrySupplier<LargeWoodenPot> LARGE_WOODEN_POT = registerBlock("large_wooden_pot",
            () -> new LargeWoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistrySupplier<LargeWoodenPot> LARGE_LEAVE_POT_1 = registerBlock("large_leave_pot_1",
            () -> new LargeWoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    // Big, Small, Mini Pot's
    public static final RegistrySupplier<WoodenPot> WOODEN_POT = registerBlock("wooden_pot",
            () -> new WoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistrySupplier<WoodenPot> SMALL_LEAVE_POT = registerBlock("small_leave_pot",
            () -> new WoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistrySupplier<WoodenPot> BIG_LEAVE_POT = registerBlock("big_leave_pot",
            () -> new WoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistrySupplier<WoodenPot> MINI_WOODEN_POT = registerBlock("mini_leave_pot",
            () -> new WoodenPot(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    // Register this blocks as items to.
    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistrySupplier<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
