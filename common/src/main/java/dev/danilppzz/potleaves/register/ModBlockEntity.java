package dev.danilppzz.potleaves.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.danilppzz.potleaves.PotLeaves;
import dev.danilppzz.potleaves.blockentity.WoodenBoxBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(PotLeaves.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<BlockEntityType<WoodenBoxBlockEntity>> WOODEN_BOX = BLOCK_ENTITIES.register("wooden_box", () -> BlockEntityType.Builder.of(
            WoodenBoxBlockEntity::new, ModBlocks.WOODEN_BOX.get()).build(null));
}
