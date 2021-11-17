package com.feng.house.enums;


public enum BillState {

	NO_HAVE(1,"未收"),
	HAVE(2,"已收");

	
	public int id;
	public String desc;
	
	 BillState(int id,String desc) {
		this.desc=desc;
		this.id=id;
	}
	 public static String getDescByid(int id) {
	   BillState[] states= BillState.values();
	   for(BillState state:states) {
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
