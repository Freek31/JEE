package controleur;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modele.SimpleBean;
import java.io.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/ControleurServlet")
public class ControleurServlet extends HttpServlet{
    
	// Traitement d'une requête GET
    public void doGet(HttpServletRequest request, 
                       HttpServletResponse response) 
                  throws ServletException, IOException{

    	// Créer un objet SimpleBean
    	SimpleBean modelBean = new SimpleBean();

        // Positionner les attributs de l'objet
        modelBean.setFirstName("Bob"); 
        modelBean.setLastName("Marley"); 
        modelBean.setEmail("bob.marley@afpa.fr"); 
        modelBean.setPhone("0562123444"); 

        // Positionner l'objet comme attribut de la requête
        // --> page simple-bean3.jsp -> scope="request"
        request.setAttribute("simpleBean", modelBean);

        // Redirection vers la page simple-bean3.jsp
        getServletContext().getRequestDispatcher("/simple-bean3.jsp").forward(request, response);
    }
}