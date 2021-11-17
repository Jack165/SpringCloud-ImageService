package com.feng.house.enums;


public enum HouseState {
	FREE(0,"空闲"),
	RENTED(1,"已租");
	
	public int id;
	public String desc;
	
	 HouseState(int id,String desc) {
		this.desc=desc;
		this.id=id;
	}
	 public static String getDescByid(int id) {
	   HouseState[] states= HouseState.values();
	   for(HouseState state:states) {
		   if(state.id==id) {
			   return state.desc;
		   }
	   }
	   return null;
	 }
	
	 public int getId() {
		 return this.id;
	 }
	 
	 public String getDesc() {
		 return this.desc;
	 }
}
