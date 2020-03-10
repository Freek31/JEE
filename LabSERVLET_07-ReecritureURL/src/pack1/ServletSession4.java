package pack1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitaires.Utils;

public class ServletSession4 extends HttpServlet
{

	private static final long serialVersionUID = 8513567765539734747L;
	
	// Déclaration de la variable de session
	private HttpSession session;

	public void doProcess(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
      {

		    String jsessionId = null;
		
			// Récupérer ou créer l’objet session associé à la requête cliente
			// Paramètre : true ou rien = la session est récupérée ou créée automatiquement si elle n’existe pas
		    session = req.getSession(true);
		    
			// Positionnement du type Mime du corps de la réponse
		    res.setContentType("text/html");
		    
		    // Récupération d'un printWriter (package java.io)
		    PrintWriter out = res.getWriter();
		    
		    // Ecrire le début de la page HTML retournée
		    Utils.ecritDebut(out,"Suivi de session : Reecriture d'URL");
		    
		    out.println("<p>ServletSession4</p>"); 
		    
		    // getId() et getRequestedSessionId() retournent des valeurs différentes si cookies désactivés
		    // getId() retourne l'ID session
		    // getRequestedSessionId() retourne null 
		    
		    // Récupérer l'ID de session à partir de la session
		    jsessionId = session.getId();  
		    out.println("Session ID par getId() : " +jsessionId+"<br>");  
		    
		    // Récupérer l'ID de session à partir de la requête
		    jsessionId = req.getRequestedSessionId();
		    out.println("Session ID par getRequestedSessionId() : " +jsessionId+"<br>");  
		    
		    // Indique si nouvelle session
		    out.println("Nouvelle session (méthode isNew()) : " + session.isNew() + "</br>");
		    
		    // Ecrire la fin de la page HTML retournée
		    Utils.ecritFin(out);
		    
		    // Vider le flux
		    out.flush();
		    
		    // Fermeture du flux
		    out.close();
      }

	// SI requête de type POST -> appeler doProcess()
	public void doPost(HttpServletRequest req, HttpServletResponse res)
  		throws ServletException, IOException {
		doProcess(req, res);
	}
	
	// SI requête de type GET -> appeler doProcess() 
	public void doGet(HttpServletRequest req, HttpServletResponse res)
  		throws ServletException, IOException {
		doProcess(req, res);
	}
  
}