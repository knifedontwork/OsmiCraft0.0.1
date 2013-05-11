package Mod_OsmiCraft.Entitys.EternalCompressor;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import Mod_OsmiCraft.core;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class eternalCompressor extends BlockContainer {

	private Random furnaceRand = new Random();
	private static boolean keepFurnaceInventory = false;
	public static boolean isActive;

	public eternalCompressor(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		furnaceRand = new Random();

	}

	public int getBlockTextureFromSide(int side) {
		switch (side) {
		//Bottom
		
			//Top
		case 1:
			return blockIndexInTexture = 55; 
			//Front 
		
		default:  
			return 56;
		}
	}

	

	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}

	private void setDefaultDirection(World par1World, int par2, int par3,
			int par4) {
		if (!par1World.isRemote) {
			int var5 = par1World.getBlockId(par2, par3, par4 - 1);
			int var6 = par1World.getBlockId(par2, par3, par4 + 1);
			int var7 = par1World.getBlockId(par2 - 1, par3, par4);
			int var8 = par1World.getBlockId(par2 + 1, par3, par4);
			byte var9 = 3;

			if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6]) {
				var9 = 3;
			}

			if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5]) {
				var9 = 2;
			}

			if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8]) {
				var9 = 5;
			}

			if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7]) {
				var9 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
		}
	}

	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);

	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLiving par5EntityLiving) {
		int var6 = MathHelper
				.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
		}

		if (var6 == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
		}

		if (var6 == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
		}

		if (var6 == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
		}
	}

	public String getTextureFile() {

		return "/BlockTest.png";
	}

	
	/**
	 * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
	 */
	/**
	 * Gui
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int i, float f, float g, float t) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity == null || player.isSneaking()) {
			return false;
		}

		player.openGui(core.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			int par5, int par6) {
		if (!keepFurnaceInventory) {
			EternalCompressorEntity var7 = (EternalCompressorEntity) par1World
					.getBlockTileEntity(par2, par3, par4);

			if (var7 != null) {
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null) {
						float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0) {
							int var13 = this.furnaceRand.nextInt(21) + 10;

							if (var13 > var9.stackSize) {
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World,
									(double) ((float) par2 + var10),
									(double) ((float) par3 + var11),
									(double) ((float) par4 + var12),
									new ItemStack(var9.itemID, var13,
											var9.getItemDamage()));

							if (var9.hasTagCompound()) {
								var14.item.setTagCompound((NBTTagCompound) var9
										.getTagCompound().copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double) ((float) this.furnaceRand
									.nextGaussian() * var15);
							var14.motionY = (double) ((float) this.furnaceRand
									.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double) ((float) this.furnaceRand
									.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {

		return new EternalCompressorEntity();
	}

}



