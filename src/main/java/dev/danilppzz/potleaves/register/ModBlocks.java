package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.custom.CustomWoodenBox;
import dev.danilppzz.potleaves.custom.CustomWoodenPot;
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
    public static final RegistryObject<Block> WOODEN_POT = registerBlock("wooden_pot",
            () -> new Block(CustomWoodenPot.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<Block> SMALL_LEAVE_POT = registerBlock("small_leave_pot",
            () -> new Block(CustomWoodenPot.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<Block> BIG_LEAVE_POT = registerBlock("big_leave_pot",
            () -> new Block(CustomWoodenPot.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<Block> WOODEN_BOX = registerBlock("wooden_box",
            () -> new Block(CustomWoodenBox.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.BAMBOO_WOOD)));

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
