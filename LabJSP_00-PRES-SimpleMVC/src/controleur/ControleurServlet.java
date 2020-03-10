package controleur;

import javax.servlet.*;
import javax.servlet.http.*;
import modele.ModeleBean;
import java.io.*;

@SuppressWarnings("serial")
public class ControleurServlet extends HttpServlet{
    
	// Traitement d'une requête POST
    public void doPost(HttpServletRequest  request, 
                       HttpServletResponse response) 
                  throws ServletException, IOException{

    	// Créer un objet ModeleBean
        ModeleBean modelBean = new ModeleBean();

        // Récupérer les données saisies (request.getParameter())
        // Positionner les attributs de l'objet avec les données saisies
        modelBean.setFirstName(request.getParameter("first_name")); 
        modelBean.setLastName(request.getParameter("last_name")); 
        modelBean.setEmail(request.getParameter("email")); 
        modelBean.setPhone(request.getParameter("phone")); 

        // Positionner l'objet comme attribut de la requête
        // --> page vue.jsp -> scope="request"
        request.setAttribute("modelBean", modelBean);

        // Redirection vers la page vue.jsp
        getServletContext().getRequestDispatcher("/vue.jsp").forward(request, response);
    }

    // Traitement d'une requête GET
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                  throws ServletException, IOException{

    	// Redirection vers la page vue.jsp
        getServletContext().getRequestDispatcher("/vue.jsp").forward(request, response);
    }
}