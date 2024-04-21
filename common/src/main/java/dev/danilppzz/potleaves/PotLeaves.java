package dev.danilppzz.potleaves;

import dev.danilppzz.potleaves.register.ModBlockEntity;
import dev.danilppzz.potleaves.register.ModBlocks;
import dev.danilppzz.potleaves.register.ModItems;
import dev.danilppzz.potleaves.register.ModMenus;

public class PotLeaves {
    public static final String MOD_ID = "potleaves";

    public static void init() {
        ModBlocks.BLOCKS.register();
        ModItems.ITEMS.register();
        ModBlockEntity.BLOCK_ENTITIES.register();
        ModMenus.MENUS.register();
    }
}
