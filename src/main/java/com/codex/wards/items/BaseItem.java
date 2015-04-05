package com.codex.wards.items;

import com.codex.wards.WardsMain;
import com.sun.xml.internal.ws.assembler.dev.ServerTubelineAssemblyContext;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BaseItem extends Item {

	protected BaseItem() {
	}
	
	public BaseItem(String name) {
		setupItem(name);
	}
	
	public void setupItem(String name){
		setUnlocalizedName(name);
		setCreativeTab(WardsMain.mainTab);
		GameRegistry.registerItem(this, name);
		registerRecipe();
	}
	
	public void registerRecipe(){
		
	}

}
