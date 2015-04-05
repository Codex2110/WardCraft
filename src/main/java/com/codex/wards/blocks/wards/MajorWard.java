package com.codex.wards.blocks.wards;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.codex.wards.blocks.BaseBlock;
import com.codex.wards.items.ModItems;

public class MajorWard extends BaseBlock {

	public MajorWard(Material material, String name) {
		super(material, name);
		// TODO Auto-generated constructor stub
	}
	
	public MajorWard(String name, String[] recipe) {
		super(Material.vine, name);
		registerRecipe(name, recipe);
	}
	
	
	private void registerRecipe(String name, String[] recipe) {
		ItemStack wardingInk = new ItemStack(ModItems.ink);
		ItemStack majorWard = new ItemStack(this);
		majorWard.setTagCompound(new NBTTagCompound());
		majorWard.getTagCompound().setString("WardName", name);
		
		GameRegistry.addRecipe(majorWard, recipe[0], recipe[1], recipe[2], 'x', wardingInk);
	}
	

}
