package Mod_OsmiCraft.Entitys.Compressor;

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

public class CompressorContainer extends Container{
	private CompressorEntity CompressorEntity;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	private int upgradeTime =  0;
	

	public CompressorContainer(InventoryPlayer par1InventoryPlayer,
			CompressorEntity par2CompressorEntity) {
		this.CompressorEntity = par2CompressorEntity;
 
		this.addSlotToContainer(new Slot(par2CompressorEntity, 0, 56, 16));
		
		this.addSlotToContainer(new Slot(par2CompressorEntity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player,par2CompressorEntity, 2, 123, 35));
		
		
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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.CompressorEntity.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.CompressorEntity.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this,2, this.CompressorEntity.currentItemBurnTime);
        
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

			if (this.lastCookTime != this.CompressorEntity.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 0,
						this.CompressorEntity.furnaceCookTime);
			}	
			

			if (this.lastBurnTime != this.CompressorEntity.furnaceBurnTime) {
				var2.sendProgressBarUpdate(this,1,
						this.CompressorEntity.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.CompressorEntity.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 2,
						this.CompressorEntity.currentItemBurnTime);
				
		}
			
		}

		this.lastCookTime = this.CompressorEntity.furnaceCookTime;
		this.lastBurnTime = this.CompressorEntity.furnaceBurnTime;
		this.lastItemBurnTime = this.CompressorEntity.currentItemBurnTime;
	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.CompressorEntity.furnaceCookTime = par2;
		}

		if (par1 == 1) {
			this.CompressorEntity.furnaceBurnTime = par2;
		}

		if (par1 == 2) {
			this.CompressorEntity.currentItemBurnTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.CompressorEntity.isUseableByPlayer(par1EntityPlayer);
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
				if (CompressRecipes.compressing().getCompressingResult(var5) != null) {
					if (!this.mergeItemStack(var5, 0, 1, false)) {
						return null;
					}
				} else if (CompressorEntity.isItemFuel(var5)) {
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

