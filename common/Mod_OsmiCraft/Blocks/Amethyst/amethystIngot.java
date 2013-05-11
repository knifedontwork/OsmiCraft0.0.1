package Mod_OsmiCraft.Blocks.Amethyst;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class amethystIngot extends Item{
	public amethystIngot(int par1)
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