// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: fullnames deadcode nonlb lnc safe 
// Source File Name:   core.java

package Mod_OsmiCraft;

import Mod_OsmiCraft.Blocks.Aluminum.AluminumBlock;
import Mod_OsmiCraft.Blocks.Aluminum.AluminumItem;
import Mod_OsmiCraft.Blocks.Aluminum.AluminumOre;
import Mod_OsmiCraft.Blocks.Aluminum.aluminumIngot;
import Mod_OsmiCraft.Blocks.Amethyst.AmethystBlock;
import Mod_OsmiCraft.Blocks.Amethyst.AmethystItem;
import Mod_OsmiCraft.Blocks.Amethyst.AmythestOre;
import Mod_OsmiCraft.Blocks.Amethyst.amethystIngot;
import Mod_OsmiCraft.Blocks.Osmium.OsmiumBlock;
import Mod_OsmiCraft.Blocks.Osmium.OsmiumItem;
import Mod_OsmiCraft.Blocks.Osmium.OsmiumOre;
import Mod_OsmiCraft.Blocks.Osmium.osmiumIngot;
import Mod_OsmiCraft.Blocks.Rune.RuneBlock;
import Mod_OsmiCraft.Blocks.Rune.RuneItem;
import Mod_OsmiCraft.Blocks.Rune.RuniteOre;
import Mod_OsmiCraft.Blocks.Rune.runeIngot;
import Mod_OsmiCraft.Blocks.Sulfur.SulfurBlock;
import Mod_OsmiCraft.Blocks.Sulfur.SulfurIngotItem;
import Mod_OsmiCraft.Blocks.Sulfur.SulfurItem;
import Mod_OsmiCraft.Blocks.Sulfur.SulfurOre;
import Mod_OsmiCraft.Blocks.Zinc.ZincBlock;
import Mod_OsmiCraft.Blocks.Zinc.ZincItem;
import Mod_OsmiCraft.Blocks.Zinc.ZincOre;
import Mod_OsmiCraft.Blocks.Zinc.zincIngot;
import Mod_OsmiCraft.Entitys.BlastFurnace.BlastFurnace;
import Mod_OsmiCraft.Entitys.BlastFurnace.BlastFurnaceEntity;
import Mod_OsmiCraft.Entitys.Compressor.CompressorEntity;
import Mod_OsmiCraft.Entitys.Compressor.compressor;
import Mod_OsmiCraft.Entitys.EternalCompressor.EternalCompressorEntity;
import Mod_OsmiCraft.Entitys.EternalCompressor.eternalCompressor;
import Mod_OsmiCraft.Entitys.ImpactCrusher.ImpactCrusherEntity;
import Mod_OsmiCraft.Entitys.ImpactCrusher.impactCrusher;
import Mod_OsmiCraft.Entitys.RockCrusher.CrusherEntity;
import Mod_OsmiCraft.Entitys.RockCrusher.rockCrusher;
import Mod_OsmiCraft.Items.CompressedItem.compressedItem;
import Mod_OsmiCraft.Items.EternalRunes.blastedFragment;
import Mod_OsmiCraft.Items.EternalRunes.compressedFragment;
import Mod_OsmiCraft.Items.EternalRunes.eternalFragment;
import Mod_OsmiCraft.Items.EternalRunes.eternalHalf1;
import Mod_OsmiCraft.Items.EternalRunes.eternalHalf2;
import Mod_OsmiCraft.Items.EternalRunes.eternalRune;
import Mod_OsmiCraft.Items.Weapons.Amethyst.amethystAxe;
import Mod_OsmiCraft.Items.Weapons.Amethyst.amethystPick;
import Mod_OsmiCraft.Items.Weapons.Amethyst.amethystShovel;
import Mod_OsmiCraft.Items.Weapons.Amethyst.amethystSword;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalAxe;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalPick;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalShovel;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalSword;
import Mod_OsmiCraft.Items.Weapons.Rune.runeAxe;
import Mod_OsmiCraft.Items.Weapons.Rune.runePick;
import Mod_OsmiCraft.Items.Weapons.Rune.runeShovel;
import Mod_OsmiCraft.Items.Weapons.Rune.runeSword;
import Mod_OsmiCraft.Items.WeaponsOsmium.osmiumAxe;
import Mod_OsmiCraft.Items.WeaponsOsmium.osmiumPick;
import Mod_OsmiCraft.Items.WeaponsOsmium.osmiumShovel;
import Mod_OsmiCraft.Items.WeaponsOsmium.osmiumSword;
import Mod_OsmiCraft.gui.Class.guiHandler;
import OsmiCraft.Common.CommonProxyRender;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;

// Referenced classes of package Mod_OsmiCraft:
//            OsmiCraftGeneration

public class core {

            public core() {
/*  95*/        guiHandler = new guiHandler();
            }

            public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
/* 207*/        net.minecraftforge.common.Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 208*/        config.load();
/* 209*/        blastFurnaceID = config.getBlock("Blast Furnace", 1140).getInt();
/* 210*/        rockCrusherID = config.getBlock("Rock Crusher", 1141).getInt();
/* 211*/        impactCrusherID = config.getBlock("Impact Crusher", 1142).getInt();
/* 212*/        compressorID = config.getBlock("Compressor", 1143).getInt();
/* 213*/        eternalCompressorID = config.getBlock("Eternal Compressor", 1144).getInt();
/* 214*/        osmiumOreID = config.getBlock("Osmium Ore", 1145).getInt();
/* 215*/        aluminumOreID = config.getBlock("Aluminum Ore", 1146).getInt();
/* 216*/        amethystOreID = config.getBlock("Amethyst Ore", 1147).getInt();
/* 217*/        runeOreID = config.getBlock("Rune Ore", 1148).getInt();
/* 218*/        sulfurOreID = config.getBlock("Sulfur Ore", 1149).getInt();
/* 219*/        zincOreID = config.getBlock("Zinc Ore", 1150).getInt();
/* 220*/        osmiumBlockID = config.getBlock("Osmium Block", 1151).getInt();
/* 221*/        aluminumBlockID = config.getBlock("Aluminum Block", 1152).getInt();
/* 222*/        amethystBlockID = config.getBlock("Amethyst Block", 1153).getInt();
/* 223*/        runeBlockID = config.getBlock("Rune Block", 1154).getInt();
/* 224*/        sulfurBlockID = config.getBlock("Sulfur Block", 1155).getInt();
/* 225*/        zincBlockID = config.getBlock("Zinc Block", 1156).getInt();
/* 226*/        config.save();
            }

            public void load(cpw.mods.fml.common.event.FMLInitializationEvent event) {
/* 241*/        cpw.mods.fml.common.registry.GameRegistry.registerWorldGenerator(((cpw.mods.fml.common.IWorldGenerator) (new OsmiCraftGeneration())));
/* 245*/        Zinc = (new ZincItem(1550)).setIconIndex(0).setItemName("Zinc");
/* 246*/        zincIngot = (new zincIngot(1551)).setIconIndex(16).setItemName("ZincIngot");
/* 247*/        Sulfur = (new SulfurItem(1552)).setIconIndex(1).setItemName("Sulfur");
/* 248*/        sulfurIngot = (new SulfurIngotItem(1553)).setIconIndex(17).setItemName("SulfurIngot");
/* 249*/        Rune = (new RuneItem(1554)).setIconIndex(2).setItemName("Rune");
/* 250*/        runeIngot = (new runeIngot(1555)).setIconIndex(18).setItemName("RuneIngot");
/* 251*/        Amethyst = (new AmethystItem(1556)).setIconIndex(3).setItemName("Amythyst");
/* 252*/        amethystIngot = (new amethystIngot(1557)).setIconIndex(19).setItemName("AmethystIngot");
/* 253*/        Aluminum = (new AluminumItem(1558)).setIconIndex(4).setItemName("Aluminum");
/* 254*/        aluminumIngot = (new aluminumIngot(1559)).setIconIndex(20).setItemName("AluminumIngot");
/* 255*/        Osmium = (new OsmiumItem(1560)).setIconIndex(5).setItemName("Osmium");
/* 256*/        osmiumIngot = (new osmiumIngot(1561)).setIconIndex(21).setItemName("OsmiumIngot");
/* 257*/        compressedZinc = (new compressedItem(1562)).setIconIndex(32).setItemName("CompressedZinc");
/* 258*/        compressedSulfur = (new compressedItem(1563)).setIconIndex(33).setItemName("CompressedSulfur");
/* 259*/        compressedRune = (new compressedItem(1564)).setIconIndex(34).setItemName("CompressedRune");
/* 260*/        compressedAmethyst = (new compressedItem(1565)).setIconIndex(35).setItemName("CompressedAmethyst");
/* 261*/        compressedAluminum = (new compressedItem(1566)).setIconIndex(36).setItemName("CompressedAluminum");
/* 262*/        compressedOsmium = (new compressedItem(1567)).setIconIndex(37).setItemName("CompressedOsmium");
/* 263*/        amethystSword = (new amethystSword(1568, AmethystMaterial)).setIconIndex(131).setItemName("amethystSword");
/* 264*/        amethystShovel = (new amethystShovel(1569, AmethystMaterial)).setIconIndex(147).setItemName("amethystShovel");
/* 265*/        amethystPick = (new amethystPick(1570, AmethystMaterial)).setIconIndex(163).setItemName("amethystPick");
/* 266*/        amethystAxe = (new amethystAxe(1571, AmethystMaterial)).setIconIndex(179).setItemName("amethystAxe");
/* 267*/        osmiumSword = (new osmiumSword(1572, OsmiumMaterial)).setIconIndex(130).setItemName("osmiumSword");
/* 268*/        osmiumShovel = (new osmiumShovel(1573, OsmiumMaterial)).setIconIndex(146).setItemName("osmiumShovel");
/* 269*/        osmiumPick = (new osmiumPick(1574, OsmiumMaterial)).setIconIndex(162).setItemName("osmiumPick");
/* 270*/        osmiumAxe = (new osmiumAxe(1575, OsmiumMaterial)).setIconIndex(178).setItemName("osmiumAxe");
/* 271*/        runeSword = (new runeSword(1576, RuneMaterial)).setIconIndex(129).setItemName("runeSword");
/* 272*/        runeShovel = (new runeShovel(1577, RuneMaterial)).setIconIndex(145).setItemName("runeShovel");
/* 273*/        runePick = (new runePick(1578, RuneMaterial)).setIconIndex(161).setItemName("runePick");
/* 274*/        runeAxe = (new runeAxe(1579, RuneMaterial)).setIconIndex(177).setItemName("runeAxe");
/* 275*/        eternalRune = (new eternalRune(1580)).setIconIndex(66).setItemName("eternalRune");
/* 276*/        eternalFragment = (new eternalFragment(1581)).setIconIndex(65).setItemName("eternalFragment");
/* 277*/        eternalHalf1 = (new eternalHalf1(1582)).setIconIndex(82).setItemName("eternalHalf1");
/* 278*/        eternalHalf2 = (new eternalHalf2(1583)).setIconIndex(98).setItemName("eternalHalf2");
/* 279*/        blastedFragment = (new compressedFragment(1584)).setIconIndex(81).setItemName("blastedFragment");
/* 280*/        compressedFragment = (new blastedFragment(1585)).setIconIndex(97).setItemName("compressedFragment");
/* 290*/        eternalSword = (new eternalSword(1586, EternalMaterial)).setIconIndex(128).setItemName("eternalSword");
/* 291*/        eternalShovel = (new eternalShovel(1587, EternalMaterial)).setIconIndex(144).setItemName("eternalShovel");
/* 292*/        eternalPick = (new eternalPick(1588, EternalMaterial)).setIconIndex(160).setItemName("eternalPick");
/* 293*/        eternalAxe = (new eternalAxe(1589, EternalMaterial)).setIconIndex(176).setItemName("eternalAxe");
/* 297*/        zincOre = (new ZincOre(zincOreID, 0)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Zinc_Ore");
/* 298*/        sulfurOre = (new SulfurOre(sulfurOreID, 1)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Sulfur_Ore");
/* 299*/        runiteOre = (new RuniteOre(runeOreID, 2)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Runite_Ore");
/* 300*/        amethystOre = (new AmythestOre(amethystOreID, 3)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Amethyst_Ore");
/* 301*/        aluminumOre = (new AluminumOre(aluminumOreID, 4)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Aluminum_Ore");
/* 302*/        osmiumOre = (new OsmiumOre(osmiumOreID, 5)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(10F).setResistance(10F).setBlockName("Osmium_Ore");
/* 303*/        zincBlock = (new ZincBlock(zincBlockID, 16)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Zinc_Block");
/* 304*/        sulfurBlock = (new SulfurBlock(sulfurBlockID, 17)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Sulfur_Block");
/* 305*/        runiteBlock = (new RuneBlock(runeBlockID, 18)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Runite_Block");
/* 306*/        amethystBlock = (new AmethystBlock(amethystBlockID, 19)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Amethyst_Block");
/* 307*/        aluminumBlock = (new AluminumBlock(aluminumBlockID, 20)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Aluminum_Block");
/* 308*/        osmiumBlock = (new OsmiumBlock(osmiumBlockID, 21)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(10F).setResistance(10F).setBlockName("Osmium_Block");
/* 309*/        advandcedBlock = (new OsmiumBlock(1659, 22)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(10F).setResistance(10F).setBlockName("Advandced_Block");
/* 310*/        eternalBlock = (new OsmiumBlock(1660, 23)).setStepSound(net.minecraft.src.Block.soundStoneFootstep).setHardness(10F).setResistance(10F).setBlockName("Eternal_Block");
/* 311*/        net.minecraftforge.common.MinecraftForge.setBlockHarvestLevel(zincOre, 0, "pickaxe", 2);
/* 312*/        net.minecraftforge.common.MinecraftForge.setBlockHarvestLevel(sulfurOre, 0, "pickaxe", 2);
/* 313*/        net.minecraftforge.common.MinecraftForge.setBlockHarvestLevel(runiteOre, 0, "pickaxe", 2);
/* 314*/        net.minecraftforge.common.MinecraftForge.setBlockHarvestLevel(amethystOre, 0, "pickaxe", 2);
/* 315*/        net.minecraftforge.common.MinecraftForge.setBlockHarvestLevel(aluminumOre, 0, "pickaxe", 2);
/* 316*/        net.minecraftforge.common.MinecraftForge.setBlockHarvestLevel(osmiumOre, 0, "pickaxe", 3);
/* 320*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(zincOre);
/* 321*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(sulfurOre);
/* 322*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(runiteOre);
/* 323*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(amethystOre);
/* 324*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(aluminumOre);
/* 325*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(osmiumOre);
/* 326*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(zincBlock);
/* 327*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(sulfurBlock);
/* 328*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(runiteBlock);
/* 329*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(amethystBlock);
/* 330*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(aluminumBlock);
/* 331*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(osmiumBlock);
/* 332*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(advandcedBlock);
/* 333*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(eternalBlock);
/* 336*/        cpw.mods.fml.common.registry.GameRegistry.registerTileEntity(Mod_OsmiCraft/Entitys/BlastFurnace/BlastFurnaceEntity, "Blas-tFurnaceEntity");
/* 337*/        cpw.mods.fml.common.registry.GameRegistry.registerTileEntity(Mod_OsmiCraft/Entitys/RockCrusher/CrusherEntity, "CrusherEntity");
/* 338*/        cpw.mods.fml.common.registry.GameRegistry.registerTileEntity(Mod_OsmiCraft/Entitys/ImpactCrusher/ImpactCrusherEntity, "ImpactCrusherEntity");
/* 339*/        cpw.mods.fml.common.registry.GameRegistry.registerTileEntity(Mod_OsmiCraft/Entitys/Compressor/CompressorEntity, "CompressorEntity");
/* 340*/        cpw.mods.fml.common.registry.GameRegistry.registerTileEntity(Mod_OsmiCraft/Entitys/EternalCompressor/EternalCompressorEntity, "EternalCompressorEntity");
/* 346*/        blastFurnace = (new BlastFurnace(blastFurnaceID)).setHardness(3F).setBlockName("Blast_Furnace");
/* 347*/        impactCrusher = (new impactCrusher(impactCrusherID)).setHardness(3F).setBlockName("Impact_Crusher");
/* 348*/        rockCrusher = (new rockCrusher(rockCrusherID)).setHardness(3F).setBlockName("Rock_Crusher");
/* 349*/        compressor = (new compressor(compressorID)).setHardness(3F).setBlockName("Compressor");
/* 350*/        eternalCompressor = (new eternalCompressor(eternalCompressorID)).setHardness(3F).setBlockName("Eternal_Compressor");
/* 356*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(eternalFragment, 1), new java.lang.Object[] {
/* 357*/            "OAO", "MDM", "OAO", java.lang.Character.valueOf('O'), compressedOsmium, java.lang.Character.valueOf('A'), compressedAluminum, java.lang.Character.valueOf('M'), compressedAmethyst, java.lang.Character.valueOf('D'), 
/* 358*/            net.minecraft.src.Item.diamond
                });
/* 359*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(eternalHalf1, 1), new java.lang.Object[] {
/* 360*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), compressedFragment
                });
/* 361*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(eternalHalf2, 1), new java.lang.Object[] {
/* 362*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), blastedFragment
                });
/* 363*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(eternalRune, 1), new java.lang.Object[] {
/* 364*/            new ItemStack(eternalHalf1, 1), new ItemStack(eternalHalf2, 1)
                });
/* 366*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(amethystAxe, 1), new java.lang.Object[] {
/* 367*/            "XXB", "XSB", "BSB", java.lang.Character.valueOf('X'), amethystIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 368*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(amethystSword, 1), new java.lang.Object[] {
/* 369*/            "BXB", "BXB", "BSB", java.lang.Character.valueOf('X'), amethystIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 370*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(amethystShovel, 1), new java.lang.Object[] {
/* 371*/            "BXB", "BSB", "BSB", java.lang.Character.valueOf('X'), amethystIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 372*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(amethystPick, 1), new java.lang.Object[] {
/* 373*/            "XXX", "BSB", "BSB", java.lang.Character.valueOf('X'), amethystIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 375*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(runeAxe, 1), new java.lang.Object[] {
/* 376*/            "XXB", "XSB", "BSB", java.lang.Character.valueOf('X'), runeIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 377*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(runeSword, 1), new java.lang.Object[] {
/* 378*/            "BXB", "BXB", "BSB", java.lang.Character.valueOf('X'), runeIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 379*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(runeShovel, 1), new java.lang.Object[] {
/* 380*/            "BXB", "BSB", "BSB", java.lang.Character.valueOf('X'), runeIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 381*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(runePick, 1), new java.lang.Object[] {
/* 382*/            "XXX", "BSB", "BSB", java.lang.Character.valueOf('X'), runeIngot, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 384*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(osmiumAxe, 1), new java.lang.Object[] {
/* 385*/            "XXB", "XSB", "BSB", java.lang.Character.valueOf('X'), osmiumBlock, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 386*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(osmiumSword, 1), new java.lang.Object[] {
/* 387*/            "BXB", "BXB", "BSB", java.lang.Character.valueOf('X'), osmiumBlock, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 388*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(osmiumShovel, 1), new java.lang.Object[] {
/* 389*/            "BXB", "BSB", "BSB", java.lang.Character.valueOf('X'), osmiumBlock, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 390*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(osmiumPick, 1), new java.lang.Object[] {
/* 391*/            "XXX", "BSB", "BSB", java.lang.Character.valueOf('X'), osmiumBlock, java.lang.Character.valueOf('S'), net.minecraft.src.Item.stick
                });
/* 399*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(zincBlock, 1), new java.lang.Object[] {
/* 400*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), zincIngot
                });
/* 401*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(sulfurBlock, 1), new java.lang.Object[] {
/* 402*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), sulfurIngot
                });
/* 403*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(runiteBlock, 1), new java.lang.Object[] {
/* 404*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), runeIngot
                });
/* 405*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(amethystBlock, 1), new java.lang.Object[] {
/* 406*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), amethystIngot
                });
/* 407*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(aluminumBlock, 1), new java.lang.Object[] {
/* 408*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), aluminumIngot
                });
/* 409*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(osmiumBlock, 1), new java.lang.Object[] {
/* 410*/            "XXX", "XXX", "XXX", java.lang.Character.valueOf('X'), osmiumIngot
                });
/* 411*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(osmiumIngot, 9), new java.lang.Object[] {
/* 412*/            new ItemStack(osmiumBlock, 1)
                });
/* 414*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(aluminumIngot, 9), new java.lang.Object[] {
/* 415*/            new ItemStack(aluminumBlock, 1)
                });
/* 416*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(zincIngot, 9), new java.lang.Object[] {
/* 417*/            new ItemStack(zincBlock, 1)
                });
/* 418*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(sulfurIngot, 9), new java.lang.Object[] {
/* 419*/            new ItemStack(sulfurBlock, 1)
                });
/* 420*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(runeIngot, 9), new java.lang.Object[] {
/* 421*/            new ItemStack(runiteBlock, 1)
                });
/* 422*/        cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe(new ItemStack(amethystIngot, 9), new java.lang.Object[] {
/* 423*/            new ItemStack(amethystBlock, 1)
                });
/* 426*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(blastFurnace, 1), new java.lang.Object[] {
/* 427*/            "XXX", "XZX", "XXX", java.lang.Character.valueOf('X'), net.minecraft.src.Block.blockSteel, java.lang.Character.valueOf('Z'), net.minecraft.src.Block.stoneOvenIdle
                });
/* 429*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(rockCrusher, 1), new java.lang.Object[] {
/* 430*/            "SFS", "SPS", "SLS", java.lang.Character.valueOf('S'), net.minecraft.src.Block.stone, java.lang.Character.valueOf('F'), net.minecraft.src.Block.stoneOvenIdle, java.lang.Character.valueOf('P'), net.minecraft.src.Block.pistonBase, java.lang.Character.valueOf('L'), 
/* 431*/            net.minecraft.src.Block.pressurePlateStone
                });
/* 433*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(impactCrusher, 1), new java.lang.Object[] {
/* 434*/            "SFS", "SPS", "SLS", java.lang.Character.valueOf('S'), aluminumBlock, java.lang.Character.valueOf('F'), net.minecraft.src.Block.pressurePlateStone, java.lang.Character.valueOf('P'), rockCrusher, java.lang.Character.valueOf('L'), 
/* 435*/            net.minecraft.src.Item.bucketLava
                });
/* 437*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(compressor, 1), new java.lang.Object[] {
/* 438*/            "SFS", "SPS", "SSS", java.lang.Character.valueOf('S'), aluminumBlock, java.lang.Character.valueOf('F'), impactCrusher, java.lang.Character.valueOf('P'), blastFurnace
                });
/* 440*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(eternalCompressor, 1), new java.lang.Object[] {
/* 441*/            "XXX", "XZX", "XXX", java.lang.Character.valueOf('X'), eternalBlock, java.lang.Character.valueOf('Z'), compressor
                });
/* 443*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(advandcedBlock, 1), new java.lang.Object[] {
/* 444*/            "OZO", "SAS", "OZO", java.lang.Character.valueOf('O'), compressedOsmium, java.lang.Character.valueOf('Z'), compressedZinc, java.lang.Character.valueOf('S'), compressedSulfur, java.lang.Character.valueOf('A'), 
/* 445*/            aluminumBlock
                });
/* 446*/        cpw.mods.fml.common.registry.GameRegistry.addRecipe(new ItemStack(eternalBlock, 1), new java.lang.Object[] {
/* 447*/            "XXX", "XZX", "XXX", java.lang.Character.valueOf('X'), eternalRune, java.lang.Character.valueOf('Z'), advandcedBlock
                });
/* 460*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(blastFurnace);
/* 461*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(impactCrusher);
/* 462*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(rockCrusher);
/* 463*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(compressor);
/* 464*/        cpw.mods.fml.common.registry.GameRegistry.registerBlock(eternalCompressor);
/* 468*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (Zinc)), "Zinc");
/* 469*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (zincOre)), "Zinc Ore");
/* 470*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (sulfurOre)), "Sulfur Ore");
/* 471*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (Sulfur)), "Sulfur");
/* 472*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (sulfurIngot)), "Sulfur Ingot");
/* 473*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runiteOre)), "Rune Ore");
/* 474*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystOre)), "Amethyst Ore");
/* 475*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (aluminumOre)), "Aluminum Ore");
/* 476*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (blastFurnace)), "Blast Furnace");
/* 477*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumOre)), "Osmium Ore");
/* 478*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (Amethyst)), "Amethyst");
/* 479*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystIngot)), "Amethyst Ingot");
/* 480*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (Rune)), "Rune");
/* 481*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runeIngot)), "Rune Ingot");
/* 482*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (Osmium)), "Osmium");
/* 483*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumIngot)), "Osmium Ingot");
/* 484*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (Aluminum)), "Aluminum");
/* 485*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (aluminumIngot)), "Aluminum Ingot");
/* 486*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (zincIngot)), "Zinc Ingot");
/* 487*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (impactCrusher)), "Impact Crusher");
/* 488*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (rockCrusher)), "Rock Crusher");
/* 489*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (zincBlock)), "Zinc Block");
/* 490*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (sulfurBlock)), "Sulfur Block");
/* 491*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (aluminumBlock)), "Aluminum Block");
/* 492*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runiteBlock)), "Rune Block");
/* 493*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystBlock)), "Amethyst Block");
/* 494*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumBlock)), "Osmium Block");
/* 495*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressor)), "Compressor");
/* 496*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedAmethyst)), "Compressed Amethyst");
/* 497*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedAluminum)), "Compressed Aluminum");
/* 498*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedOsmium)), "Compressed Osmium");
/* 499*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystSword)), "Amethyst Sword");
/* 500*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystShovel)), "Amethyst Shovel");
/* 501*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystPick)), "Amethyst PickAxe");
/* 502*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (amethystAxe)), "Amethyst Axe");
/* 503*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumSword)), "Osmium Sword");
/* 504*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumShovel)), "Osmium Shovel");
/* 505*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumPick)), "Osmium Pick");
/* 506*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (osmiumAxe)), "Osmium Axe");
/* 507*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runeSword)), "Rune Sword");
/* 508*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runeShovel)), "Rune Shovel");
/* 509*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runePick)), "Rune Pick");
/* 510*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (runeAxe)), "Rune Axe");
/* 511*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalSword)), "\2474Eternal Sword");
/* 512*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalShovel)), "\2474Eternal Shovel");
/* 513*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalPick)), "\2474Eternal PickAxe");
/* 514*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalAxe)), "\2474Eternal Axe");
/* 515*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalRune)), "\2474Eternal Rune");
/* 516*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalFragment)), "Eternal Rune Fragment");
/* 517*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalHalf1)), "Eternal Half");
/* 518*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalHalf2)), "Eternal Half");
/* 519*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedFragment)), "Compressed Fragment");
/* 520*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (blastedFragment)), "Blasted Fragment");
/* 521*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalCompressor)), "\2474Eternal Compressor");
/* 522*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedSulfur)), "Compressed Sulfur");
/* 523*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedZinc)), "Compressed Zinc");
/* 524*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (compressedRune)), "Compressed Rune");
/* 525*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (eternalBlock)), "\2474Eternal Block");
/* 526*/        cpw.mods.fml.common.registry.LanguageRegistry.addName(((java.lang.Object) (advandcedBlock)), "\2479Advandced Block");
/* 532*/        proxy.registerRenderThings();
/* 533*/        cpw.mods.fml.common.network.NetworkRegistry.instance().registerGuiHandler(((java.lang.Object) (this)), ((cpw.mods.fml.common.network.IGuiHandler) (guiHandler)));
            }

            public static OsmiCraft.Common.CommonProxyRender proxy;
            public static Mod_OsmiCraft.core instance = new core();
            private Mod_OsmiCraft.gui.Class.guiHandler guiHandler;
            static net.minecraft.src.EnumArmorMaterial EternalArmor = net.minecraftforge.common.EnumHelper.addArmorMaterial("EternalArmor", 35, new int[] {
/*  96*/        999, 999, 999, 999
            }, 0);
            static net.minecraft.src.EnumToolMaterial EternalMaterial = net.minecraftforge.common.EnumHelper.addToolMaterial("EternalMaterial", 3, 0, 20F, 12, 14);
            static net.minecraft.src.EnumToolMaterial AmethystMaterial = net.minecraftforge.common.EnumHelper.addToolMaterial("AmethystMaterial", 3, 400, 8F, 3, 14);
            static net.minecraft.src.EnumToolMaterial OsmiumMaterial = net.minecraftforge.common.EnumHelper.addToolMaterial("OsmiumMaterial", 3, 999, 10F, 4, 14);
            static net.minecraft.src.EnumToolMaterial RuneMaterial = net.minecraftforge.common.EnumHelper.addToolMaterial("RuneMaterial", 3, 400, 9F, 3, 14);
            public static net.minecraft.src.Block zincOre;
            public static net.minecraft.src.Block sulfurOre;
            public static net.minecraft.src.Block runiteOre;
            public static net.minecraft.src.Block amethystOre;
            public static net.minecraft.src.Block aluminumOre;
            public static net.minecraft.src.Block osmiumOre;
            public static net.minecraft.src.Block zincBlock;
            public static net.minecraft.src.Block sulfurBlock;
            public static net.minecraft.src.Block runiteBlock;
            public static net.minecraft.src.Block amethystBlock;
            public static net.minecraft.src.Block aluminumBlock;
            public static net.minecraft.src.Block osmiumBlock;
            public static net.minecraft.src.Block advandcedBlock;
            public static net.minecraft.src.Block eternalBlock;
            public static net.minecraft.src.Item Zinc;
            public static net.minecraft.src.Item Sulfur;
            public static net.minecraft.src.Item sulfurIngot;
            public static net.minecraft.src.Item zincIngot;
            public static net.minecraft.src.Item Rune;
            public static net.minecraft.src.Item runeIngot;
            public static net.minecraft.src.Item Amethyst;
            public static net.minecraft.src.Item amethystIngot;
            public static net.minecraft.src.Item Aluminum;
            public static net.minecraft.src.Item aluminumIngot;
            public static net.minecraft.src.Item Osmium;
            public static net.minecraft.src.Item osmiumIngot;
            public static net.minecraft.src.Item compressedOsmium;
            public static net.minecraft.src.Item compressedAluminum;
            public static net.minecraft.src.Item compressedAmethyst;
            public static net.minecraft.src.Item amethystSword;
            public static net.minecraft.src.Item amethystShovel;
            public static net.minecraft.src.Item amethystPick;
            public static net.minecraft.src.Item amethystAxe;
            public static net.minecraft.src.Item osmiumSword;
            public static net.minecraft.src.Item osmiumShovel;
            public static net.minecraft.src.Item osmiumPick;
            public static net.minecraft.src.Item osmiumAxe;
            public static net.minecraft.src.Item runeSword;
            public static net.minecraft.src.Item runeShovel;
            public static net.minecraft.src.Item runePick;
            public static net.minecraft.src.Item runeAxe;
            public static net.minecraft.src.Item eternalSword;
            public static net.minecraft.src.Item eternalShovel;
            public static net.minecraft.src.Item eternalPick;
            public static net.minecraft.src.Item eternalAxe;
            public static net.minecraft.src.Item eternalRune;
            public static net.minecraft.src.Item eternalFragment;
            public static net.minecraft.src.Item eternalHalf1;
            public static net.minecraft.src.Item eternalHalf2;
            public static net.minecraft.src.Item compressedFragment;
            public static net.minecraft.src.Item blastedFragment;
            public static net.minecraft.src.Item compressedZinc;
            public static net.minecraft.src.Item compressedSulfur;
            public static net.minecraft.src.Item compressedRune;
            public static net.minecraft.src.Item eternalHelmet;
            public static net.minecraft.src.Item eternalChest;
            public static net.minecraft.src.Item eternalBoots;
            public static net.minecraft.src.Item eternalLeggs;
            public static net.minecraft.src.Block blastFurnace;
            public static net.minecraft.src.Block impactCrusher;
            public static net.minecraft.src.Block rockCrusher;
            public static net.minecraft.src.Block compressor;
            public static net.minecraft.src.Block eternalCompressor;
            public static int blastFurnaceID;
            public static int rockCrusherID;
            public static int impactCrusherID;
            public static int compressorID;
            public static int eternalCompressorID;
            public static int osmiumOreID;
            public static int osmiumBlockID;
            public static int aluminumOreID;
            public static int aluminumBlockID;
            public static int amethystOreID;
            public static int amethystBlockID;
            public static int runeOreID;
            public static int runeBlockID;
            public static int sulfurOreID;
            public static int sulfurBlockID;
            public static int zincOreID;
            public static int zincBlockID;

}
