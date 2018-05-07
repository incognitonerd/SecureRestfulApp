package com.securerestfulservices.utils;
public enum RoleConstants{
	ADMIN("ROLE_ADMIN"), //
	USER("ROLE_USER");
	//
	String role;
	
	RoleConstants(String role){
		this.role = role;
	}
	
	public String getRole(){
		return role;
	}
}
