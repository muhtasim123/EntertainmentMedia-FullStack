package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.repositories.EntertainmentMediaPostgresDao;
import com.revature.services.EntertainmentMediaService;
import com.revature.services.EntertainmentMediaServiceImplementation;

public class AuthController {
	
	private EntertainmentMediaService ems = new EntertainmentMediaServiceImplementation(new EntertainmentMediaPostgresDao());
	
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		
	}
}
