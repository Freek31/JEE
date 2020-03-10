package pack1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitaires.Utils;

public class ServletSession4 extends HttpServlet
{

	private static final long serialVersionUID = 8513567765539734747L;
	
	// D�claration de la variable de session
	private HttpSession session;

	public void doProcess(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
      {

		    String jsessionId = null;
		
			// R�cup�rer ou cr�er l�objet session associ� � la requ�te cliente
			// Param�tre : true ou rien = la session est r�cup�r�e ou cr��e automatiquement si elle n�existe pas
		    session = req.getSession(true);
		    
			// Positionnement du type Mime du corps de la r�ponse
		    res.setContentType("text/html");
		    
		    // R�cup�ration d'un printWriter (package java.io)
		    PrintWriter out = res.getWriter();
		    
		    // Ecrire le d�but de la page HTML retourn�e
		    Utils.ecritDebut(out,"Suivi de session : Reecriture d'URL");
		    
		    out.println("<p>ServletSession4</p>"); 
		    
		    // getId() et getRequestedSessionId() retournent des valeurs diff�rentes si cookies d�sactiv�s
		    // getId() retourne l'ID session
		    // getRequestedSessionId() retourne null 
		    
		    // R�cup�rer l'ID de session � partir de la session
		    jsessionId = session.getId();  
		    out.println("Session ID par getId() : " +jsessionId+"<br>");  
		    
		    // R�cup�rer l'ID de session � partir de la requ�te
		    jsessionId = req.getRequestedSessionId();
		    out.println("Session ID par getRequestedSessionId() : " +jsessionId+"<br>");  
		    
		    // Indique si nouvelle session
		    out.println("Nouvelle session (m�thode isNew()) : " + session.isNew() + "</br>");
		    
		    // Ecrire la fin de la page HTML retourn�e
		    Utils.ecritFin(out);
		    
		    // Vider le flux
		    out.flush();
		    
		    // Fermeture du flux
		    out.close();
      }

	// SI requ�te de type POST -> appeler doProcess()
	public void doPost(HttpServletRequest req, HttpServletResponse res)
  		throws ServletException, IOException {
		doProcess(req, res);
	}
	
	// SI requ�te de type GET -> appeler doProcess() 
	public void doGet(HttpServletRequest req, HttpServletResponse res)
  		throws ServletException, IOException {
		doProcess(req, res);
	}
  
}