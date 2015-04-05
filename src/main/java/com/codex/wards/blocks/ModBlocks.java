package com.codex.wards.blocks;

import net.minecraft.block.material.Material;

import com.codex.wards.blocks.wards.KeyWard;
import com.codex.wards.blocks.wards.MajorWard;
import com.codex.wards.blocks.wards.RangeMultiplierWard;

public class ModBlocks {
	
	public static BaseBlock testBlock;
	
	public static MajorWard earth, fire, water, air, metal, light, darkness, growth, decay, player, mob, animal, plant, transfer;
	public static KeyWard key;
	public static RangeMultiplierWard power;
	
	public static void registerBlocks(){
		testBlock = new BaseBlock(Material.rock, "testBlock");
		key = new KeyWard("key", new String[]{"x x","xx ","x x"});
		power = new RangeMultiplierWard("power", new String[]{"x x"," x ","x x"});
		earth = new MajorWard("earth", new String[]{"xxx","x x","xxx"});
		fire = new MajorWard("fire", new String[]{"x x","x x","xxx"});
		water = new MajorWard("water", new String[]{" x ","x x","xxx"});
		air = new MajorWard("air", new String[]{" x ","x x"," x "});
		metal = new MajorWard("metal", new String[]{"xxx","xxx","xxx"});
		light = new MajorWard("light", new String[]{" x ","xxx"," x "});
		darkness = new MajorWard("darkness", new String[]{"   ","xxx","   "});
		growth = new MajorWard("growth", new String[]{" x "," x ","xxx"});
		decay = new MajorWard("decay", new String[]{"   ","   ","xxx"});
		player = new MajorWard("player", new String[]{"xx ","xx ","x  "});
		mob = new MajorWard("mob", new String[]{"  x"," x ","x  "});
		animal = new MajorWard("animal", new String[]{"x  "," x ","  x"});
		plant = new MajorWard("plant", new String[]{" x ","xxx","xxx"});
		transfer = new MajorWard("transfer", new String[]{"xxx"," x "," x "});


	}

}
