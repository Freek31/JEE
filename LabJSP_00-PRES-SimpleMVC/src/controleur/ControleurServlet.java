package controleur;

import javax.servlet.*;
import javax.servlet.http.*;
import modele.ModeleBean;
import java.io.*;

@SuppressWarnings("serial")
public class ControleurServlet extends HttpServlet{
    
	// Traitement d'une requ�te POST
    public void doPost(HttpServletRequest  request, 
                       HttpServletResponse response) 
                  throws ServletException, IOException{

    	// Cr�er un objet ModeleBean
        ModeleBean modelBean = new ModeleBean();

        // R�cup�rer les donn�es saisies (request.getParameter())
        // Positionner les attributs de l'objet avec les donn�es saisies
        modelBean.setFirstName(request.getParameter("first_name")); 
        modelBean.setLastName(request.getParameter("last_name")); 
        modelBean.setEmail(request.getParameter("email")); 
        modelBean.setPhone(request.getParameter("phone")); 

        // Positionner l'objet comme attribut de la requ�te
        // --> page vue.jsp -> scope="request"
        request.setAttribute("modelBean", modelBean);

        // Redirection vers la page vue.jsp
        getServletContext().getRequestDispatcher("/vue.jsp").forward(request, response);
    }

    // Traitement d'une requ�te GET
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                  throws ServletException, IOException{

    	// Redirection vers la page vue.jsp
        getServletContext().getRequestDispatcher("/vue.jsp").forward(request, response);
    }
}