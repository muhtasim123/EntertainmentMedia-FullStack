import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    protected void directControl(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //be our front controller
        String URI = req.getRequestURI().substring(req.getContextPath().length(), 
        											req.getRequestURI().length());
        
        switch(URI) {
        	case "/login":
        		switch(req.getMethod()) {
        			case "GET":
        				break;
        			case "POST":
        				break;
        			case "PUT":
        				break;
        			case "DELETE":
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