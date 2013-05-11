package Mod_OsmiCraft.Entitys.Compressor;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCompressor extends GuiContainer{
	 private CompressorEntity furnaceInventory;
      public GuiCompressor(InventoryPlayer player_inventory, CompressorEntity tile_entity){
              super(new CompressorContainer(player_inventory, tile_entity));
              this.furnaceInventory = tile_entity;
      }
     
     
      @Override
      protected void drawGuiContainerForegroundLayer(int i, int j){
      
              fontRenderer.drawString("Compressor", 6, 6, 0xffffff);
              fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0xffffff);
      }
     
     
      @Override
      protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
     
      	int var4 = this.mc.renderEngine.getTexture("/gui/Pictures/CompressorGui.png");
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

          var7 = this.furnaceInventory.getCookProgressScaled(30);
          this.drawTexturedModalRect(var5 + 76, var6 + 34, 176, 14, var7 + 1, 16);
      }
  }
