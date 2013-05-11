package Mod_OsmiCraft.Entitys.EternalCompressor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Mod_OsmiCraft.core;

import net.minecraft.src.Block;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class EternalRecipes {

	private static final EternalRecipes smeltingBase = new EternalRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map metaSmeltingList = new HashMap();
  
   
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final EternalRecipes smelting()
    {
        return smeltingBase;
    }
   
 
    private EternalRecipes()
    {
    
    	this.addSmelting(core.osmiumPick.shiftedIndex, core.runePick.shiftedIndex , core.amethystPick.shiftedIndex,  new ItemStack(core.eternalPick), 1.0F);
    	this.addSmelting(core.osmiumAxe.shiftedIndex, core.runeAxe.shiftedIndex , core.amethystAxe.shiftedIndex,  new ItemStack(core.eternalAxe), 1.0F);
    	this.addSmelting(core.osmiumSword.shiftedIndex, core.runeSword.shiftedIndex , core.amethystSword.shiftedIndex,  new ItemStack(core.eternalSword), 1.0F);
    	this.addSmelting(core.osmiumShovel.shiftedIndex, core.runeShovel.shiftedIndex , core.amethystShovel.shiftedIndex,  new ItemStack(core.eternalShovel), 1.0F);
    	
    	
    
    }
    public ItemStack getSmeltingResult(ItemStack item) 
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

    
    

    public void addSmelting(int par1, int par2, int par3, ItemStack par2ItemStack, float par4)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par4));
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
}
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
   