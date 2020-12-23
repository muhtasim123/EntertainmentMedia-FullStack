package com.revature.repositories;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;

public class UserDaoDebugger {
	public static void main(String[] args) throws UserNotFoundException, InternalErrorException {
		UserDao ud = new UserPostgresDao();
		
		System.out.println(ud.findUserByUsernameAndPassword("AB", "password"));
	}
}
