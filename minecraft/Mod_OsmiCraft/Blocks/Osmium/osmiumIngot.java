package Mod_OsmiCraft.Blocks.Osmium;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class osmiumIngot extends Item{
	public osmiumIngot(int par1)
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
