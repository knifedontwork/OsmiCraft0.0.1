package Mod_OsmiCraft.Entitys.ImpactCrusher;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

 @SideOnly(Side.CLIENT)
public class GuiImpactCrusher extends GuiContainer{
	 private ImpactCrusherEntity furnaceInventory;
       public GuiImpactCrusher(InventoryPlayer player_inventory, ImpactCrusherEntity tile_entity){
               super(new ImpactCrusherContainer(player_inventory, tile_entity));
               this.furnaceInventory = tile_entity;
       }
      
      
       @Override
       protected void drawGuiContainerForegroundLayer(int i, int j){
       
               fontRenderer.drawString("Impact Crusher", 6, 6, 0xffffff);
               fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0xffffff);
       }
      
      
       @Override
       protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
      
       	int var4 = this.mc.renderEngine.getTexture("/gui/Pictures/CrusherGui.png");
           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
           this.mc.renderEngine.bindTexture(var4);
           int var5 = (this.width - this.xSize) / 2;
           int var6 = (this.height - this.ySize) / 2;
           this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
           int var7;

           if (this.furnaceInventory.isBurning())
           {
               var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
               this.drawTexturedModalRect(var5 + 10, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
           }

           var7 = this.furnaceInventory.getCookProgressScaled(16);
           this.drawTexturedModalRect(var5 + 79, var6 + 35, 176, 32, var7 + 1, 32);
       }
   }
