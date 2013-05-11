package Mod_OsmiCraft;

import java.util.Random;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OsmiCraftGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	public void generateSurface(World world, Random random, int i, int j){
		for(int k = 0; k < 6; k++)
		{
		         int randPosX = i + random.nextInt(16);
		         int randPosY = random.nextInt(128);
		         int randPosZ = j + random.nextInt(16);
		         (new WorldGenMinable(core.osmiumOre.blockID, 5)).generate(world, random, randPosX, random.nextInt(15), randPosZ);
		         (new WorldGenMinable(core.aluminumOre.blockID, 6)).generate(world, random, randPosX, random.nextInt(15), randPosZ);
		         (new WorldGenMinable(core.amethystOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
		         (new WorldGenMinable(core.sulfurOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
		         (new WorldGenMinable(core.zincOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
		         (new WorldGenMinable(core.runiteOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128)  , randPosZ);
		         
		}
	}
	

		

		

	private void generateNether(World world, Random random, int blockX,
			int blockZ) {

	}

}
