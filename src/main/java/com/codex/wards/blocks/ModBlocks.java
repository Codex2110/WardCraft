package com.codex.wards.blocks;

import net.minecraft.block.material.Material;

import com.codex.wards.blocks.wards.KeyWard;
import com.codex.wards.blocks.wards.MajorWard;
import com.codex.wards.blocks.wards.RangeMultiplierWard;

public class ModBlocks {
	
	public static BaseBlock testBlock;
	
	public static MajorWard earth, fire, water, air, metal, light, darkness, growth, decay;
	public static KeyWard key;
	public static RangeMultiplierWard power;
	
	public static void registerBlocks(){
		testBlock = new BaseBlock(Material.rock, "testBlock");
		key = new KeyWard("key", new String[]{"x x","xx ","x x"});
		power = new RangeMultiplierWard("power", new String[]{"x x"," x ","x x"});
	}

}
