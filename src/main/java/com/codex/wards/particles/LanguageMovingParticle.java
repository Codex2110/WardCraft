package com.codex.wards.particles;

import java.util.Random;

import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class LanguageMovingParticle extends EntityEnchantmentTableParticleFX {

	private BlockPos start, end;
	private boolean movingX;
	private Random random;
	private float movement;

	protected LanguageMovingParticle(World worldIn, double p_i1204_2_,
			double p_i1204_4_, double p_i1204_6_, double p_i1204_8_,
			double p_i1204_10_, double p_i1204_12_) {
		super(worldIn, p_i1204_2_, p_i1204_4_, p_i1204_6_, p_i1204_8_,
				p_i1204_10_, p_i1204_12_);
		// TODO Auto-generated constructor stub
	}

	public LanguageMovingParticle(World worldIn, double p_i1204_2_,
			double p_i1204_4_, double p_i1204_6_, double p_i1204_8_,
			double p_i1204_10_, double p_i1204_12_, BlockPos start, BlockPos end) {
		super(worldIn, p_i1204_2_, p_i1204_4_, p_i1204_6_, p_i1204_8_,
				p_i1204_10_, p_i1204_12_);
		this.start = start;
		this.end = end;
		random = new Random();
		if (random.nextBoolean()) {
			BlockPos temp = start;
			this.start = end;
			this.end = temp;

		}
		movement = 0.05f;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (start.getX() - end.getX() == 0) {
			if (start.getZ() - end.getZ() != 0) {
				if (start.getZ() - end.getZ() < 0) {
					this.posZ += movement;
				} else {
					this.posZ -= movement;
				}
			}
		} else {
			if(start.getX()-end.getX()<0){
				this.posX+=movement;
			} else{
				this.posX-=movement;
			}
		}
		if(this.getPosition().distanceSq(end)<=1){
			this.setDead();
		}
	}
}
