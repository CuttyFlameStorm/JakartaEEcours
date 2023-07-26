package packagedemo;


import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	public void init() throws ServletException {
    		
    		System.out.println(this.getInitParameter("Email_Admin"));
    	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	

}
