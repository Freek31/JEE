package pack1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import utilitaires.Utils;

public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = -6977046325857605233L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		// Positionnement du type Mime du corps de la r�ponse
	    res.setContentType("text/html");
	    
	    // R�cup�ration d'un printWriter (package java.io)
	    PrintWriter out = res.getWriter();
	    
	    // Ecriture de l'ent�te de la page HTML retourn�e
	    Utils.ecritDebut(out,"Les param�tres re�us :");
	    
		out.println("<h2>Param�tres lus par SERVLET2</h2>");
		
		// R�cup�ration du param�tre positionn� par servlet
		out.println("<p>Attribut 2 : " + req.getParameter("attribut2") + "</p>");
		
		// R�cup�ration de l'attribut attach� � la requ�te par la servlet Servlet1
		out.println("<p>Attribut 1 : " + req.getAttribute("attribut1") + "</p>");
		
	    // Ecrire la fin de la page HTML renvoy�e
	    Utils.ecritFin(out);
	    
	    // Vider le flux
	    out.flush();
	    
	    // Fermeture du flux
	    out.close();
	}
}