package Mod_OsmiCraft.Items.CompressedItem;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class compressedItem extends Item{
	public compressedItem(int par1)
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

