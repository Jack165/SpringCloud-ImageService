package com.feng.house.enums;


public enum ContractState {

	ON_LINE(0,"再租"),
	RETRUN(1,"退租");
	
	public int id;
	public String desc;
	
	 ContractState(int id,String desc) {
		this.desc=desc;
		this.id=id;
	}
	 public static String getDescByid(int id) {
	   ContractState[] states= ContractState.values();
	   for(ContractState state:states) {
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
