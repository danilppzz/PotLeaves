package dev.danilppzz.potleaves;

import com.mojang.logging.LogUtils;
import dev.danilppzz.potleaves.register.*;
import org.slf4j.Logger;

public class PotLeaves {
    public static final String MOD_ID = "potleaves";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ModTabs.TABS.register();
        ModBlocks.BLOCKS.register();
        ModItems.ITEMS.register();
        ModBlockEntity.BLOCK_ENTITIES.register();
        ModMenus.MENUS.register();
    }
}
