package Mod_OsmiCraft.Blocks.Rune;

import java.util.Random;

import Mod_OsmiCraft.core;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class RuniteOre extends Block{
	public RuniteOre(int par1, int par2) {
		super(par1, par2, Material.rock);
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


