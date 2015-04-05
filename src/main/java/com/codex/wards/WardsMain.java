package com.codex.wards;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.codex.wards.proxy.CommonProxy;

@Mod(modid = MainHelper.MODID, name = MainHelper.NAME, version = MainHelper.VERSION)
public class WardsMain {
	
	@Instance(MainHelper.MODID)
	public static WardsMain instance;
	
	@SidedProxy(clientSide=MainHelper.CLIENT, serverSide=MainHelper.COMMON)
	public static CommonProxy proxy;
	
	public static final WardsTab mainTab = new WardsTab(CreativeTabs.getNextID(), MainHelper.TABNAME);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
