package Mod_OsmiCraft.Entitys.BlastFurnace;

import org.lwjgl.opengl.GL11;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;
import Mod_OsmiCraft.gui.Pictures.*;
 
@SideOnly(Side.CLIENT)
public class GuiBlastFurnace extends GuiContainer{
	 private BlastFurnaceEntity furnaceInventory;
        public GuiBlastFurnace(InventoryPlayer player_inventory, BlastFurnaceEntity tile_entity){
                super(new ContainerBlastFurnace(player_inventory, tile_entity));
                this.furnaceInventory = tile_entity;
        }
       
       
        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j){
        
                fontRenderer.drawString("Blast Furnace Gui", 6, 6, 0xffffff);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0xffffff);
        }
       
       
        @Override
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
       
        	int var4 = this.mc.renderEngine.getTexture("/gui/Pictures/BlastFurnaceGui.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(var4);
            int var5 = (this.width - this.xSize) / 2;
            int var6 = (this.height - this.ySize) / 2;
            this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
            int var7;

            if (this.furnaceInventory.isBurning())
            {
                var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
                this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
            }

            var7 = this.furnaceInventory.getCookProgressScaled(24);
            this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
        }
    }
