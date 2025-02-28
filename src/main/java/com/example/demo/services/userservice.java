package com.example.demo.services;

import java.util.List;

import com.example.demo.model.user;

public interface userservice {

	List<user> getalluser();
	
	void saveuser(user u);
	
	void deleteuser(long id);
	
	user getbyid(long id);
	
}