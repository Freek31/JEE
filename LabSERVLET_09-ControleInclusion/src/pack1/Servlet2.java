package pack1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet2 extends HttpServlet {
	
	private static final long serialVersionUID = -6977046325857605233L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		
		// Positionnement du type Mime du corps de la r�ponse
	    res.setContentType("text/html");
	    
	    // R�cup�ration d'un printWriter (package java.io)
	    PrintWriter out = res.getWriter();
	    
	    // SI attribut1 existe
		if (req.getAttribute("attribut1") != null) {
			// Afficher la valeur de l'attribut dans la page HTML retourn�e
			out.println("Attribut 1 : " + req.getAttribute("attribut1"));
			
		} 
		// SINON attribut n'existe pas
		else {
			out.println("Pas cool cette servlet. Il n'y a pas d'attribut.");
		}
	}
}