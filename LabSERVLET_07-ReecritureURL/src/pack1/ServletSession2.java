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
 
	- une session maintient ��en vie�� les donn�es de l'application pendant une transaction
	- cette n�cessit� est inh�rente � la nature m�me de HTTP (sans �tat)
	- les sessions sont des instances de la classe HttpSession
	- une servlet met sa session � disposition avec la m�thode getSession()
	- il se peut qu'elle n'existe pas au premier appel, dans ce cas elle est instanci�e
	- n'importe quel objet peut �tre stock� dans la session
	- lorsque la session est termin�e, elle peut �tre invalid�e par la m�thode invalidate()
	
	- attention un client peut ne pas supporter les cookies !
		-> dans ce cas response.encodeURL ajoute automatiquement un attribut jsessionid � l'URL

 */
public class ServletSession2 extends HttpServlet {
 
	private static final long serialVersionUID = 8513567765539734747L;
	
	// D�claration de la variable de session
	private HttpSession session;

	public void doProcess (HttpServletRequest req,HttpServletResponse res)
      throws ServletException, IOException {

		System.out.println ("Debut Servlet2");
		
		// Avec true -> nouvelle session si n�cessaire
		session = req.getSession(true);
    
		// Positionnement du type Mime du corps de la r�ponse
		res.setContentType("text/html");
		
		// R�cup�ration d'un printWriter (package java.io)
		PrintWriter out = res.getWriter();
	    
		// Ecrire le d�but de la page HTML retourn�e
	    Utils.ecritDebut(out,"Suivi de session : Reecriture d'URL");
	    
	    // R�cup�ration de l'attribut de session nomm� "count"
	    Integer count = (Integer) session.getAttribute("count");
	    
	    // Incr�mentation du compteur de visite si l'attribut de session nomm� "count" existe
	    if (count == null)
	    	count = new Integer(1);
	    else
	        count = new Integer(count.intValue() + 1);
	    
	    // Attache � la session l'attribut  nomm� "count"
	    session.setAttribute("count", count);

	    out.println("<p>Session Count</p>");
	    out.println("<h1>Session Count</h1>");
	
	    out.println("Vous avez visit� cette page " + count
	            + ((count == 1) ? " fois." : " fois."));
	
	    out.println("<p>");
	
	    out.println("<h3>Ci-dessous, les donn�es sauv�es dans la session :</h3>");
	    
	    // R�cup�rer tous les attributs de la session
	    Enumeration<String> e = session.getAttributeNames();
	    // Mettre dans la pahe HTML retourn�e les attibuts de la session
	    while (e.hasMoreElements()) {
	          String name = (String) e.nextElement();
	          out.println(name + ": " + session.getAttribute(name) + "</ br>");
	    }

	    out.println("<h3>Ci-dessous, des informations sur la session :</h3>");
        
	    // Retourne le ID de la session
	    out.println("Session id (m�thode getId()) : " + session.getId() + " <i>(A garder secr�tement)</i></br>");
	    
	    // Indique si nouvelle session
	    out.println("Nouvelle session (m�thode isNew()) : " + session.isNew() + "</br>");
	    
	    // Indique l'intervalle de temps avant expiration de la session
        out.println("Timeout avant expiration (getMaxInactiveInterval()) : " + session.getMaxInactiveInterval());
        out.println("<i>(" + session.getMaxInactiveInterval() / 60 + " minutes)</i><br />");
        
        // Retourne la date de cr�ation de la session
        out.println("Date/Heure de cr�ation (getCreationTime()) : " + session.getCreationTime());    
        out.println("<i>(" + new Date(session.getCreationTime()) + ")</i><br />");
        
        // Retourne la date de la derni�re requ�te envoy�e par le client, associ�e � cette session
        out.println("Date/heure dernier acc�s (getLastAccessedTime()) : " + session.getLastAccessedTime());
        out.println("<i>(" + new Date(session.getLastAccessedTime()) + ")</i><br />");

        // Indique si l'ID de session provient d'un cookie
        out.println("ID session demand� provient d'un cookie (isRequestedSessionIdFromCookie()) : " 
        		+ req.isRequestedSessionIdFromCookie() + "<br />");
        
        // Indique si l'ID de session provient de l'URL
        out.println("ID session demand� provient de l'URL (isRequestedSessionIdFromURL() ) : " 
        		+ req.isRequestedSessionIdFromURL() + "<br />");
        
        // Indique si  l'ID de session de la requ�te est toujours valide
        out.println("ID session demand� dans requ�te est valide (isRequestedSessionIdValid()) : " 
        		+ req.isRequestedSessionIdValid() + "<br />");
        
        // Appel de la servlet ServletSession2 c'est � dire cette servlet
        // R� encodage de l'URL avec encodeURL() pour garder l'id de session
        out.println("<h3>Test de la r��criture d'URL</h3>");
        out.println("<p>Retour de req.getRequestURI() : " + req.getRequestURI() + "</p>");
        out.println("Cliquez <a href=\"" + res.encodeURL(req.getRequestURI()) + "\">ici</a>");
        out.println("pour tester que le tracking de session fonctionne via la r��criture d'URL ");
        out.println("m�me si les cookies ne sont pas support�s.<br />");

        // Appel de la servlet ServletSession3
        // R� encodage de l'URL avec encodeURL() pour garder l'id de session
        // Si cookies autoris�s -> m�me session dans les 2 cas
        out.println("Context path : " + req.getContextPath() + "<br />");
        out.print("<a href=\"" + res.encodeURL(req.getContextPath() + "/ServletSession3") + "\">Executer ServletSession3</a><br />");
       
        // Appel de la servlet ServletSession3
        out.println("<a href=\"ServletSession3\">Executer ServletSession3 sans EncodeURL</a><br />");
        
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