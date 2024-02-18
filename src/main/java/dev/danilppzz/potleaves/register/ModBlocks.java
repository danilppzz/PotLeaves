package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.custom.CustomWoodenBox;
import dev.danilppzz.potleaves.custom.CustomWoodenPot;
import dev.danilppzz.potleaves.custom.CustomWoodenSlimPot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PotLeaves.MODID);

    // Here goes the mod blocks
    public static final RegistryObject<CustomWoodenSlimPot> SLIM_WOODEN_POT = registerBlock("slim_wooden_pot",
            () -> new CustomWoodenSlimPot(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<CustomWoodenSlimPot> SLIM_CACTUS_POT = registerBlock("slim_cactus_pot",
            () -> new CustomWoodenSlimPot(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<CustomWoodenSlimPot> SLIM_PINK_CACTUS_POT = registerBlock("slim_pink_cactus_pot",
            () -> new CustomWoodenSlimPot(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));

    public static final RegistryObject<CustomWoodenPot> WOODEN_POT = registerBlock("wooden_pot",
            () -> new CustomWoodenPot(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<CustomWoodenPot> SMALL_LEAVE_POT = registerBlock("small_leave_pot",
            () -> new CustomWoodenPot(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<CustomWoodenPot> BIG_LEAVE_POT = registerBlock("big_leave_pot",
            () -> new CustomWoodenPot(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));

    public static final RegistryObject<CustomWoodenBox> WOODEN_BOX = registerBlock("wooden_box",
            () -> new CustomWoodenBox(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));

    // Register this blocks as items to.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
