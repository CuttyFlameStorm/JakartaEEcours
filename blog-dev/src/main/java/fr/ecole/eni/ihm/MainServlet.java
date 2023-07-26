package fr.ecole.eni.ihm;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// la route vers notre servlet MainServlet.
@WebServlet("/home")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//cette constante suit une interface serialisable.
	
	private int compteur = 0;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		compteur++;
		PrintWriter out = response.getWriter();
		out.write("<h1>" + compteur + "</h1>");
		out.write("<h1>" + this + "</h1>");
		out.write("---------------------");
		out.write("<h1>" + request.getHeader("user-agent") + "</h1>");
		out.write("---------------------");
		
		out.write("---------------------");
		out.write("<h1>" + request.getCharacterEncoding() + "</h1>");
		out.write("---------------------");
		out.write("<h1>" + request.getLocale() + "</h1>");
		out.write("---------------------");
		out.write("<h1>" + request.getMethod() + "</h1>");
		out.write("<h1>" + request.getHeader("Host") + "</h1>");
		out.write("---------------------");
		System.out.println(request.getHeaderNames().nextElement());
		
	}
	
	

}
