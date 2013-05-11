package Mod_OsmiCraft.Entitys.Compressor;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import Mod_OsmiCraft.Entitys.ImpactCrusher.ImpactCrushingRecipes;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.registry.GameRegistry;

public class CompressorEntity extends TileEntity implements IInventory,
ISidedInventory {

private ItemStack[] compressor = new ItemStack[3];

public int furnaceBurnTime = 0;

public int currentItemBurnTime = 0;

public int furnaceCookTime = 0;

@Override
/**
* Returns the number of slots in the inventory.
*/
public int getSizeInventory() {
return this.compressor.length;
}

@Override
public ItemStack getStackInSlot(int slot) {
return this.compressor[slot];
}

public ItemStack decrStackSize(int par1, int par2) {
if (this.compressor[par1] != null) {
	ItemStack var3;

	if (this.compressor[par1].stackSize <= par2) {
		var3 = this.compressor[par1];
		this.compressor[par1] = null;
		return var3;
	} else {
		var3 = this.compressor[par1].splitStack(par2);

		if (this.compressor[par1].stackSize == 0) {
			this.compressor[par1] = null;
		}

		return var3;
	}
} else {
	return null;
}
}

/**
* When some containers are closed they call this on each slot, then drop
* whatever it returns as an EntityItem - like when you close a workbench
* GUI.
*/
public ItemStack getStackInSlotOnClosing(int par1) {
if (this.compressor[par1] != null) {
	ItemStack var2 = this.compressor[par1];
	this.compressor[par1] = null;
	return var2;
} else {
	return null;
}
}

/**
* Sets the given item stack to the specified slot in the inventory (can be
* crafting or armor sections).
*/
public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
this.compressor[par1] = par2ItemStack;

if (par2ItemStack != null
		&& par2ItemStack.stackSize > this.getInventoryStackLimit()) {
	par2ItemStack.stackSize = this.getInventoryStackLimit();
}
}

/**
* Returns the name of the inventory.
*/
public String getInvName() {
return "container.compressor";
}

/**
* Reads a tile entity from NBT.
*/
public void readFromNBT(NBTTagCompound par1NBTTagCompound)
{
super.readFromNBT(par1NBTTagCompound);
NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
this.compressor = new ItemStack[this.getSizeInventory()];

for (int var3 = 0; var3 < var2.tagCount(); ++var3)
{
    NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
    byte var5 = var4.getByte("Slot");

    if (var5 >= 0 && var5 < this.compressor.length)
    {
        this.compressor[var5] = ItemStack.loadItemStackFromNBT(var4);
    }
}

this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
this.currentItemBurnTime = getItemBurnTime(this.compressor[1]);
}

/**
* Writes a tile entity to NBT.
*/
public void writeToNBT(NBTTagCompound par1NBTTagCompound)
{
super.writeToNBT(par1NBTTagCompound);
par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
NBTTagList var2 = new NBTTagList();

for (int var3 = 0; var3 < this.compressor.length; ++var3)
{
    if (this.compressor[var3] != null)
    {
        NBTTagCompound var4 = new NBTTagCompound();
        var4.setByte("Slot", (byte)var3);
        this.compressor[var3].writeToNBT(var4);
        var2.appendTag(var4);
    }
}

par1NBTTagCompound.setTag("Items", var2);
}

public static int getItemBurnTime(ItemStack par0ItemStack) {
if (par0ItemStack == null) {
	return 0;
} else {
	int var1 = par0ItemStack.getItem().shiftedIndex;
	Item var2 = par0ItemStack.getItem();

	if (par0ItemStack.getItem() instanceof ItemBlock
			&& Block.blocksList[var1] != null) {

	}

	if (var1 == Item.bucketLava.shiftedIndex)
		return 20000;
	if (var1 == Item.coal.shiftedIndex)
		return 2000;

	return GameRegistry.getFuelValue(par0ItemStack);
}
}

/**
* Writes a tile entity to NBT.
*/


/**
* Returns the maximum stack size for a inventory slot. Seems to always be
* 64, possibly will be extended. *Isn't this more of a set than a get?*
*/
public int getInventoryStackLimit() {
return 64;
}

@SideOnly(Side.CLIENT)
/**
* Returns an integer between 0 and the passed value representing how close the current item is to being completely
* cooked
*/
public int getCookProgressScaled(int par1) {
return this.furnaceCookTime * par1 / 25;
}

@SideOnly(Side.CLIENT)
/**
* Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
* item, where 0 means that the item is exhausted and the passed value means that the item is fresh
*/
public int getBurnTimeRemainingScaled(int par1) {
if (this.currentItemBurnTime == 0) {
	this.currentItemBurnTime = 25;
}

return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
}

/**
* Returns true if the furnace is currently burning
*/
public boolean isBurning() {
return this.furnaceBurnTime > 0;

}

/**
* Allows the entity to update its state. Overridden in most subclasses,
* e.g. the mob spawner uses this to count ticks and creates a new spawn
* inside its implementation.
*/
@Override
public void updateEntity() {
boolean var1 = this.furnaceBurnTime > 0;
boolean var2 = false;

if (this.furnaceBurnTime > 0) {
	--this.furnaceBurnTime;
}

if (!this.worldObj.isRemote) {
	if (this.furnaceBurnTime == 0 && this.canCompress()) {
		this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.compressor[1]);

		if (this.furnaceBurnTime > 0) {
			var2 = true;

			if (this.compressor[1] != null) {
				--this.compressor[1].stackSize;

				if (this.compressor[1].stackSize == 0) {
					Item var3 = this.compressor[1].getItem()
							.getContainerItem();
					this.compressor[1] = var3 == null ? null
							: new ItemStack(var3);
				}
			}
		}
	}

	if (this.isBurning() && this.canCompress()) {
		++this.furnaceCookTime;
		if (this.furnaceCookTime == 25) {
			this.furnaceCookTime = 0;
			this.compressItem();
			

			var2 = true;
		}
	
	



}else {
	this.furnaceCookTime = 0;
}

if (var1 != this.furnaceBurnTime > 0) {
	var2 = true;

}

if (var2) {
	this.onInventoryChanged();

}
	}
}


/**
* Returns true if the furnace can smelt an item, i.e. has a source item,
* destination stack isn't full, etc.
*/
public boolean canCompress() {
if (this.compressor[0] == null) {
	return false;
	
} else {
	ItemStack var1 = CompressRecipes.compressing().getCompressingResult(this.compressor[0]);
	if (var1 == null)
		return false;
	if (this.compressor[2] == null)
		return true;
	if (!this.compressor[2].isItemEqual(var1))
		return false;
	int result = compressor[2].stackSize + var1.stackSize;
	return (result <= getInventoryStackLimit() && result <= var1
			.getMaxStackSize());
}
}
 


/**
* Turn one item from the furnace source stack into the appropriate smelted
* item in the furnace result stack
*/
public void compressItem()
{
    if (this.canCompress())
    {
        ItemStack var1 = CompressRecipes.compressing().getCompressingResult(this.compressor[0]);

        if (this.compressor[2] == null)
        {
            this.compressor[2] = var1.copy();
        }
        else if (this.compressor[2].isItemEqual(var1))
        {
            compressor[2].stackSize += var1.stackSize;
        }

        --this.compressor[0].stackSize;

        if (this.compressor[0].stackSize <= 0)
        {
            this.compressor[0] = null;
        }
    }
}

/**
* Returns the number of ticks that the supplied fuel item will keep the
* furnace burning, or 0 if the item isn't fuel
*/

/**
* Return true if item is a fuel source (getItemBurnTime() > 0).
*/
public static boolean isItemFuel(ItemStack par0ItemStack) {
return getItemBurnTime(par0ItemStack) > 0;
}

/**
* Do not make give this method the name canInteractWith because it clashes
* with Container
*/
public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord,
		this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq(
		(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
		(double) this.zCoord + 0.5D) <= 64.0D;
}

public void openChest() {
}

public void closeChest() {
}

@Override
public int getStartInventorySide(ForgeDirection side) {
if (side == ForgeDirection.DOWN)
	return 1;
if (side == ForgeDirection.UP)
	return 0;
return 2;
}

@Override
public int getSizeInventorySide(ForgeDirection side) {
return 1;
}

}
