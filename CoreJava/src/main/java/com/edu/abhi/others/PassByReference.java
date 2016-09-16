package com.edu.abhi.others;

public class PassByReference {
	
	private POJO pojo;

	
	public PassByReference(String name, int id) {
		this.pojo = new POJO(name,id);
	}


	public POJO getPojo() {
		return new POJO(pojo.getName(),pojo.getId());
		//return pojo;
	}
	
}
