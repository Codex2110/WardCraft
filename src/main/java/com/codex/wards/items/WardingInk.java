package com.codex.wards.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WardingInk extends BaseItem {
	
	public WardingInk(String name) {
		super(name);
	}
	
	@Override
	public void registerRecipe() {
		ItemStack black, red, green, brown, lapis, purple, cyan, lGray, pink, lime, yellow, lBlue, magenta, orange, white;
		
		black = new ItemStack(Items.dye, 1,0);
		red = new ItemStack(Items.dye, 1,1);
		green = new ItemStack(Items.dye, 1,2);
		brown = new ItemStack(Items.dye, 1,3);
		lapis = new ItemStack(Items.dye, 1,4);
		purple = new ItemStack(Items.dye, 1,5);
		cyan = new ItemStack(Items.dye, 1,6);
		lGray = new ItemStack(Items.dye, 1,8);
		pink = new ItemStack(Items.dye, 1,9);
		lime = new ItemStack(Items.dye, 1,10);
		yellow = new ItemStack(Items.dye, 1,11);
		lBlue = new ItemStack(Items.dye, 1,12);
		magenta = new ItemStack(Items.dye, 1,13);
		orange = new ItemStack(Items.dye, 1,14);
		white = new ItemStack(Items.dye, 1,15);
		
		ItemStack[] dyes = {black, red, green, brown, lapis, purple, cyan, lGray, pink, lime, yellow, lBlue, magenta, orange, white};
		ItemStack redStone = new ItemStack(Items.redstone);
		
		for(int i = 0; i< dyes.length;i++){
			GameRegistry.addShapelessRecipe(new ItemStack(this), redStone, dyes[i]);
		}
	}

}
