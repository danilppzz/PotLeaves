package dev.danilppzz.potleaves;

import com.mojang.logging.LogUtils;
import dev.danilppzz.potleaves.register.ModBlockEntity;
import dev.danilppzz.potleaves.register.ModBlocks;
import dev.danilppzz.potleaves.register.ModItems;
import dev.danilppzz.potleaves.register.ModTabs;
import dev.tonimatas.client.ClientHooks;
import net.minecraft.client.renderer.RenderType;
import org.slf4j.Logger;

public class PotLeaves {
    public static final String MOD_ID = "potleaves";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ModItems.ITEMS.init();
        ModBlocks.BLOCKS.init();
        ModTabs.TABS.init();
        ModBlockEntity.BLOCK_ENTITIES.init();
    }
}
