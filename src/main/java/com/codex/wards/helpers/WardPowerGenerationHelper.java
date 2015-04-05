package com.codex.wards.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;

import com.codex.wards.tiles.KeyTileEntity;

public class WardPowerGenerationHelper {

	public static void actionPlantPower(KeyTileEntity tile, BlockPos corner1,
			BlockPos corner2) {
		Iterator<BlockPos> blockPos = BlockPos.getAllInBox(corner1, corner2)
				.iterator();
		Random random = tile.getWorld().rand;
		while (blockPos.hasNext()) {
			BlockPos currentBlockPos = blockPos.next();
			Block block = tile.getWorld().getBlockState(currentBlockPos)
					.getBlock();
			if (block instanceof IGrowable) {
				tile.getWorld().setBlockState(currentBlockPos,
						block.getDefaultState());
				tile.increasePower(1);
				if (tile.getWorld().isRemote) {
					if (random.nextFloat() >= 0.9f) {
						tile.getWorld().spawnParticle(
								EnumParticleTypes.EXPLOSION_NORMAL,
								currentBlockPos.getX() + random.nextFloat(),
								currentBlockPos.getY() + random.nextFloat(),
								currentBlockPos.getZ() + random.nextFloat(), 0,
								0, 0, new int[1]);
					}
				}
			}
		}
	}

	public static void actionPlayerPower(KeyTileEntity tile) {

		BlockPos tilePos = tile.getPos();
		int range = tile.getRange();

		AxisAlignedBB bb = new AxisAlignedBB(tilePos.add(-range, -2, -range),
				tilePos.add(range, 2, range));

		List<EntityPlayer> players = tile.getWorld().getEntitiesWithinAABB(
				EntityPlayer.class, bb, IEntitySelector.selectAnything);
		for (int i = 0; i < players.size(); i++) {
			EntityPlayer player = players.get(i);
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,
					300, 0));
			tile.increasePower(5);
		}
	}

	public static void actionMobPower(KeyTileEntity tile) {

		BlockPos tilePos = tile.getPos();
		int range = tile.getRange();

		AxisAlignedBB bb = new AxisAlignedBB(tilePos.add(-range, -2, -range),
				tilePos.add(range, 2, range));

		List<EntityMob> mobs = tile.getWorld().getEntitiesWithinAABB(
				EntityZombie.class, bb);
		for (int i = 0; i < mobs.size(); i++) {
			EntityMob mob = mobs.get(i);
			mob.attackEntityFrom(DamageSource.magic, mob.getMaxHealth() / 10);
			tile.increasePower(1);
		}
	}

	public static void actionAnimalPower(KeyTileEntity tile) {

		BlockPos tilePos = tile.getPos();
		int range = tile.getRange();

		AxisAlignedBB bb = new AxisAlignedBB(tilePos.add(-range, -2, -range),
				tilePos.add(range, 2, range));

		List<EntityAnimal> animals = tile.getWorld().getEntitiesWithinAABB(
				EntityAnimal.class, bb);
		for (int i = 0; i < animals.size(); i++) {
			EntityAnimal animal = animals.get(i);
			animal.setGrowingAge(-1000);
			tile.increasePower(1);
		}
	}

}
