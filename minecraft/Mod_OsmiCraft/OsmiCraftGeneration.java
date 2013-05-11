// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: fullnames deadcode nonlb lnc safe 
// Source File Name:   OsmiCraftGeneration.java

package Mod_OsmiCraft;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldProvider;

// Referenced classes of package Mod_OsmiCraft:
//            core

public class OsmiCraftGeneration
    implements cpw.mods.fml.common.IWorldGenerator {

            public OsmiCraftGeneration() {
            }

            public void generate(java.util.Random random, int chunkX, int chunkZ, net.minecraft.src.World world, net.minecraft.src.IChunkProvider chunkGenerator, net.minecraft.src.IChunkProvider chunkProvider) {
/*  15*/        switch(world.provider.dimensionId) {
/*  17*/        case -1: 
/*  17*/            generateNether(world, random, chunkX * 16, chunkZ * 16);
                    // fall through

/*  19*/        case 0: // '\0'
/*  19*/            generateSurface(world, random, chunkX * 16, chunkZ * 16);
                    // fall through

/*  21*/        default:
/*  21*/            return;
                }
            }

            public void generateSurface(net.minecraft.src.World world, java.util.Random random, int i, int j) {
/*  24*/        for(int k = 0; k < 5; k++) {
/*  26*/            int randPosX = i + random.nextInt(16);
/*  27*/            int randPosY = random.nextInt(128);
/*  28*/            int randPosZ = j + random.nextInt(16);
/*  29*/            (new WorldGenMinable(Mod_OsmiCraft.core.osmiumOre.blockID, 5)).generate(world, random, randPosX, random.nextInt(15), randPosZ);
/*  30*/            (new WorldGenMinable(Mod_OsmiCraft.core.aluminumOre.blockID, 6)).generate(world, random, randPosX, random.nextInt(15), randPosZ);
/*  31*/            (new WorldGenMinable(Mod_OsmiCraft.core.amethystOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
/*  32*/            (new WorldGenMinable(Mod_OsmiCraft.core.sulfurOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
/*  33*/            (new WorldGenMinable(Mod_OsmiCraft.core.zincOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
/*  34*/            (new WorldGenMinable(Mod_OsmiCraft.core.runiteOre.blockID, 7)).generate(world, random, randPosX, random.nextInt(128), randPosZ);
                }

            }

            private void generateNether(net.minecraft.src.World world1, java.util.Random random1, int i, int j) {
            }

			@Override
			public void generate(Random random, int chunkX, int chunkZ,
					net.minecraft.world.World world,
					net.minecraft.world.chunk.IChunkProvider chunkGenerator,
					net.minecraft.world.chunk.IChunkProvider chunkProvider) {
				// TODO Auto-generated method stub
				
			}
}
