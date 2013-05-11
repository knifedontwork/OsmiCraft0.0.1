package Mod_OsmiCraft.Items.Weapons.Amethyst;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;

public class amethystAxe extends ItemAxe{

	public amethystAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }


}
