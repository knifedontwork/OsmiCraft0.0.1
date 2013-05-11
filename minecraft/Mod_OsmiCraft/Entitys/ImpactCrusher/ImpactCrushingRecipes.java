package Mod_OsmiCraft.Entitys.ImpactCrusher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.ItemStack;
import Mod_OsmiCraft.core;
import Mod_OsmiCraft.Entitys.RockCrusher.CrushingRecipes;

public class ImpactCrushingRecipes {
	private static final  ImpactCrushingRecipes smeltingBase = new ImpactCrushingRecipes();

	/** The list of smelting results. */
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private Map metaSmeltingList = new HashMap();


	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final ImpactCrushingRecipes crushing()
	{
	    return smeltingBase;
	}



	private ImpactCrushingRecipes()
	{

		this.addSmelting(core.osmiumOre.blockID,  new ItemStack(core.Osmium,2), 1.0F);
		this.addSmelting(core.aluminumOre.blockID, new ItemStack(core.Aluminum,2), 1.0F);
		this.addSmelting(core.amethystOre.blockID, new ItemStack(core.Amethyst,2), 1.0F);
		this.addSmelting(core.runiteOre.blockID,  new ItemStack(core.Rune,2), 1.0F);
		this.addSmelting(core.sulfurOre.blockID, new ItemStack(core.Sulfur,2), 1.0F);
		this.addSmelting(core.zincOre.blockID,  new ItemStack(core.Zinc,2), 1.0F);
		this.addSmelting(core.compressedOsmium.shiftedIndex,  new ItemStack(core.osmiumIngot,1), 1.0F);
		this.addSmelting(core.compressedAluminum.shiftedIndex,  new ItemStack(core.aluminumIngot,1), 1.0F);
		this.addSmelting(core.compressedAmethyst.shiftedIndex,  new ItemStack(core.amethystIngot,1), 1.0F);
		this.addSmelting(core.compressedRune.shiftedIndex,  new ItemStack(core.runeIngot,1), 1.0F);
		this.addSmelting(core.compressedSulfur.shiftedIndex,  new ItemStack(core.sulfurIngot,1), 1.0F);
		this.addSmelting(core.compressedZinc.shiftedIndex,  new ItemStack(core.zincIngot,1), 1.0F);
		


	}

	public ItemStack getCrushingResult(ItemStack item) 
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
	 */
	public void addSmelting(int itemID, int metadata, ItemStack itemstack)
	{
	    metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
	}


	/**
	 * Used to get the resulting ItemStack form a source ItemStack
	 * @param item The Source ItemStack
	 * @return The result ItemStack
	 */

	}


