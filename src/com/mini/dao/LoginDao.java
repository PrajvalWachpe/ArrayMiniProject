package com.mini.dao;

public interface LoginDao {

	public boolean employeeLogin(String Username, String password);
	public boolean adminLogin(String Username, String password);
	
}
