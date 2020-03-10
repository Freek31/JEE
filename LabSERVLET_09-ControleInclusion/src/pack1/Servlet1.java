package pack1;
/**
	Collaboration de servlets : partage de contrôle
	Distribuer une inclusion
*/

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import utilitaires.Utils;

@SuppressWarnings("serial")
public class Servlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			
		// Positionnement du type Mime du corps de la réponse
	    res.setContentType("text/html");
	    
	    // Récupération d'un printWriter (package java.io)
	    PrintWriter out = res.getWriter();
		
	    // Ecriture de l'entête de la page HTML retournée
	    Utils.ecritDebut(out,"Les paramètres reçus :");
		
		// Retourne une instance de type RequestDispatcher par rapport à la servlet Servlet2
		RequestDispatcher dispat = req.getRequestDispatcher("/Servlet2");
		
		// 1ère inclusion de servlet2
		dispat.include(req,res);	
		out.println("<br />");
		
		// Positionnement d'un attribut sur la requête
		req.setAttribute("attribut1", "Cool cette servlet");
		// 2ème inclusion de servlet2
		dispat.include(req,res);
		out.println("<br />");
		
		// Positionnement d'un attribut sur la requête
		req.setAttribute("attribut1", "Super cool cette servlet");
		// 3ème inclusion de servlet2
		dispat.include(req,res);	
		out.println("<br />");
		
		// Positionnement d'un attribut sur la requête
		req.setAttribute("attribut1", "Super sexy cette servlet");
		// 4ème inclusion de servlet2
		dispat.include(req,res);	
		
		out.println("<br />");
		
	    // Ecrire la fin de la page HTML renvoyée
	    Utils.ecritFin(out);
	    		
	    // Vider le flux
	    out.flush();
	    
	    // Fermeture du flux
	    out.close();
	}
}
