package dev.danilppzz.potleaves.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.danilppzz.potleaves.PotLeaves;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class BaseScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {
    protected ResourceLocation TEXTURE;
    protected int textureWidth;
    protected int textureHeight;
    protected int widthExtra;
    protected int heightExtra;
    
    public BaseScreen(T abstractContainerMenu, Inventory inventory, Component component, int width, int height, int widthExtra, int heightExtra, String textureName) {
        super(abstractContainerMenu, inventory, component);
        this.TEXTURE = ResourceLocation.fromNamespaceAndPath(PotLeaves.MOD_ID, "textures/gui/" + textureName + ".png");
        this.textureWidth = width;
        this.textureHeight = height;
        this.widthExtra = widthExtra;
        this.heightExtra = heightExtra;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - textureWidth) / 2 + widthExtra;
        int y = (height - textureHeight) / 2 + heightExtra;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, textureWidth, textureHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);
        renderTooltip(guiGraphics, i, j);
    }
}
