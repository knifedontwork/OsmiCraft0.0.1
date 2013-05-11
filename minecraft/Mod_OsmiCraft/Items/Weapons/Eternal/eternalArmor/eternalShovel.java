package Mod_OsmiCraft.Items.Weapons.Eternal;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSpade;

public class eternalShovel extends ItemSpade{
	public eternalShovel(int itemID, EnumToolMaterial toolMaterial)
	 {
	  super(itemID, toolMaterial);
	  this.setCreativeTab(CreativeTabs.tabMaterials);
	 }
	
	public String getTextureFile()
   {
           return "/OsmiCraftItems.png";
   }

	}



