package Mod_OsmiCraft.Entitys.Compressor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.ItemStack;
import Mod_OsmiCraft.core;


public class CompressRecipes {
	private static final  CompressRecipes smeltingBase = new CompressRecipes();

	/** The list of smelting results. */
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private Map metaSmeltingList = new HashMap();


	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final CompressRecipes compressing()
	{
	    return smeltingBase;
	}



	private CompressRecipes()
	{

		this.addSmelting(core.Osmium.shiftedIndex,  new ItemStack(core.compressedOsmium), 1.0F);
		this.addSmelting(core.Aluminum.shiftedIndex, new ItemStack(core.compressedAluminum), 1.0F);
		this.addSmelting(core.Amethyst.shiftedIndex, new ItemStack(core.compressedAmethyst), 1.0F);
		this.addSmelting(core.eternalFragment.shiftedIndex,  new ItemStack(core.compressedFragment), 1.0F);
		this.addSmelting(core.Rune.shiftedIndex, new ItemStack(core.compressedRune), 1.0F);
		this.addSmelting(core.Sulfur.shiftedIndex, new ItemStack(core.compressedSulfur), 1.0F);
		this.addSmelting(core.Zinc.shiftedIndex, new ItemStack(core.compressedZinc), 1.0F);
		

	}

	public ItemStack getCompressingResult(ItemStack item) 
	{
	    if (item == null )
	    {
	        return null;
	    }
	    ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
	   

	    if (ret != null ) 
	    {
	        return ret;
	       
	    }
	    return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
	}




	public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
	{
	    this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
	    this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
	}

	/**
	 * Returns the smelting result of an item.
	 * Deprecated in favor of a metadata sensitive version
	 */

	public ItemStack getSmeltingResult(int par1)
	{
	    return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
	}

	public Map getSmeltingList()
	{
	    return this.smeltingList;
	}

	public float getExperience(int par1)
	{
	    return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	/**
	 * Add a metadata-sensitive furnace recipe
	 * @param itemID The Item ID
	 * @param metadata The Item Metadata
	 * @param itemstack The ItemStack for the result
	 * @param f 
	 */
	public void addSmelting(int itemID, int metadata, ItemStack itemstack, float f)
	{
	    metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
	}


	/**
	 * Used to get the resulting ItemStack form a source ItemStack
	 * @param item The Source ItemStack
	 * @return The result ItemStack
	 */

	}





