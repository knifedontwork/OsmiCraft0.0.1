package Mod_OsmiCraft.Items.Weapons.Amethyst;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemPickaxe;

public class amethystPick extends ItemPickaxe{

	public amethystPick(int par1, EnumToolMaterial  toolMaterial) {
		super(par1, toolMaterial);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }


}
