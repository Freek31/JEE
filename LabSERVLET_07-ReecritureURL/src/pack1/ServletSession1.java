package pack1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitaires.Utils;

/*
 * Forward()	
When we use the forward() method, the request is transferred to 
other resources within the same server for further processing	

SendRedirect()
In case of sendRedirect() method, the request is transferred to 
another resource to a different domain or the different server 
for further processing


Forward()
In case of forward(), the web-container handles all the 
process internally and the client or browser is not involved

SendRedirect()
When developers use the sendRedirect(), the web-container transfers 
the request to a client or a browser so that the URL given inside 
the sendRedirect() method is visible as a new request to the client

Forward()
When the forward() method is called on the Request Dispatcher object, 
developers pass the request and response object so that the old request 
object is present in the new resource which is going to process the request

SendRedirect()
In case of sendRedirect() call, the old request and response object 
is lost because it is treated as a new request by the browser

Forward()
The forward() method is faster than the sendRedirect()

SendRedirect()
sendRedirect() is slower as one extra round trip is required i.e. 
The complete new request is created and the old request object is lost

Forward()
When we redirect using the forward() method and developers want 
to use the same data in a new resource they can use 
the request.setAttribute() as we have the request object available

SendRedirect()
In case of sendRedirect() call, if developers want to store the 
data they will do it in a Session object or pass it along 
the value with the URL

 */

public class ServletSession1 extends HttpServlet
{
	private static final long serialVersionUID = -1031966908477155121L;
	
	public void doProcess (HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
    {
	
		System.out.println ("Début Servlet1");
		
		// Récupérer ou créer l’objet session associé à la requête cliente
		// Paramètre : true ou rien = la session est récupérée ou créée automatiquement si elle n’existe pas
		//req.getSession(true);
  
		// Positionnement du type Mime du corps de la réponse
		//res.setContentType("text/html");
	    
	    // Récupération d'un printWriter (package java.io)
	    //PrintWriter out = res.getWriter();
	   
	    // Ecrire le début de la page HTML retournée
	    //Utils.ecritDebut(out,"Suivi de session : Reecriture d'URL");
	    
	    /* Ces méthodes réécrivent l'URL uniquement si le client n'accepte pas
	    les cookies. Dans l'autre cas l'URL reste inchangée
	    Limitations des 2 approches : pas de données volumineuses,
	    caractères non autorisés, longueur URL, données visibles (sécurité) */
	    
	    // The sendRedirect() method of HttpServletResponse interface can be 
		// used to redirect response to another resource, 
		// it may be servlet, jsp or html file.
	    // http://localhost:8081/LabSERVLET_07/ServletSession2;jsessionid=867BD8BE3CA2D595B8281C8654A043E2
	    // Avec sendRedirect() il faut utiliser encodeRedirectURL()
	    res.sendRedirect(res.encodeRedirectURL("ServletSession2"));
	    
	    System.out.println ("Fin Servlet1");
	    // Ecrire la fin de la page HTML retournée
	    //Utils.ecritFin(out);
	    
	    // Vider le flux
	    //out.flush();
	    
	    // Fermeture du flux
	    //out.close();
    }
  
	// SI requête de type GET -> appeler doProcess()
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	  			throws ServletException, IOException {
					doProcess(req, res);
	}
	
	// SI requête de type POST -> appeler doProcess()
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			doProcess(req, res);
	}

}