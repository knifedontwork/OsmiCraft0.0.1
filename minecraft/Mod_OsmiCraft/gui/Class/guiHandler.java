package Mod_OsmiCraft.gui.Class;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import Mod_OsmiCraft.Entitys.BlastFurnace.BlastFurnaceEntity;
import Mod_OsmiCraft.Entitys.BlastFurnace.ContainerBlastFurnace;
import Mod_OsmiCraft.Entitys.BlastFurnace.GuiBlastFurnace;
import Mod_OsmiCraft.Entitys.Compressor.CompressorContainer;
import Mod_OsmiCraft.Entitys.Compressor.CompressorEntity;
import Mod_OsmiCraft.Entitys.Compressor.GuiCompressor;
import Mod_OsmiCraft.Entitys.EternalCompressor.EternalCompressorContainer;
import Mod_OsmiCraft.Entitys.EternalCompressor.EternalCompressorEntity;
import Mod_OsmiCraft.Entitys.EternalCompressor.EternalGui;
import Mod_OsmiCraft.Entitys.ImpactCrusher.GuiImpactCrusher;
import Mod_OsmiCraft.Entitys.ImpactCrusher.ImpactCrusherContainer;
import Mod_OsmiCraft.Entitys.ImpactCrusher.ImpactCrusherEntity;
import Mod_OsmiCraft.Entitys.RockCrusher.ContainerCrusher;
import Mod_OsmiCraft.Entitys.RockCrusher.CrusherEntity;
import Mod_OsmiCraft.Entitys.RockCrusher.CrusherGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class guiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity instanceof BlastFurnaceEntity) {

			return new ContainerBlastFurnace(player.inventory,
					(BlastFurnaceEntity) tile_entity);
		}if (tile_entity instanceof CrusherEntity) {

			return new ContainerCrusher(player.inventory,
					(CrusherEntity) tile_entity);
		}if (tile_entity instanceof ImpactCrusherEntity) {

			return new ImpactCrusherContainer(player.inventory,
					(ImpactCrusherEntity) tile_entity);
		}if (tile_entity instanceof CompressorEntity) {

			return new CompressorContainer(player.inventory,
					(CompressorEntity) tile_entity);
		}
		if (tile_entity instanceof EternalCompressorEntity) {

			return new EternalCompressorContainer(player.inventory,
					(EternalCompressorEntity) tile_entity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity instanceof BlastFurnaceEntity) {

			return new GuiBlastFurnace(player.inventory,
					(BlastFurnaceEntity) tile_entity);
			
		}if (tile_entity instanceof CrusherEntity) {

			return new CrusherGui(player.inventory,
					(CrusherEntity) tile_entity);
		}if (tile_entity instanceof ImpactCrusherEntity) {

			return new GuiImpactCrusher(player.inventory,
					(ImpactCrusherEntity) tile_entity);
		}if (tile_entity instanceof CompressorEntity) {

			return new GuiCompressor(player.inventory,
					(CompressorEntity) tile_entity);
		}if (tile_entity instanceof EternalCompressorEntity) {

			return new EternalGui(player.inventory,
					(EternalCompressorEntity) tile_entity);
		}
		return null;
	}
}


