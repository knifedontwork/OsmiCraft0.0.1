package Mod_OsmiCraft.Blocks.Sulfur;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class SulfurIngotItem extends Item{
	public SulfurIngotItem(int par1)
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
