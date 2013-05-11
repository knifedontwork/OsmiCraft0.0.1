package Mod_OsmiCraft.Blocks.Zinc;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class zincIngot extends Item{
	public zincIngot(int par1)
    {
        super(par1);
        maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
	
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }


}


