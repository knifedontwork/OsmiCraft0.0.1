package Mod_OsmiCraft.Blocks.Rune;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class RuneItem extends Item{
	public RuneItem(int par1)
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


