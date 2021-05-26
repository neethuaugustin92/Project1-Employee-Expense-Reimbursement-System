package com.project1.model;

import java.util.List;

public class ERS_USERS {

	private int ERS_USERS_ID;
	private String ERS_USERNAME;
	private String ERS_PASSWORD;
	private String USER_FIRST_NAME;
	private String USER_LAST_NAME;
	private String USER_EMAIL;
	private int USER_ROLE_ID;
	//private String  ERS_USER_ROLES;
	private List<String> USERS;
	
	public int getERS_USERS_ID() {
		return ERS_USERS_ID;
	}
	
	public void setERS_USERS_ID(int eRS_USERS_ID) {
		ERS_USERS_ID = eRS_USERS_ID;
	}
	
	
	public String getERS_USERNAME() {
		return ERS_USERNAME;
	}
	
	public void setERS_USERNAME(String eRS_USERNAME) {
		ERS_USERNAME = eRS_USERNAME;
	}
	public String getERS_PASSWORD() {
		return ERS_PASSWORD;
	}
	public void setERS_PASSWORD(String eRS_PASSWORD) {
		ERS_PASSWORD = eRS_PASSWORD;
	}
	public String getUSER_FIRST_NAME() {
		return USER_FIRST_NAME;
	}
	public void setUSER_FIRST_NAME(String uSER_FIRST_NAME) {
		USER_FIRST_NAME = uSER_FIRST_NAME;
	}
	public String getUSER_LAST_NAME() {
		return USER_LAST_NAME;
	}
	public void setUSER_LAST_NAME(String uSER_LAST_NAME) {
		USER_LAST_NAME = uSER_LAST_NAME;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public int getUSER_ROLE_ID() {
		return USER_ROLE_ID;
	}
	public void setUSER_ROLE_ID(int uSER_ROLE_ID) {
		USER_ROLE_ID = uSER_ROLE_ID;
	}
	
	/*
	public String getERS_USER_ROLES() {
		return ERS_USER_ROLES;
	}
	public void setERS_USER_ROLES(String eRS_USER_ROLES) {
		ERS_USER_ROLES = eRS_USER_ROLES;
	}
	
	*/
	
	public List<String> getUSERS() {
		return USERS;
	}
	public void setUSERS(List<String> uSERS) {
		USERS = uSERS;
	}

	
	public ERS_USERS() {
		
	}
	
	
	public ERS_USERS(int eRS_USERS_ID, String eRS_USERNAME, String eRS_PASSWORD, String uSER_FIRST_NAME,
			String uSER_LAST_NAME, String uSER_EMAIL, int uSER_ROLE_ID, String eRS_USER_ROLES) {
		//super();
		System.out.println("entered user constructor2");
		ERS_USERS_ID = eRS_USERS_ID;
		ERS_USERNAME = eRS_USERNAME;
		ERS_PASSWORD = eRS_PASSWORD;
		USER_FIRST_NAME = uSER_FIRST_NAME;
		USER_LAST_NAME = uSER_LAST_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_ROLE_ID = uSER_ROLE_ID;
		
	}
	
	public ERS_USERS( String eRS_USERNAME, String eRS_PASSWORD, String uSER_FIRST_NAME,
			String uSER_LAST_NAME, String uSER_EMAIL, int uSER_ROLE_ID) {
		//super();
		System.out.println("entered user constructor3");
		this.ERS_USERNAME = eRS_USERNAME;
		this.ERS_PASSWORD = eRS_PASSWORD;
		this.USER_FIRST_NAME = uSER_FIRST_NAME;
		this.USER_LAST_NAME = uSER_LAST_NAME;
		this.USER_EMAIL = uSER_EMAIL;
		this.USER_ROLE_ID = uSER_ROLE_ID;
		
	}
	
	public ERS_USERS(int eRS_USERS_ID, String eRS_USERNAME, String eRS_PASSWORD, String uSER_FIRST_NAME,
			String uSER_LAST_NAME, String uSER_EMAIL, int uSER_ROLE_ID, List<String> uSERS) {
		super();
		System.out.println("entered user constructor4");
		ERS_USERS_ID = eRS_USERS_ID;
		ERS_USERNAME = eRS_USERNAME;
		ERS_PASSWORD = eRS_PASSWORD;
		USER_FIRST_NAME = uSER_FIRST_NAME;
		USER_LAST_NAME = uSER_LAST_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_ROLE_ID = uSER_ROLE_ID;
		USERS = uSERS;
	}

	@Override
	public String toString() {
		return "ERS_USERS [ERS_USERS_ID=" + ERS_USERS_ID + ", ERS_USERNAME=" + ERS_USERNAME + ", ERS_PASSWORD="
				+ ERS_PASSWORD + ", USER_FIRST_NAME=" + USER_FIRST_NAME + ", USER_LAST_NAME=" + USER_LAST_NAME
				+ ", USER_EMAIL=" + USER_EMAIL + ", USER_ROLE_ID=" + USER_ROLE_ID + ", USERS=" + USERS + "]";
	}
	
	
}
