package calc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculetteReady")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp")
		.include(request, response);
		
	}
	

       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Récupérer les valeurs des paramètres envoyés par la requête POST
        String op1 = request.getParameter("op1");
        String op2 = request.getParameter("op2");
        String op = request.getParameter("op");
        
        System.out.println(op1);
        System.out.println(op2);
        System.out.println(op);
        //
        // si pas valide --> Exception.
        if(op1.isBlank() || op2.isBlank()) {
        	return;  //on est dans un void donc le return est vide.
        }
        
        // traitement si valisde
     // Convertir les nombres en double (vous pouvez utiliser d'autres types si nécessaire)
        double num1 = Double.parseDouble(op1);
        double num2 = Double.parseDouble(op2);
        double result = 0;
        

        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    response.getWriter().write("Erreur : division par zéro");
                    return;
                }
                break;
            case "%":
                if (num2 != 0) {
                    result = num1 % num2;
                } else {
                    response.getWriter().write("Erreur : division par zéro");
                    return;
                }
                break;
            default:
                response.getWriter().write("Opérateur non pris en charge");
                return;
        }

        
        request.setAttribute("resultat", result);
        request.setAttribute("op1", num1);
        request.setAttribute("op2", num2);
        request.setAttribute("op", op);
        
        request.getRequestDispatcher("/WEB-INF/calculatrice.jsp")
		.forward(request, response);
    }

}
