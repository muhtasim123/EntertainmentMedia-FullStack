package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.EntertainmentMediaPostgresDao;
import com.revature.repositories.UserPostgresDao;
import com.revature.services.EntertainmentMediaService;
import com.revature.services.EntertainmentMediaServiceImplementation;
import com.revature.services.UserService;
import com.revature.services.UserServiceImplementation;

public class AuthController {
	
	private UserService us = new UserServiceImplementation(new UserPostgresDao());
	
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		User u = us.login(cred.getUsername(), cred.getPassword());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
		
	}
}
