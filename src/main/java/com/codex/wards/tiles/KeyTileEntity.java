package com.codex.wards.tiles;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.codex.wards.blocks.wards.MajorWard;
import com.codex.wards.blocks.wards.RangeMultiplierWard;
import com.codex.wards.particles.LanguageMovingParticle;

public class KeyTileEntity extends TileEntity implements IUpdatePlayerListBox {
	
	private BlockPos corner1, corner2, corner3, corner4;
	private Iterator<BlockPos> blocks1, blocks2, blocks3, blocks4;
	private int range, ticks;
	
	public int getRange(){
		
		range = 0;
		
		BlockPos bottomCorner  = this.pos.add(-1, 0, -1);
		BlockPos topCorer = this.pos.add(1, 0, 1);
		
		Iterator<BlockPos> blockIterator = BlockPos.getAllInBox(topCorer, bottomCorner).iterator();
		
		while(blockIterator.hasNext()){
			if(worldObj.getBlockState(blockIterator.next()).getBlock() instanceof RangeMultiplierWard){
				range++;
			}
		}
		System.out.println(range);
		return (int) Math.pow(2, range-1);
	}

	@Override
	public void update() {
		ticks++;
		
		if(ticks > 20){
			int newRange = getRange();
			corner1 = this.pos.add(newRange, 0, newRange);
			corner2 = this.pos.add(-newRange, 0, newRange);
			corner3 = this.pos.add(-newRange, 0, -newRange);
			corner4 = this.pos.add(newRange, 0, -newRange);
			
			if(allCornersAreWardBlocks()){
				
			}
			
			if(worldObj.isRemote){
				blocks1 = BlockPos.getAllInBox(corner1, corner2).iterator();
				blocks2 = BlockPos.getAllInBox(corner2, corner3).iterator();
				blocks3 = BlockPos.getAllInBox(corner3, corner4).iterator();
				blocks4 = BlockPos.getAllInBox(corner4, corner1).iterator();
			}
			
			ticks = 0;
		}
		
		if(blocks1!=null && corner1!=null){
			spawnParticlesFromIterator(blocks1, corner1, corner2);
			spawnParticlesFromIterator(blocks2, corner2, corner3);
			spawnParticlesFromIterator(blocks3, corner3, corner4);
			spawnParticlesFromIterator(blocks4, corner4, corner1);
		}
		
	}
	
	private void spawnParticlesFromIterator(Iterator<BlockPos> blocks, BlockPos start, BlockPos end){
		while(blocks.hasNext()){
			BlockPos pos = blocks.next();
			spawnParticles(worldObj, pos, start, end);
		}
	}
	
	private void spawnParticles(World world, BlockPos pos, BlockPos start, BlockPos end){
		Random random = world.rand;
		EntityFX letters = new LanguageMovingParticle(world, pos.getX()+random.nextFloat(), pos.getY()+random.nextFloat(), pos.getZ()+random.nextFloat(), 0, 0, 0, start, end);
		Minecraft.getMinecraft().effectRenderer.addEffect(letters);
	}
	
	private boolean allCornersAreWardBlocks(){
		boolean allCornersAreWardBlocks = true;
		
		if(!(worldObj.getBlockState(corner1) instanceof MajorWard)){
			allCornersAreWardBlocks = false;
		}
		if(!(worldObj.getBlockState(corner2) instanceof MajorWard)){
			allCornersAreWardBlocks = false;
		}
		if(!(worldObj.getBlockState(corner3) instanceof MajorWard)){
			allCornersAreWardBlocks = false;
		}
		if(!(worldObj.getBlockState(corner4) instanceof MajorWard)){
			allCornersAreWardBlocks = false;
		}
		
		return allCornersAreWardBlocks;
		
		
	}

}
