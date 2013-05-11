package Mod_OsmiCraft.Blocks.Aluminum;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class aluminumIngot extends Item{
	public aluminumIngot(int par1)
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
