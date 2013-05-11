package Mod_OsmiCraft.Items.Weapons.Eternal;

import net.minecraft.src.CreativeTabs; 
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import Mod_OsmiCraft.core; 

public class eternalHelmet extends ItemArmor implements IArmorTextureProvider{

	public eternalHelmet(int par1, EnumArmorMaterial eternalArmor,int par3, int par4) {
		super(par1, eternalArmor, par3, par4);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	} 
	public String getTextureFile(){
        return "/OsmiCraftItems.png"; 
          
}

public String getArmorTextureFile(ItemStack par1){
        if ( par1.itemID==core.eternalHelmet.shiftedIndex){
                return "/armor/EternalArmor1.png";
        }return "/armor/EternalArmor1.png";
}      
}

	
		
	


