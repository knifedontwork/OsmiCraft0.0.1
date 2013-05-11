package Mod_OsmiCraft.Entitys.Compressor;

import java.util.Random;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import Mod_OsmiCraft.core;
 

public class compressor extends BlockContainer{
	private Random furnaceRand = new Random();
	private static boolean keepFurnaceInventory = false;
	public compressor(int id) {
		super(id, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		furnaceRand = new Random();
	
	}
	 
		
		
	

	public int getBlockTextureFromSide(int side) {
		switch (side) {
		//Bottom
		
			//Top
		case 1:
			return blockIndexInTexture = 54;
			//Front
		
		default:
			return 53;
		}
	}
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}
	
	//needed to set the BLock in the right position
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
	//Grabs Texture File
	public String getTextureFile() {

		return "/BlockTest.png";
	}
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
			CompressorEntity var7 = (CompressorEntity) par1World
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

		return new CompressorEntity();
	}

}

