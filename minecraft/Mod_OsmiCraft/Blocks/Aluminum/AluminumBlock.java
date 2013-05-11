package Mod_OsmiCraft.Blocks.Aluminum;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class AluminumBlock extends net.minecraft.block.Block{
	public AluminumBlock(int par1, int par2) {
		super(par1, par2, net.minecraft.block.material.Material.rock);
		this.setCreativeTab(net.minecraft.creativetab.CreativeTabs.tabBlock);
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



