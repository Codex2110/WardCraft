package com.codex.wards.blocks;

import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static BaseBlock testBlock;
	
	public static void registerBlocks(){
		testBlock = new BaseBlock(Material.rock, "testBlock");
	}

}
