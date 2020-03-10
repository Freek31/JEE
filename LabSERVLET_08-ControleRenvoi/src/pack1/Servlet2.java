package pack1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import utilitaires.Utils;

public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = -6977046325857605233L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		// Positionnement du type Mime du corps de la réponse
	    res.setContentType("text/html");
	    
	    // Récupération d'un printWriter (package java.io)
	    PrintWriter out = res.getWriter();
	    
	    // Ecriture de l'entête de la page HTML retournée
	    Utils.ecritDebut(out,"Les paramètres reçus :");
	    
		out.println("<h2>Paramètres lus par SERVLET2</h2>");
		
		// Récupération du paramètre positionné par servlet
		out.println("<p>Attribut 2 : " + req.getParameter("attribut2") + "</p>");
		
		// Récupération de l'attribut attaché à la requête par la servlet Servlet1
		out.println("<p>Attribut 1 : " + req.getAttribute("attribut1") + "</p>");
		
	    // Ecrire la fin de la page HTML renvoyée
	    Utils.ecritFin(out);
	    
	    // Vider le flux
	    out.flush();
	    
	    // Fermeture du flux
	    out.close();
	}
}