package dev.danilppzz.potleaves.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.blocks.*;
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
            () -> new WoodenSlimPot(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    public static final RegistrySupplier<WoodenBox> WOODEN_BOX = registerBlock("wooden_box",
            () -> new WoodenBox(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    // Large Pot
    public static final RegistrySupplier<LargeWoodenPot> LARGE_WOODEN_POT = registerBlock("large_wooden_pot",
            () -> new LargeWoodenPot(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistrySupplier<LargeWoodenPot> LARGE_LEAVE_WOODEN_POT = registerBlock("large_leave_wooden_pot",
            () -> new LargeWoodenPot(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.BAMBOO_WOOD)));

    // Wooden Pots
    public static final RegistrySupplier<Pot> WOODEN_POT = registerSinglePot("wooden_pot", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> CACTUS_WOODEN_POT = registerPot("cactus", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> PINK_CACTUS_WOODEN_POT = registerPot("pink_cactus", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> SMALL_LEAVE_WOODEN_POT = registerPot("small_leave", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> BIG_LEAVE_WOODEN_POT = registerPot("big_leave", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> MINI_WOODEN_POT = registerPot("mini_leave", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> ALOE_VERA_WOODEN_POT = registerPot("aloe_vera", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> MUSA_WOODEN_POT = registerPot("musa", Pot.Type.WOODEN);
    public static final RegistrySupplier<Pot> BINDWEED_WOODEN_POT = registerPot("bindweed", Pot.Type.WOODEN);


    // Marmol Pots
    public static final RegistrySupplier<Pot> MARMOL_POT = registerSinglePot("marmol_pot", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> CACTUS_MARMOL_POT = registerPot("cactus", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> PINK_CACTUS_MARMOL_POT = registerPot("pink_cactus", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> SMALL_LEAVE_MARMOL_POT = registerPot("small_leave", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> BIG_LEAVE_MARMOL_POT = registerPot("big_leave", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> MINI_MARMOL_POT = registerPot("mini_leave", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> ALOE_VERA_MARMOL_POT = registerPot("aloe_vera", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> MUSA_MARMOL_POT = registerPot("musa", Pot.Type.MARMOL);
    public static final RegistrySupplier<Pot> BINDWEED_MARMOL_POT = registerPot("bindweed", Pot.Type.MARMOL);


    // Desert Pots
    public static final RegistrySupplier<DesertPot> DESERT_POT = registerDesertPot("pot", DesertPot.Type.DESERT);
    public static final RegistrySupplier<DesertPot> CACTUS_DESERT_POT = registerDesertPot("cactus", DesertPot.Type.DESERT);


    private static RegistrySupplier<Pot> registerSinglePot(String name, Pot.Type type) {
        return registerBlock(name, () -> new Pot(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(type.soundType)));
    }
    
    private static RegistrySupplier<Pot> registerPot(String name, Pot.Type type) {
        return registerBlock(name + "_" + type.extension, () -> new Pot(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(type.soundType)));
    }

    private static RegistrySupplier<DesertPot> registerDesertPot(String name, DesertPot.Type type) {
        return registerBlock(name + "_" + type.extension, () -> new DesertPot(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(type.soundType)));
    }
    
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
