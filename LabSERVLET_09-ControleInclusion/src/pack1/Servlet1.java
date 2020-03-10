package pack1;
/**
	Collaboration de servlets : partage de contr�le
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
			
		// Positionnement du type Mime du corps de la r�ponse
	    res.setContentType("text/html");
	    
	    // R�cup�ration d'un printWriter (package java.io)
	    PrintWriter out = res.getWriter();
		
	    // Ecriture de l'ent�te de la page HTML retourn�e
	    Utils.ecritDebut(out,"Les param�tres re�us :");
		
		// Retourne une instance de type RequestDispatcher par rapport � la servlet Servlet2
		RequestDispatcher dispat = req.getRequestDispatcher("/Servlet2");
		
		// 1�re inclusion de servlet2
		dispat.include(req,res);	
		out.println("<br />");
		
		// Positionnement d'un attribut sur la requ�te
		req.setAttribute("attribut1", "Cool cette servlet");
		// 2�me inclusion de servlet2
		dispat.include(req,res);
		out.println("<br />");
		
		// Positionnement d'un attribut sur la requ�te
		req.setAttribute("attribut1", "Super cool cette servlet");
		// 3�me inclusion de servlet2
		dispat.include(req,res);	
		out.println("<br />");
		
		// Positionnement d'un attribut sur la requ�te
		req.setAttribute("attribut1", "Super sexy cette servlet");
		// 4�me inclusion de servlet2
		dispat.include(req,res);	
		
		out.println("<br />");
		
	    // Ecrire la fin de la page HTML renvoy�e
	    Utils.ecritFin(out);
	    		
	    // Vider le flux
	    out.flush();
	    
	    // Fermeture du flux
	    out.close();
	}
}
