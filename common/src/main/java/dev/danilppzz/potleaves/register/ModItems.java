package dev.danilppzz.potleaves.register;

import dev.danilppzz.potleaves.PotLeaves;
import dev.tonimatas.registry.PotRegistries;
import dev.tonimatas.registry.PotRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final PotRegistry<Item> ITEMS = PotRegistries.create(BuiltInRegistries.ITEM, PotLeaves.MOD_ID);
}
