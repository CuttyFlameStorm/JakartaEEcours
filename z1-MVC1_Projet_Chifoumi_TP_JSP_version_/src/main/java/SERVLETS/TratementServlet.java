package SERVLETS;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		name = "traitement",
		urlPatterns = "/chifoumi",
		initParams = {
				@WebInitParam(
						name="min",
						value="1"
						),
				@WebInitParam(
						name="max",
						value="3"
					)					
		}			
	)
public class TratementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rand = new Random();
	private Integer serverChoice = null; 
	private String choixIA = null;
	private boolean win = false;
	private int joueurIntChoix = 0;
	private String resultFinal = null;
	
	@Override
    public void init() throws ServletException{
    	
    	int min = Integer.parseInt(this.getInitParameter("min"));
		int max = Integer.parseInt(this.getInitParameter("max"));
		serverChoice = rand.nextInt(min,max+1);	
		System.out.println(serverChoice);
		if (serverChoice == 1) {
			choixIA = "CHI";
		} 
		if (serverChoice == 2){
			choixIA = "FOU";
		}
		if (serverChoice == 3){
			choixIA = "MI";
		}
		System.out.println(choixIA);
    }
	
	
	

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pages/tentative.jsp")
		.include(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String choixJoueur = request.getParameter("choixJoueur");
		System.out.println(choixJoueur + " choix du joueur bien recu par la servlet");

		if (choixJoueur.equals("CHI")) {
			joueurIntChoix = 1;
		} 
		if (choixJoueur.equals("FOU")){
			joueurIntChoix = 2;
		}
		if (choixJoueur.equals("MI")){
			joueurIntChoix = 3;
		}
		System.out.println(joueurIntChoix + "choix du joueur en int");
		
		if (joueurIntChoix == serverChoice) {
			resultFinal = "egalité";
			
		}
		if (serverChoice == 1 && joueurIntChoix == 2) {
			resultFinal = "Le joueur à Gagné !";
			
		}
		if (serverChoice == 1 && joueurIntChoix == 3) {
			resultFinal = "IA computer à GAGNé !";
			
		}
		if (serverChoice == 2 && joueurIntChoix == 1) {
			resultFinal = "IA computer à GAGNé !";
			
		}
		if (serverChoice == 2 && joueurIntChoix == 3) {
			resultFinal = "Le joueur gagne !";
			
		}
		if (serverChoice == 3 && joueurIntChoix == 1) {
			resultFinal = "Le joueur gagne !";
			
		}
		if (serverChoice == 3 && joueurIntChoix == 2) {
			resultFinal = "L'IA Computer à Gagné !";
			
		}
		System.out.println(resultFinal);
		request.setAttribute("resultat", resultFinal);
		request.getRequestDispatcher("/pages/resultat.jsp")
		.forward(request, response);
		
		
	}

}
