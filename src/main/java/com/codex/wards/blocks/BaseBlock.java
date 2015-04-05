package com.codex.wards.blocks;

import com.codex.wards.WardsMain;
import com.sun.xml.internal.ws.assembler.dev.ServerTubelineAssemblyContext;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BaseBlock extends Block {

	protected BaseBlock(Material materialIn) {
		super(materialIn);
	}
	
	public BaseBlock(Material material, String name) {
		super(material);
		setupBlock(name);
	}
	
	public BaseBlock(String name) {
		super(Material.rock);
		setupBlock(name);
	}
	
	public void setupBlock(String name){
		setUnlocalizedName(name);
		setCreativeTab(WardsMain.mainTab);
		GameRegistry.registerBlock(this, name);
		registerRecipe();
	}
	
	public void registerRecipe(){
		
	}

}
