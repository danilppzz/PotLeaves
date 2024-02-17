package dev.danilppzz.potleaves;

import com.mojang.logging.LogUtils;
import dev.danilppzz.potleaves.register.ModBlocks;
import dev.danilppzz.potleaves.register.ModItems;
import dev.danilppzz.potleaves.register.ModTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PotLeaves.MODID)
public class PotLeaves {
    public static final String MODID = "potleaves";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PotLeaves() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModTabs.TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
