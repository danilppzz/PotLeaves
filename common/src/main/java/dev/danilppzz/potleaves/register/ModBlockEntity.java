package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.blockentity.WoodenBoxBlockEntity;
import dev.tonimatas.registry.PotRegistries;
import dev.tonimatas.registry.PotRegistry;
import dev.tonimatas.registry.RegistryEntry;
import dev.tonimatas.registry.RegistryHelpers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntity {
    public static final PotRegistry<BlockEntityType<?>> BLOCK_ENTITIES = PotRegistries.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PotLeaves.MOD_ID);

    public static final RegistryEntry<BlockEntityType<WoodenBoxBlockEntity>> WOODEN_BOX = BLOCK_ENTITIES.register("wooden_box",
            () -> RegistryHelpers.createBlockEntityType(WoodenBoxBlockEntity::new, ModBlocks.WOODEN_BOX.get()));
}
