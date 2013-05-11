package Mod_OsmiCraft;

import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
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
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalBoots;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalChest;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalHelmet;
import Mod_OsmiCraft.Items.Weapons.Eternal.eternalLegs;
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
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "OsmiCraft", name = "OsmiCraft", version = "0.0.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = { "mod_OsmiCraft" }, packetHandler = OsmiCraft.client.ClientPacketHandler.class), serverPacketHandlerSpec = @SidedPacketHandler(channels = { "mod_OsmiCraft" }, packetHandler = OsmiCraft.Common.ServerPacketHandler.class))
public class core {
	
	@SidedProxy(clientSide = "OsmiCraft.client.ClientProxyRender", serverSide = "OsmiCraft.Common.CommonProxyRender")
	public static CommonProxyRender proxy;
	@Instance
	public static core instance = new core();
	private guiHandler guiHandler = new guiHandler();
	static EnumArmorMaterial EternalArmor = EnumHelper.addArmorMaterial("EternalArmor", 35, new int[]{999,999,999,999}, 0);
	static EnumToolMaterial EternalMaterial = EnumHelper.addToolMaterial("EternalMaterial", 3, 0, 20F, 12, 14);
	static EnumToolMaterial AmethystMaterial = EnumHelper.addToolMaterial("AmethystMaterial", 3, 400, 8F, 3, 14);
	static EnumToolMaterial OsmiumMaterial = EnumHelper.addToolMaterial("OsmiumMaterial", 3, 999, 10F, 4, 14);
	static EnumToolMaterial RuneMaterial = EnumHelper.addToolMaterial("RuneMaterial", 3, 400, 9F, 3, 14);

	/**
	 * BLocks
	 */

	public static Block zincOre;
	public static Block sulfurOre;
	public static Block runiteOre;
	public static Block amethystOre;
	public static Block aluminumOre;
	public static Block osmiumOre;
	public static Block zincBlock;
	public static Block sulfurBlock;
	public static Block runiteBlock; 
	public static Block amethystBlock;
	public static Block aluminumBlock;
	public static Block osmiumBlock; 
	public static Block advandcedBlock;
	public static Block eternalBlock;
	

	
	
	/**
	 * Items
	 */
	public static Item Zinc;
	public static Item Sulfur;
	public static Item sulfurIngot;
	public static Item zincIngot;
	public static Item Rune;
	public static Item runeIngot;
	public static Item Amethyst;
	public static Item amethystIngot;
	public static Item Aluminum;
	public static Item aluminumIngot;
	public static Item Osmium;
	public static Item osmiumIngot;
	public static Item compressedOsmium;
	public static Item compressedAluminum;
	public static Item compressedAmethyst;
	public static Item amethystSword;
	public static Item amethystShovel;
	public static Item amethystPick;
	public static Item amethystAxe;
	public static Item osmiumSword;
	public static Item osmiumShovel;
	public static Item osmiumPick;
	public static Item osmiumAxe;
	public static Item runeSword;
	public static Item runeShovel;
	public static Item runePick;
	public static Item runeAxe;
	public static Item eternalSword;
	public static Item eternalShovel;
	public static Item eternalPick;
	public static Item eternalAxe;
	public static Item eternalRune;
	public static Item eternalFragment;
	public static Item eternalHalf1;
	public static Item eternalHalf2;
	public static Item compressedFragment;
	public static Item blastedFragment;
	public static Item compressedZinc;
	public static Item compressedSulfur;
	public static Item compressedRune;
	public static Item eternalHelmet;
	public static Item eternalChest;
	public static Item eternalBoots;
	public static Item eternalLeggs;

	/**
	 * Machines
	 * 
	 */
	public static Block blastFurnace;
	public static Block impactCrusher;
	public static Block rockCrusher;
	public static Block compressor;
	public static Block eternalCompressor;
	/**
	 * config ints
	 */
	public static int blastFurnaceID;
	public static int rockCrusherID;;
	public static int impactCrusherID;;
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
	
	
	
     
	@PreInit
    public void preInit(FMLPreInitializationEvent event) {
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            config.load();
            blastFurnaceID = config.getBlock("Blast Furnace", 1140).getInt();
            rockCrusherID = config.getBlock("Rock Crusher", 1141).getInt();
            impactCrusherID = config.getBlock("Impact Crusher", 1142).getInt();
            compressorID = config.getBlock("Compressor", 1143).getInt();
            eternalCompressorID = config.getBlock("Eternal Compressor", 1144).getInt();
            osmiumBlockID = config.getBlock("Osmium Block", 1151).getInt();
            aluminumBlockID = config.getBlock("Aluminum Block", 1152).getInt();
            amethystBlockID = config.getBlock("Amethyst Block", 1153).getInt();
            runeBlockID = config.getBlock("Rune Block", 1154).getInt();
            sulfurBlockID = config.getBlock("Sulfur Block", 1155).getInt();
            zincBlockID = config.getBlock("Zinc Block", 1156).getInt();
            config.save();
    }
	
	
	@Init
	public void load(FMLInitializationEvent event) {
		
		
		
		
		
		
		/**
		 * OreGen
		 */
		GameRegistry.registerWorldGenerator(new OsmiCraftGeneration());
		/**
		 * Items
		 */
		Zinc = new ZincItem(1550).setIconIndex(0).setItemName("Zinc");
		zincIngot = new zincIngot(1551).setIconIndex(16).setItemName("ZincIngot");
		Sulfur = new SulfurItem(1552).setIconIndex(1).setItemName("Sulfur");
		sulfurIngot = new SulfurIngotItem(1553).setIconIndex(17).setItemName("SulfurIngot");
		Rune = new RuneItem(1554).setIconIndex(2).setItemName("Rune");
		runeIngot = new runeIngot(1555).setIconIndex(18).setItemName("RuneIngot");
		Amethyst = new AmethystItem(1556).setIconIndex(3).setItemName("Amythyst");
		amethystIngot = new amethystIngot(1557).setIconIndex(19).setItemName("AmethystIngot");
		Aluminum = new AluminumItem(1558).setIconIndex(4).setItemName("Aluminum");
		aluminumIngot = new aluminumIngot(1559).setIconIndex(20).setItemName("AluminumIngot");
		Osmium = new OsmiumItem(1560).setIconIndex(5).setItemName("Osmium");
		osmiumIngot = new osmiumIngot(1561).setIconIndex(21).setItemName("OsmiumIngot");
		compressedZinc = new compressedItem(1562).setIconIndex(32).setItemName("CompressedZinc");
		compressedSulfur = new compressedItem(1563).setIconIndex(33).setItemName("CompressedSulfur");
		compressedRune = new compressedItem(1564).setIconIndex(34).setItemName("CompressedRune");
		compressedAmethyst = new compressedItem(1565).setIconIndex(35).setItemName("CompressedAmethyst");
		compressedAluminum = new compressedItem(1566).setIconIndex(36).setItemName("CompressedAluminum");
		compressedOsmium = new compressedItem(1567).setIconIndex(37).setItemName("CompressedOsmium");
		amethystSword = new amethystSword(1568, AmethystMaterial).setIconIndex(131).setItemName("amethystSword"); 
		amethystShovel = new amethystShovel(1569, AmethystMaterial).setIconIndex(147).setItemName("amethystShovel");
		amethystPick = new amethystPick(1570, AmethystMaterial).setIconIndex(163).setItemName("amethystPick");
		amethystAxe = new amethystAxe(1571, AmethystMaterial).setIconIndex(179).setItemName("amethystAxe");
		osmiumSword = new osmiumSword(1572, OsmiumMaterial).setIconIndex(130).setItemName("osmiumSword");
		osmiumShovel = new osmiumShovel(1573, OsmiumMaterial).setIconIndex(146).setItemName("osmiumShovel"); 
		osmiumPick = new osmiumPick(1574, OsmiumMaterial).setIconIndex(162).setItemName("osmiumPick"); 
		osmiumAxe = new osmiumAxe(1575, OsmiumMaterial).setIconIndex(178).setItemName("osmiumAxe"); 
		runeSword = new runeSword(1576, RuneMaterial).setIconIndex(129).setItemName("runeSword");
		runeShovel = new runeShovel(1577, RuneMaterial).setIconIndex(145).setItemName("runeShovel"); 
		runePick = new runePick(1578, RuneMaterial).setIconIndex(161).setItemName("runePick"); 
		runeAxe = new runeAxe(1579, RuneMaterial).setIconIndex(177).setItemName("runeAxe"); 
		eternalRune = new eternalRune(1580).setIconIndex(66).setItemName("eternalRune"); 
		eternalFragment = new eternalFragment(1581).setIconIndex(65).setItemName("eternalFragment"); 
		eternalHalf1 = new eternalHalf1(1582).setIconIndex(82).setItemName("eternalHalf1"); 
		eternalHalf2 = new eternalHalf2(1583).setIconIndex(98).setItemName("eternalHalf2");
		blastedFragment = new compressedFragment(1584).setIconIndex(81).setItemName("blastedFragment"); 
		compressedFragment = new blastedFragment(1585).setIconIndex(97).setItemName("compressedFragment"); 
		
		
		/**
		 * Eternal
		 */
		eternalHelmet = new eternalHelmet(1577, EternalArmor, ModLoader.addArmor("EternalHelmet"),0).setItemName("EternalHelment").setIconIndex(64); 
		eternalChest = new eternalChest(1578, EternalArmor,  ModLoader.addArmor("EternalChest"),1).setItemName("EternalChest").setIconIndex(80); 
		eternalLeggs = new eternalLegs(1579, EternalArmor,  ModLoader.addArmor("EternalLegs"),2).setItemName("EternalLegs").setIconIndex(96); 
		eternalBoots = new eternalBoots(1580, EternalArmor, ModLoader.addArmor("EternalBoots"),3).setItemName("EternalBoots").setIconIndex(112); 
		eternalSword = new eternalSword(1586, EternalMaterial).setIconIndex(128).setItemName("eternalSword");
		eternalShovel = new eternalShovel(1587, EternalMaterial).setIconIndex(144).setItemName("eternalShovel"); 
		eternalPick = new eternalPick(1588, EternalMaterial).setIconIndex(160).setItemName("eternalPick"); 
		eternalAxe = new eternalAxe(1589, EternalMaterial).setIconIndex(176).setItemName("eternalAxe"); 
		/**
		 * Blocks
		 */
		zincOre = new ZincOre(1150, 0).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Zinc_Ore");
		sulfurOre = new SulfurOre(1149, 1).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Sulfur_Ore");
		runiteOre = new RuniteOre(1148, 2).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Runite_Ore");
		amethystOre = new AmythestOre(1147, 3).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Amethyst_Ore");
		aluminumOre = new AluminumOre(1146, 4).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Aluminum_Ore");
		osmiumOre = new OsmiumOre(1145, 5).setStepSound(Block.soundStoneFootstep).setHardness(10F).setResistance(10.0F).setBlockName("Osmium_Ore");
		zincBlock = new ZincBlock(zincBlockID, 16).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Zinc_Block");
		sulfurBlock = new SulfurBlock(sulfurBlockID, 17).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Sulfur_Block");
		runiteBlock = new RuneBlock(runeBlockID, 18).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Runite_Block");
		amethystBlock = new AmethystBlock(amethystBlockID, 19).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Amethyst_Block");
		aluminumBlock = new AluminumBlock(aluminumBlockID, 20).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("Aluminum_Block");
		osmiumBlock = new OsmiumBlock(osmiumBlockID, 21).setStepSound(Block.soundStoneFootstep).setHardness(10F).setResistance(10.0F).setBlockName("Osmium_Block");
		advandcedBlock = new OsmiumBlock(1659, 22).setStepSound(Block.soundStoneFootstep).setHardness(10F).setResistance(10.0F).setBlockName("Advandced_Block");
		eternalBlock = new OsmiumBlock(1660, 23).setStepSound(Block.soundStoneFootstep).setHardness(10F).setResistance(10.0F).setBlockName("Eternal_Block");
		MinecraftForge.setBlockHarvestLevel(zincOre, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(sulfurOre, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(runiteOre, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(amethystOre, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(aluminumOre, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(osmiumOre, 0, "pickaxe", 3);
		/** 
		 * GameRegestry
		 */
		GameRegistry.registerBlock(zincOre);
		GameRegistry.registerBlock(sulfurOre);
		GameRegistry.registerBlock(runiteOre);
		GameRegistry.registerBlock(amethystOre);
		GameRegistry.registerBlock(aluminumOre);
		GameRegistry.registerBlock(osmiumOre);
		GameRegistry.registerBlock(zincBlock);
		GameRegistry.registerBlock(sulfurBlock);
		GameRegistry.registerBlock(runiteBlock);
		GameRegistry.registerBlock(amethystBlock);
		GameRegistry.registerBlock(aluminumBlock);
		GameRegistry.registerBlock(osmiumBlock);
		GameRegistry.registerBlock(advandcedBlock);
		GameRegistry.registerBlock(eternalBlock);
		
		
		GameRegistry.registerTileEntity(BlastFurnaceEntity.class,"BlastFurnaceEntity");
		GameRegistry.registerTileEntity(CrusherEntity.class,"CrusherEntity");
		GameRegistry.registerTileEntity(ImpactCrusherEntity.class,"ImpactCrusherEntity");
		GameRegistry.registerTileEntity(CompressorEntity.class,"CompressorEntity");
		GameRegistry.registerTileEntity(EternalCompressorEntity.class,"EternalCompressorEntity");

		/**
		 * Blocks that do things
		 */
		
		blastFurnace = new BlastFurnace(blastFurnaceID).setHardness(3F).setBlockName("Blast_Furnace");
		impactCrusher = new impactCrusher(impactCrusherID).setHardness(3F).setBlockName("Impact_Crusher");
		rockCrusher = new rockCrusher(rockCrusherID).setHardness(3F).setBlockName("Rock_Crusher");
		compressor = new compressor(compressorID).setHardness(3F).setBlockName("Compressor");
		eternalCompressor = new eternalCompressor(eternalCompressorID).setHardness(3F).setBlockName("Eternal_Compressor");
		
		/**
		 * Weapon Recipies
		 */ 
		
		GameRegistry.addRecipe(new ItemStack(this.eternalFragment, 1),
				new Object[] { "OAO", "MDM", "OAO", 'O', this.compressedOsmium, 'A',
						this.compressedAluminum, 'M', this.compressedAmethyst, 'D', Item.diamond });
		GameRegistry.addRecipe(new ItemStack(this.eternalHalf1, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', compressedFragment });
		GameRegistry.addRecipe(new ItemStack(this.eternalHalf2, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', blastedFragment });
		GameRegistry.addShapelessRecipe(new ItemStack(this.eternalRune, 1 ),
				new Object[] {new ItemStack(this.eternalHalf1 , 1), new ItemStack(this.eternalHalf2, 1)});
		//Amethyst
		GameRegistry.addRecipe(new ItemStack(this.amethystAxe, 1),
				new Object[] { "XXB", "XSB", "BSB", 'X', amethystIngot, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.amethystSword, 1),
				new Object[] { "BXB", "BXB", "BSB", 'X', amethystIngot, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.amethystShovel, 1),
				new Object[] { "BXB", "BSB", "BSB", 'X', amethystIngot, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.amethystPick, 1),
				new Object[] { "XXX", "BSB", "BSB", 'X', amethystIngot, 'S' , Item.stick });
		//Rune
		GameRegistry.addRecipe(new ItemStack(this.runeAxe, 1),
				new Object[] { "XXB", "XSB", "BSB", 'X', runeIngot, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.runeSword, 1),
				new Object[] { "BXB", "BXB", "BSB", 'X', runeIngot, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.runeShovel, 1),
				new Object[] { "BXB", "BSB", "BSB", 'X', runeIngot, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.runePick, 1),
				new Object[] { "XXX", "BSB", "BSB", 'X', runeIngot, 'S' , Item.stick });
		//Osmium
		GameRegistry.addRecipe(new ItemStack(this.osmiumAxe, 1),
				new Object[] { "XXB", "XSB", "BSB", 'X', osmiumBlock, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.osmiumSword, 1),
				new Object[] { "BXB", "BXB", "BSB", 'X', osmiumBlock, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.osmiumShovel, 1),
				new Object[] { "BXB", "BSB", "BSB", 'X', osmiumBlock, 'S' , Item.stick });
		GameRegistry.addRecipe(new ItemStack(this.osmiumPick, 1),
				new Object[] { "XXX", "BSB", "BSB", 'X', osmiumBlock, 'S' , Item.stick });
		
		
		
		/**
		 * BlockRecipies
		 */

		GameRegistry.addRecipe(new ItemStack(this.zincBlock, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', zincIngot });
		GameRegistry.addRecipe(new ItemStack(this.sulfurBlock, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', sulfurIngot });
		GameRegistry.addRecipe(new ItemStack(this.runiteBlock, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', runeIngot });
		GameRegistry.addRecipe(new ItemStack(this.amethystBlock, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', amethystIngot });
		GameRegistry.addRecipe(new ItemStack(this.aluminumBlock, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', aluminumIngot });
		GameRegistry.addRecipe(new ItemStack(this.osmiumBlock, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', osmiumIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(this.osmiumIngot, 9 ),
				new Object[] {new ItemStack( this.osmiumBlock ,1)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(this.aluminumIngot, 9 ),
				new Object[] {new ItemStack( this.aluminumBlock ,1)});
		GameRegistry.addShapelessRecipe(new ItemStack(this.zincIngot, 9 ),
				new Object[] {new ItemStack( this.zincBlock ,1)});
		GameRegistry.addShapelessRecipe(new ItemStack(this.sulfurIngot, 9 ),
				new Object[] {new ItemStack( this.sulfurBlock ,1)});
		GameRegistry.addShapelessRecipe(new ItemStack(this.runeIngot, 9 ),
				new Object[] {new ItemStack( this.runiteBlock ,1)});
		GameRegistry.addShapelessRecipe(new ItemStack(this.amethystIngot, 9 ),
				new Object[] {new ItemStack( this.amethystBlock ,1)});
		//MachineRecepies
		
		GameRegistry.addRecipe(new ItemStack(this.blastFurnace, 1),
				new Object[] { "XXX", "XZX", "XXX", 'X', Block.blockSteel, 'Z',
						Block.stoneOvenIdle });
		GameRegistry.addRecipe(new ItemStack(this.rockCrusher, 1),
				new Object[] { "SFS", "SPS", "SLS", 'S', Block.stone, 'F',
						Block.stoneOvenIdle, 'P' , Block.pistonBase, 'L', Block.pressurePlateStone });
		
		GameRegistry.addRecipe(new ItemStack(this.impactCrusher, 1),
				new Object[] { "SFS", "SPS", "SLS", 'S', aluminumBlock, 'F',
			Block.pressurePlateStone, 'P' , this.rockCrusher, 'L', Item.bucketLava });
		
		GameRegistry.addRecipe(new ItemStack(this.compressor, 1),
				new Object[] { "SFS", "SPS", "SSS", 'S', aluminumBlock, 'F',
			this.impactCrusher, 'P' , this.blastFurnace });
		GameRegistry.addRecipe(new ItemStack(this.eternalCompressor, 1),
				new Object[] { "XXX", "XZX", "XXX", 'X', this.eternalBlock, 'Z',
						this.compressor });
		GameRegistry.addRecipe(new ItemStack(this.advandcedBlock, 1),
				new Object[] { "OZO", "SAS", "OZO", 'O', this.compressedOsmium, 'Z',
						this.compressedZinc, 'S' , this.compressedSulfur, 'A', this.aluminumBlock });
		GameRegistry.addRecipe(new ItemStack(this.eternalBlock, 1),
				new Object[] { "XXX", "XZX", "XXX", 'X', this.eternalRune, 'Z',
						this.advandcedBlock });
		
		
		
		
		
		
		
		/**
		 * Generation
		 */
		
		GameRegistry.registerBlock(blastFurnace);
		GameRegistry.registerBlock(impactCrusher);
		GameRegistry.registerBlock(rockCrusher);
		GameRegistry.registerBlock(compressor);
		GameRegistry.registerBlock(eternalCompressor);
		/**
		 * LanguageRegestry
		 */
		LanguageRegistry.addName(Zinc, "Zinc");
		LanguageRegistry.addName(zincOre, "Zinc Ore");
		LanguageRegistry.addName(sulfurOre, "Sulfur Ore");
		LanguageRegistry.addName(Sulfur, "Sulfur");
		LanguageRegistry.addName(sulfurIngot, "Sulfur Ingot");
		LanguageRegistry.addName(runiteOre, "Rune Ore");
		LanguageRegistry.addName(amethystOre, "Amethyst Ore");
		LanguageRegistry.addName(aluminumOre, "Aluminum Ore");
		LanguageRegistry.addName(blastFurnace, "Blast Furnace");
		LanguageRegistry.addName(osmiumOre, "Osmium Ore");
		LanguageRegistry.addName(Amethyst, "Amethyst");
		LanguageRegistry.addName(amethystIngot, "Amethyst Ingot");
		LanguageRegistry.addName(Rune, "Rune");
		LanguageRegistry.addName(runeIngot, "Rune Ingot");
		LanguageRegistry.addName(Osmium, "Osmium");
		LanguageRegistry.addName(osmiumIngot, "Osmium Ingot");
		LanguageRegistry.addName(Aluminum, "Aluminum");
		LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
		LanguageRegistry.addName(zincIngot, "Zinc Ingot");
		LanguageRegistry.addName(impactCrusher, "Impact Crusher");
		LanguageRegistry.addName(rockCrusher, "Rock Crusher");
		LanguageRegistry.addName(zincBlock, "Zinc Block");
		LanguageRegistry.addName(sulfurBlock, "Sulfur Block");
		LanguageRegistry.addName(aluminumBlock, "Aluminum Block");
		LanguageRegistry.addName(runiteBlock, "Rune Block");
		LanguageRegistry.addName(amethystBlock, "Amethyst Block");
		LanguageRegistry.addName(osmiumBlock, "Osmium Block");
		LanguageRegistry.addName(compressor, "Compressor");
		LanguageRegistry.addName(compressedAmethyst, "Compressed Amethyst");
		LanguageRegistry.addName(compressedAluminum, "Compressed Aluminum");
		LanguageRegistry.addName(compressedOsmium, "Compressed Osmium");
		LanguageRegistry.addName(amethystSword, "Amethyst Sword");
		LanguageRegistry.addName(amethystShovel, "Amethyst Shovel");
		LanguageRegistry.addName(amethystPick, "Amethyst PickAxe");
		LanguageRegistry.addName(amethystAxe, "Amethyst Axe");
		LanguageRegistry.addName(osmiumSword, "Osmium Sword");
		LanguageRegistry.addName(osmiumShovel, "Osmium Shovel");
		LanguageRegistry.addName(osmiumPick, "Osmium Pick");
		LanguageRegistry.addName(osmiumAxe, "Osmium Axe");
		LanguageRegistry.addName(runeSword, "Rune Sword");
		LanguageRegistry.addName(runeShovel, "Rune Shovel");
		LanguageRegistry.addName(runePick, "Rune Pick");
		LanguageRegistry.addName(runeAxe, "Rune Axe");
		LanguageRegistry.addName(eternalSword, "\u00a74Eternal Sword");
		LanguageRegistry.addName(eternalShovel, "\u00a74Eternal Shovel");
		LanguageRegistry.addName(eternalPick, "\u00a74Eternal PickAxe");
		LanguageRegistry.addName(eternalAxe, "\u00a74Eternal Axe");
		LanguageRegistry.addName(eternalRune, "\u00a74Eternal Rune");
		LanguageRegistry.addName(eternalFragment, "Eternal Rune Fragment");
		LanguageRegistry.addName(eternalHalf1, "Eternal Half");
		LanguageRegistry.addName(eternalHalf2, "Eternal Half");
		LanguageRegistry.addName(compressedFragment, "Compressed Fragment");
		LanguageRegistry.addName(blastedFragment, "Blasted Fragment");
		LanguageRegistry.addName(eternalCompressor, "\u00a74Eternal Compressor");
		LanguageRegistry.addName(compressedSulfur, "Compressed Sulfur");
		LanguageRegistry.addName(compressedZinc, "Compressed Zinc");
		LanguageRegistry.addName(compressedRune, "Compressed Rune");
		LanguageRegistry.addName(eternalBlock, "\u00a74Eternal Block");
		LanguageRegistry.addName(advandcedBlock, "\u00a79Advandced Block"); 
		LanguageRegistry.addName(eternalHelmet, "Eternal Helmet");
		LanguageRegistry.addName(eternalChest, "Eternal Chestplate");
		LanguageRegistry.addName(eternalLeggs, "Eternal Leggs");
		LanguageRegistry.addName(eternalBoots, "Eternal Boots");
	
		
		/** 
		 * Proxy
		 */
		proxy.registerRenderThings();
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
	}

}
