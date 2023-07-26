package formulaire;

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
		urlPatterns = "/traitement",
		initParams = {
				@WebInitParam(
						name="min",
						value="11"
						),
				@WebInitParam(
						name="max",
						value="20"
					)					
		}			
	)
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rand = new Random();
	private Integer serverChoice = null; 
	private boolean win = false;

    @Override
    public void init() throws ServletException{
    	
    	int min = Integer.parseInt(this.getInitParameter("min"));
		int max = Integer.parseInt(this.getInitParameter("max"));
		serverChoice = rand.nextInt(min,max+1);	
		System.out.println(serverChoice);
    }
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("<h1>traitement</h1>");
		
		String userChoice = request.getParameter("nombre");
		// userChoice.isBlank() <====> userChoice.trim().isEmpty()
		if(userChoice.isBlank()) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		// valide
		int userChoiceConverted = Integer.parseInt(userChoice);
		if(serverChoice==userChoiceConverted && win == false) {
			win = true;
			response.sendRedirect(request.getContextPath()+"/InformeVictoire.html");
		}else {
			response.sendRedirect(request.getContextPath()+"/InformeEchec.html");
		}
	}
}
