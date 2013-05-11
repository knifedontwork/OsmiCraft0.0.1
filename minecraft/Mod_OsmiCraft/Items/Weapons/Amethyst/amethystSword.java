package Mod_OsmiCraft.Items.Weapons.Amethyst;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class amethystSword extends ItemSword{
	public amethystSword(int itemID, EnumToolMaterial toolMaterial)
	 {
	  super(itemID, toolMaterial);
	  this.setCreativeTab(CreativeTabs.tabMaterials);
	 }
	
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }

	}

