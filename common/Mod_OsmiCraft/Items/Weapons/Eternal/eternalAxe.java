package Mod_OsmiCraft.Items.Weapons.Eternal;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;

public class eternalAxe extends ItemAxe{
	public eternalAxe(int itemID, EnumToolMaterial toolMaterial)
	 {
	  super(itemID, toolMaterial);
	  this.setCreativeTab(CreativeTabs.tabMaterials);
	 }
	
	public String getTextureFile()
   {
           return "/OsmiCraftItems.png";
   }

	}
