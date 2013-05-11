package Mod_OsmiCraft.Entitys.ImpactCrusher;

import java.util.Iterator;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotFurnace;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ImpactCrusherContainer extends Container {
	private ImpactCrusherEntity ImpactCrusherEntity;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	private int upgradeTime =  0;
	

	public ImpactCrusherContainer(InventoryPlayer par1InventoryPlayer,
			ImpactCrusherEntity par2CrusherEntity) {
		this.ImpactCrusherEntity = par2CrusherEntity;
 
		this.addSlotToContainer(new Slot(par2CrusherEntity, 0, 81, 53));
		
		this.addSlotToContainer(new Slot(par2CrusherEntity, 1, 10, 53));
		this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player,par2CrusherEntity, 2, 81, 12));
		
		
		int var3; 

		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var4
						+ var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			} 
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var3,
					8 + var3 * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.ImpactCrusherEntity.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.ImpactCrusherEntity.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this,2, this.ImpactCrusherEntity.currentItemBurnTime);
        
    }

	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	@Override
	public void updateCraftingResults() {
		
		super.updateCraftingResults();
		Iterator var1 = this.crafters.iterator();

		while (var1.hasNext()) {
			ICrafting var2 = (ICrafting) var1.next();

			if (this.lastCookTime != this.ImpactCrusherEntity.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 0,
						this.ImpactCrusherEntity.furnaceCookTime);
			}	
			

			if (this.lastBurnTime != this.ImpactCrusherEntity.furnaceBurnTime) {
				var2.sendProgressBarUpdate(this,1,
						this.ImpactCrusherEntity.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.ImpactCrusherEntity.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 2,
						this.ImpactCrusherEntity.currentItemBurnTime);
				
		}
			
		}

		this.lastCookTime = this.ImpactCrusherEntity.furnaceCookTime;
		this.lastBurnTime = this.ImpactCrusherEntity.furnaceBurnTime;
		this.lastItemBurnTime = this.ImpactCrusherEntity.currentItemBurnTime;
	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.ImpactCrusherEntity.furnaceCookTime = par2;
		}

		if (par1 == 1) {
			this.ImpactCrusherEntity.furnaceBurnTime = par2;
		}

		if (par1 == 2) {
			this.ImpactCrusherEntity.currentItemBurnTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.ImpactCrusherEntity.isUseableByPlayer(par1EntityPlayer);
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.inventorySlots.get(par2);

		if (var4 != null && var4.getHasStack()) {
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();

			if (par2 == 2) {
				if (!this.mergeItemStack(var5, 3, 39, true)) {
					return null;
				}

				var4.onSlotChange(var5, var3);
			} else if (par2 != 1 && par2 != 0) {
				if (ImpactCrushingRecipes.crushing().getCrushingResult(var5) != null) {
					if (!this.mergeItemStack(var5, 0, 1, false)) {
						return null;
					}
				} else if (ImpactCrusherEntity.isItemFuel(var5)) {
					if (!this.mergeItemStack(var5, 1, 2, false)) {
						return null;
					}
				} else if (par2 >= 3 && par2 < 30) {
					if (!this.mergeItemStack(var5, 30, 39, false)) {
						return null;
					}
				} else if (par2 >= 30 && par2 < 39
						&& !this.mergeItemStack(var5, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(var5, 3, 39, false)) {
				return null;
			}

			if (var5.stackSize == 0) {
				var4.putStack((ItemStack) null);
			} else {
				var4.onSlotChanged();
			}

			if (var5.stackSize == var3.stackSize) {
				return null;
			}

			var4.onPickupFromSlot(par1EntityPlayer, var5);
		}

		return var3;
	}

}


