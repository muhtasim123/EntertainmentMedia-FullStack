package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.AbstractHttpExceptions;

public class ErrorController {

	public void handle(HttpServletRequest req, HttpServletResponse res, Throwable t) throws IOException {
		
		if(t == null) {
			t.printStackTrace();
			res.setStatus(500);
			res.getWriter().write("Oops something went wrong");
			return;
		}
		
		if(t instanceof AbstractHttpExceptions) {
			AbstractHttpExceptions err = (AbstractHttpExceptions) t;
			t.printStackTrace();
			res.setStatus(err.getStatusCode());
			res.getWriter().write(err.getMessage());
		} else {
			//LoggerSingleton.getLogger().error(t.getStackTrace());
			t.printStackTrace();
			res.setStatus(500);
			res.getWriter().write("Oops something went wrong");
		}
	}
}
