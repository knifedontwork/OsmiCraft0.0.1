package Mod_OsmiCraft.Entitys.BlastFurnace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Mod_OsmiCraft.core;

import net.minecraft.src.Block;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class BlastFurnaceRecipes {

	private static final BlastFurnaceRecipes smeltingBase = new BlastFurnaceRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map metaSmeltingList = new HashMap();
  
   
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final BlastFurnaceRecipes smelting()
    {
        return smeltingBase;
    }
   
 
    private BlastFurnaceRecipes()
    {
    
    	this.addSmelting(core.Osmium.shiftedIndex,  new ItemStack(core.osmiumIngot), 2.0F);
    	this.addSmelting(core.Aluminum.shiftedIndex, new ItemStack(core.aluminumIngot), 1.0F);
    	this.addSmelting(core.Amethyst.shiftedIndex, new ItemStack(core.amethystIngot), 1.0F);
    	this.addSmelting(core.Rune.shiftedIndex,  new ItemStack(core.runeIngot), 1.0F);
    	this.addSmelting(core.Sulfur.shiftedIndex, new ItemStack(core.sulfurIngot), 1.0F);
    	this.addSmelting(core.Zinc.shiftedIndex,  new ItemStack(core.zincIngot), 1.0F);
    	this.addSmelting(core.compressedOsmium.shiftedIndex,  new ItemStack(core.osmiumIngot ,1), 2.0F);
    	this.addSmelting(core.compressedAluminum.shiftedIndex, new ItemStack(core.aluminumIngot, 1), 1.0F);
    	this.addSmelting(core.compressedAmethyst.shiftedIndex, new ItemStack(core.amethystIngot, 1), 1.0F);
    	this.addSmelting(core.compressedZinc.shiftedIndex,  new ItemStack(core.zincIngot ,1), 2.0F);
    	this.addSmelting(core.compressedSulfur.shiftedIndex, new ItemStack(core.sulfurIngot, 1), 1.0F);
    	this.addSmelting(core.compressedRune.shiftedIndex, new ItemStack(core.runeIngot, 1), 1.0F);
    	this.addSmelting(Block.oreIron.blockID, new ItemStack(Item.ingotIron , 2), 1.0F);
    	this.addSmelting(Block.oreGold.blockID, new ItemStack(Item.ingotGold , 2), 1.0F);
    	this.addSmelting(Block.oreDiamond.blockID, new ItemStack(Item.diamond , 2), 1.0F);
    	this.addSmelting(core.eternalFragment.shiftedIndex, new ItemStack(core.blastedFragment , 1), 1.0F);
    	
    	
    
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
}
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
   