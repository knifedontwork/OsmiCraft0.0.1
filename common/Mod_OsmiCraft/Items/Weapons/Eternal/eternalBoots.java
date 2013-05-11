package Mod_OsmiCraft.Items.Weapons.Eternal;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import Mod_OsmiCraft.core;

public class eternalBoots extends ItemArmor implements IArmorTextureProvider{

	public eternalBoots(int par1, EnumArmorMaterial eternalArmor,int par3, int par4) {
		super(par1, eternalArmor, par3, par4);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	} 
	
	public String getTextureFile(){
        return "/OsmiCraftItems.png"; 
          
}
	

public String getArmorTextureFile(ItemStack par1){
        if ( par1.itemID==core.eternalBoots.shiftedIndex){
                return "/armor/EternalArmor1.png";
        }return "/armor/EternalArmor1.png";
}
 


}
