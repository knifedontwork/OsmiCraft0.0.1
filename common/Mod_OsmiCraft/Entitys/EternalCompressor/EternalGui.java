package Mod_OsmiCraft.Entitys.EternalCompressor;

import org.lwjgl.opengl.GL11;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;
import Mod_OsmiCraft.gui.Pictures.*;
 
@SideOnly(Side.CLIENT)
public class EternalGui extends GuiContainer{
	 private EternalCompressorEntity furnaceInventory;
        public EternalGui(InventoryPlayer player_inventory, EternalCompressorEntity tile_entity){
                super(new EternalCompressorContainer(player_inventory, tile_entity));
                this.furnaceInventory = tile_entity;
        }
       
       
        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j){
        
                fontRenderer.drawString("Eternal Compressor Gui", 6, 6, 0xffffff);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0xffffff);
        }
       
       
        @Override
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
       
        	int var4 = this.mc.renderEngine.getTexture("/gui/Pictures/EternalCompressorGui.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(var4);
            int var5 = (this.width - this.xSize) / 2;
            int var6 = (this.height - this.ySize) / 2;
            this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
            int var7;
            if (this.furnaceInventory.isBurning())
            {
                var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
                this.drawTexturedModalRect(var5 + 31, var6 + 52 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
            }
           

            var7 = this.furnaceInventory.getCookProgressScaled(23);
            this.drawTexturedModalRect(var5 + 79, var6 + 49, 176, 14, var7 + 1, 16);
        }
    }
