package com.codex.wards.helpers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.codex.wards.tiles.KeyTileEntity;

public class WardNetHelper {

	public static void decideAction(KeyTileEntity tile) {
		List<BlockPos> cornerPos = tile.getCorners();
		List<String> cornerBlocks = new LinkedList<String>();
		World world = tile.getWorld();

		for (int i = 0; i < cornerPos.size(); i++) {
			String unlocalizedName = world.getBlockState(cornerPos.get(i))
					.getBlock().getUnlocalizedName();
			cornerBlocks.add(unlocalizedName.substring(11,
					unlocalizedName.length()));
		}

		if (listContains(cornerBlocks, "earth", "water", "light", "growth")) {
			actionGrowth(tile, cornerPos.get(0), cornerPos.get(2));
		}

	}

	public static void actionGrowth(KeyTileEntity tile, BlockPos corner1,
			BlockPos corner2) {
		Iterator<BlockPos> blockPos = BlockPos.getAllInBox(corner1, corner2)
				.iterator();
		Random random = tile.getWorld().rand;
		while (blockPos.hasNext()) {
			BlockPos currentBlockPos = blockPos.next();
			Block block = tile.getWorld().getBlockState(currentBlockPos)
					.getBlock();
			if (block instanceof IGrowable) {
				tile.getWorld().updateBlockTick(currentBlockPos, block, 1, 1);
				if (tile.getWorld().isRemote) {
					if (random.nextFloat() > 0.9f) {
						tile.getWorld().spawnParticle(
								EnumParticleTypes.VILLAGER_HAPPY,
								currentBlockPos.getX() + random.nextFloat(),
								currentBlockPos.getY() + random.nextFloat(),
								currentBlockPos.getZ() + random.nextFloat(), 0,
								0, 0, new int[1]);
					}
				}
			}
		}
	}

	private static boolean listContains(List<String> cornerBlocks,
			String string, String string2, String string3, String string4) {
		return cornerBlocks.contains(string) && cornerBlocks.contains(string2)
				&& cornerBlocks.contains(string3)
				&& cornerBlocks.contains(string4);
	}

}
