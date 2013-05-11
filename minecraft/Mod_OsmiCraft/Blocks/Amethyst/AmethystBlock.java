package Mod_OsmiCraft.Blocks.Amethyst;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class AmethystBlock extends Block{

	public AmethystBlock(int id, int par2) {
		super(id, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
	public int quantityDropped()
    {
        return(1);
    }
	 public String getTextureFile()
	    {
	            return "/BlockTest.png";
	    }


}	



