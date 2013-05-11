package Mod_OsmiCraft.Items.WeaponsOsmium;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;

public class osmiumAxe extends ItemAxe{

	public osmiumAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }

}
