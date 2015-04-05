package com.codex.wards;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class WardsTab extends CreativeTabs {

	public WardsTab(int index, String label) {
		super(index, label);
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.apple;
	}

}
