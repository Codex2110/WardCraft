package com.codex.wards.items;

public class ModItems {
	
	public static BaseItem testItem;
	public static WardingInk ink;
	
	public static void registerItems(){
		testItem = new BaseItem("testItem");
		ink = new WardingInk("wardingInk");
	}

}
