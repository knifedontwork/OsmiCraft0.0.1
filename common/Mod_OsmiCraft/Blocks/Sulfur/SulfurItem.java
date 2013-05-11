package Mod_OsmiCraft.Blocks.Sulfur;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class SulfurItem extends Item{
	public SulfurItem(int par1)
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
