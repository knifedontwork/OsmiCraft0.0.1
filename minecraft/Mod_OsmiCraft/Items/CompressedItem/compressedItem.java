package Mod_OsmiCraft.Items.CompressedItem;



public class compressedItem extends net.minecraft.item.Item{
	public compressedItem(int par1)
    {
        super(par1);
        maxStackSize = 64;
        this.setCreativeTab(net.minecraft.creativetab.CreativeTabs.tabMaterials);
    }
	
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }


}

