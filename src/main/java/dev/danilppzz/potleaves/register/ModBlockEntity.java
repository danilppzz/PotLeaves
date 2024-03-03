package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.custom.CustomWoodenBox;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PotLeaves.MODID);



    public static final RegistryEntry<BlockEntityType<CustomWoodenBox>> WOODEN_BOX = BLOCK_ENTITIES.register("wooden_box",
            () -> RegistryHelpers.createBlockEntityType(CustomWoodenBox::new, ModBlocks.WOODEN_BOX.get()));
}
