package Mod_OsmiCraft.Items.Weapons.Eternal;

import cpw.mods.fml.common.network.Player;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PlayerCapabilities;
import net.minecraftforge.common.IArmorTextureProvider;
import Mod_OsmiCraft.core;

public class eternalLegs extends ItemArmor implements IArmorTextureProvider, Player{
	private float walkSpeed = 1.5F;

	public eternalLegs(int par1, EnumArmorMaterial eternalArmor,int par3, int par4) {
		super(par1, eternalArmor, par3, par4);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	} 
	public String getTextureFile(){
        return "/OsmiCraftItems.png"; 
          
}
	
	

public String getArmorTextureFile(ItemStack par1){
        if ( par1.itemID==core.eternalLeggs.shiftedIndex){
                return "/armor/EternalArmor2.png";
        }return "/armor/EternalArmor2.png";
}


}
