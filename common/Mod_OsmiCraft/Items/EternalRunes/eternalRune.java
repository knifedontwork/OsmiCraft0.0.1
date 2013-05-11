package Mod_OsmiCraft.Items.EternalRunes;


import java.awt.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class eternalRune extends Item{

	public eternalRune(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
    {
            return "/OsmiCraftItems.png";
    }
	
}
