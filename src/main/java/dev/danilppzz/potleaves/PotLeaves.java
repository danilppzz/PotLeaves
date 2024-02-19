package dev.danilppzz.potleaves;

import com.mojang.logging.LogUtils;
import dev.danilppzz.potleaves.register.ModBlocks;
import dev.danilppzz.potleaves.register.ModItems;
import dev.danilppzz.potleaves.register.ModTabs;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
        modEventBus.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SLIM_CACTUS_POT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SLIM_PINK_CACTUS_POT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIG_LEAVE_POT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMALL_LEAVE_POT.get(), RenderType.cutout());
    }
}
