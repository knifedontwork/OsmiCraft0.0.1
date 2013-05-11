package Mod_OsmiCraft.Items.Weapons.Rune;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class runeSword extends ItemSword{

	public runeSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }

}
