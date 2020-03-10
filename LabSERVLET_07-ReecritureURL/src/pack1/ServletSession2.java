package pack1;

import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitaires.Utils;

/**
 * 
 * @author Pascal
 
	- une session maintient « en vie » les données de l'application pendant une transaction
	- cette nécessité est inhérente à la nature même de HTTP (sans état)
	- les sessions sont des instances de la classe HttpSession
	- une servlet met sa session à disposition avec la méthode getSession()
	- il se peut qu'elle n'existe pas au premier appel, dans ce cas elle est instanciée
	- n'importe quel objet peut être stocké dans la session
	- lorsque la session est terminée, elle peut être invalidée par la méthode invalidate()
	
	- attention un client peut ne pas supporter les cookies !
		-> dans ce cas response.encodeURL ajoute automatiquement un attribut jsessionid à l'URL

 */
public class ServletSession2 extends HttpServlet {
 
	private static final long serialVersionUID = 8513567765539734747L;
	
	// Déclaration de la variable de session
	private HttpSession session;

	public void doProcess (HttpServletRequest req,HttpServletResponse res)
      throws ServletException, IOException {

		System.out.println ("Debut Servlet2");
		
		// Avec true -> nouvelle session si nécessaire
		session = req.getSession(true);
    
		// Positionnement du type Mime du corps de la réponse
		res.setContentType("text/html");
		
		// Récupération d'un printWriter (package java.io)
		PrintWriter out = res.getWriter();
	    
		// Ecrire le début de la page HTML retournée
	    Utils.ecritDebut(out,"Suivi de session : Reecriture d'URL");
	    
	    // Récupération de l'attribut de session nommé "count"
	    Integer count = (Integer) session.getAttribute("count");
	    
	    // Incrémentation du compteur de visite si l'attribut de session nommé "count" existe
	    if (count == null)
	    	count = new Integer(1);
	    else
	        count = new Integer(count.intValue() + 1);
	    
	    // Attache à la session l'attribut  nommé "count"
	    session.setAttribute("count", count);

	    out.println("<p>Session Count</p>");
	    out.println("<h1>Session Count</h1>");
	
	    out.println("Vous avez visité cette page " + count
	            + ((count == 1) ? " fois." : " fois."));
	
	    out.println("<p>");
	
	    out.println("<h3>Ci-dessous, les données sauvées dans la session :</h3>");
	    
	    // Récupérer tous les attributs de la session
	    Enumeration<String> e = session.getAttributeNames();
	    // Mettre dans la pahe HTML retournée les attibuts de la session
	    while (e.hasMoreElements()) {
	          String name = (String) e.nextElement();
	          out.println(name + ": " + session.getAttribute(name) + "</ br>");
	    }

	    out.println("<h3>Ci-dessous, des informations sur la session :</h3>");
        
	    // Retourne le ID de la session
	    out.println("Session id (méthode getId()) : " + session.getId() + " <i>(A garder secrètement)</i></br>");
	    
	    // Indique si nouvelle session
	    out.println("Nouvelle session (méthode isNew()) : " + session.isNew() + "</br>");
	    
	    // Indique l'intervalle de temps avant expiration de la session
        out.println("Timeout avant expiration (getMaxInactiveInterval()) : " + session.getMaxInactiveInterval());
        out.println("<i>(" + session.getMaxInactiveInterval() / 60 + " minutes)</i><br />");
        
        // Retourne la date de création de la session
        out.println("Date/Heure de création (getCreationTime()) : " + session.getCreationTime());    
        out.println("<i>(" + new Date(session.getCreationTime()) + ")</i><br />");
        
        // Retourne la date de la dernière requête envoyée par le client, associée à cette session
        out.println("Date/heure dernier accès (getLastAccessedTime()) : " + session.getLastAccessedTime());
        out.println("<i>(" + new Date(session.getLastAccessedTime()) + ")</i><br />");

        // Indique si l'ID de session provient d'un cookie
        out.println("ID session demandé provient d'un cookie (isRequestedSessionIdFromCookie()) : " 
        		+ req.isRequestedSessionIdFromCookie() + "<br />");
        
        // Indique si l'ID de session provient de l'URL
        out.println("ID session demandé provient de l'URL (isRequestedSessionIdFromURL() ) : " 
        		+ req.isRequestedSessionIdFromURL() + "<br />");
        
        // Indique si  l'ID de session de la requête est toujours valide
        out.println("ID session demandé dans requête est valide (isRequestedSessionIdValid()) : " 
        		+ req.isRequestedSessionIdValid() + "<br />");
        
        // Appel de la servlet ServletSession2 c'est à dire cette servlet
        // Ré encodage de l'URL avec encodeURL() pour garder l'id de session
        out.println("<h3>Test de la réécriture d'URL</h3>");
        out.println("<p>Retour de req.getRequestURI() : " + req.getRequestURI() + "</p>");
        out.println("Cliquez <a href=\"" + res.encodeURL(req.getRequestURI()) + "\">ici</a>");
        out.println("pour tester que le tracking de session fonctionne via la réécriture d'URL ");
        out.println("même si les cookies ne sont pas supportés.<br />");

        // Appel de la servlet ServletSession3
        // Ré encodage de l'URL avec encodeURL() pour garder l'id de session
        // Si cookies autorisés -> même session dans les 2 cas
        out.println("Context path : " + req.getContextPath() + "<br />");
        out.print("<a href=\"" + res.encodeURL(req.getContextPath() + "/ServletSession3") + "\">Executer ServletSession3</a><br />");
       
        // Appel de la servlet ServletSession3
        out.println("<a href=\"ServletSession3\">Executer ServletSession3 sans EncodeURL</a><br />");
        
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