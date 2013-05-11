package Mod_OsmiCraft.Entitys.EternalCompressor;

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

public class EternalCompressorContainer extends Container {
	private EternalCompressorEntity eternalCompressorEntity;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	private int upgradeTime =  0;
	

	public EternalCompressorContainer(InventoryPlayer par1InventoryPlayer,
			EternalCompressorEntity par2EternalCompressorEntity) {
		this.eternalCompressorEntity = par2EternalCompressorEntity;
 
		this.addSlotToContainer(new Slot(par2EternalCompressorEntity, 0, 27, 27));
		this.addSlotToContainer(new Slot(par2EternalCompressorEntity, 1, 49, 27));
		this.addSlotToContainer(new Slot(par2EternalCompressorEntity, 2, 71, 27));
		this.addSlotToContainer(new Slot(par2EternalCompressorEntity, 3, 49, 50));
		this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player,par2EternalCompressorEntity, 4, 123, 35));
		
		
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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.eternalCompressorEntity.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.eternalCompressorEntity.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.eternalCompressorEntity.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.eternalCompressorEntity.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this,4, this.eternalCompressorEntity.currentItemBurnTime);
        
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

			if (this.lastCookTime != this.eternalCompressorEntity.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 0,
						this.eternalCompressorEntity.furnaceCookTime);
			}
			if (this.lastCookTime != this.eternalCompressorEntity.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 1,
						this.eternalCompressorEntity.furnaceCookTime);
			}	
			if (this.lastCookTime != this.eternalCompressorEntity.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 2,
						this.eternalCompressorEntity.furnaceCookTime);
			}	
			

			if (this.lastBurnTime != this.eternalCompressorEntity.furnaceBurnTime) {
				var2.sendProgressBarUpdate(this,3,
						this.eternalCompressorEntity.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.eternalCompressorEntity.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 4,
						this.eternalCompressorEntity.currentItemBurnTime);
				
		}
			
		}

		this.lastCookTime = this.eternalCompressorEntity.furnaceCookTime;
		this.lastBurnTime = this.eternalCompressorEntity.furnaceBurnTime;
		this.lastItemBurnTime = this.eternalCompressorEntity.currentItemBurnTime;
	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.eternalCompressorEntity.furnaceCookTime = par2;
		}

		if (par1 == 1) {
			this.eternalCompressorEntity.furnaceBurnTime = par2;
		}

		if (par1 == 2) {
			this.eternalCompressorEntity.currentItemBurnTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.eternalCompressorEntity.isUseableByPlayer(par1EntityPlayer);
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.inventorySlots.get(par2);

		if (var4 != null && var4.getHasStack()) {
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();

			if (par2 == 4) {
				if (!this.mergeItemStack(var5, 3, 39, true)) {
					return null;
				}

				var4.onSlotChange(var5, var3);
			} else if (par2 != 1 && par2 != 0) {
				if (EternalRecipes.smelting().getSmeltingResult(var5) != null) {
					if (!this.mergeItemStack(var5, 0, 1,  false)) {
						return null;
					}
				} else if (EternalCompressorEntity.isItemFuel(var5)) {
					if (!this.mergeItemStack(var5, 3, 4, false)) {
						return null;
					}
				} else if (par2 >= 3 && par2 < 30) {
					if (!this.mergeItemStack(var5, 30, 39, false)) {
						return null;
					}
				} else if (par2 >= 30 && par2 < 39
						&& !this.mergeItemStack(var5, 1, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(var5, 2, 39, false)) {
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
