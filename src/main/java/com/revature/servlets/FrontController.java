package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AuthController;
import com.revature.controllers.ErrorController;
import com.revature.controllers.UserController;

public class FrontController extends HttpServlet {

	private AuthController authController = new AuthController();
	private ErrorController errController = new ErrorController();
	private UserController userController = new UserController();
	
    protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //be our front controller
        String URI = req.getRequestURI().substring(req.getContextPath().length(), 
        											req.getRequestURI().length());
        
        
        System.out.println(URI);
        switch(URI) {
        	case "/login":
        		switch(req.getMethod()) {
        			case "GET":
        				res.setStatus(400);
        				res.getWriter().write("Method Not Supported");
        				break;
        			case "POST":
        				authController.userLogin(req, res);
        				break;
        			case "PUT":
        				res.setStatus(400);
        				res.getWriter().write("Method Not Supported");
        				break;
        			case "DELETE":
        				res.setStatus(400);
        				res.getWriter().write("Method Not Supported");
        				break;
        			default:
        				break;
        		}
        		break;
        	case "/users":
        		switch(req.getMethod()) {
	    			case "GET":
	    				userController.findAllUsers(req, res);
	    				break;
	    			case "POST":
	    				authController.userLogin(req, res);
	    				break;
	    			case "PUT":
	    				res.setStatus(400);
	    				res.getWriter().write("Method Not Supported");
	    				break;
	    			case "DELETE":
	    				res.setStatus(400);
	    				res.getWriter().write("Method Not Supported");
	    				break;
	    			default:
	    				break;
        		}
        		break;
        	default:
        		res.setStatus(404);
        		res.getWriter().write("No Such Resource");
        		break;
        }
        
        
        
        
    }
    
    protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//to handle all internal errors/exceptions
    	try {
    		directControlRouter(request, response);
    	} catch (Throwable t) {
    		//go to the error controller
    		errController.handle(request, response, t);
    	}
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        directControl(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        directControl(request,response);

    }

    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        directControl(request,response);

    }

    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        directControl(request,response);

    }

}