package com.codex.wards.blocks.wards;

import com.codex.wards.MainHelper;
import com.codex.wards.WardsMain;
import com.codex.wards.items.ModItems;
import com.codex.wards.tiles.KeyTileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KeyWard extends BlockContainer {

	protected KeyWard(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}
	
	public KeyWard(String name, String[] recipe) {
		super(Material.vine);
		setupBlock(name);
		registerRecipe(name, recipe);
	}

	private void setupBlock(String name){
		setUnlocalizedName(MainHelper.MODID +"_"+name);
		setCreativeTab(WardsMain.mainTab);
		GameRegistry.registerBlock(this, name);
		GameRegistry.registerTileEntity(KeyTileEntity.class, MainHelper.MODID +"_"+"KeyTileEntity");
	}
	
	private void registerRecipe(String name, String[] recipe){
		ItemStack wardingInk = new ItemStack(ModItems.ink);
		ItemStack majorWard = new ItemStack(this);
		majorWard.setTagCompound(new NBTTagCompound());
		majorWard.getTagCompound().setString("WardName", name);
		
		GameRegistry.addRecipe(majorWard, recipe[0], recipe[1], recipe[2], 'x', wardingInk);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new KeyTileEntity();
	}
}
