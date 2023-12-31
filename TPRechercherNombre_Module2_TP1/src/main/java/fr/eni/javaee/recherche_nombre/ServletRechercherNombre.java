package fr.eni.javaee.recherche_nombre;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRechercherNombre
 */

public class ServletRechercherNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int nombreATrouver;
	private boolean win;
	private int borneMin=0;
	private int borneMax=10;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercherNombre() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	//On recherche entre 0 inclus et la différence max-min+1 (car valeur max exclue)
    	//On ajoute ensuite borneMin pour arriver dans la plage ([borneMin;borneMax])
    	this.nombreATrouver=new Random().nextInt(this.borneMax-this.borneMin+1)+this.borneMin;
    	this.win=false;
    	System.out.println(this.nombreATrouver);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer la valeur
		String nombreSaisie = request.getParameter("nombre");
		if(nombreSaisie.equals(String.valueOf(this.nombreATrouver)) && !this.win)
		{
			response.sendRedirect("succes.html");
			this.win=true;
		}
		else
		{
			response.sendRedirect("echec.html");
		}
	}

}















