package servlets;

import java.io.*;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.*;
import javax.servlet.*;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {
	private ServletConfig cfg;
	
	@SuppressWarnings("unchecked")
	public void doProcess (HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
	  
		// Positionner le type mime du corps de  la réponse qui sera envoyée au navigateur
		// text/html pour du HTML, texte/plain pour du texte brut,  application/pdf pour un fichier pdf
		res.setContentType ("text/html");		
		
	    
		// Créer un objet PrinterWriter permettant d'écrire des données au format texte dans
		// la réponse
		PrintWriter out = res.getWriter();	
		
		// Ecrire dans le flux
	    out.println( "<html>" );
	    out.println( "<head>");
	    out.println( "<title>Page generee par une servlet</title>" );
	    out.println( "</head>" );
	    out.println( "<body >" );
	    out.println( "<h1>LabSERVLET_16 : Wrapper</h1>" );
	    out.println("<p>Nom de la servlet : " + cfg.getServletName() + "</p>");
	    
	    out.println("<p>INFOS SUR L'EN-TETE</p>");
	    
	    // Retourne l'ensemble des noms des en-têtes contenus dans la requête
	    Enumeration<String> enTetes = req.getHeaderNames();

	    // Affichage du contenu
	    while (enTetes.hasMoreElements()) {
	    	// Récupération du nom
	    	String nomEntete = enTetes.nextElement();

	    	// getHeader() retourne la valeur du nom de l'en-tête passé en paramètre
	    	out.println("<p>" + nomEntete + " : " + req.getHeader(nomEntete) + " : "  + "</p>");
	    }
	    
        out.print("<a href=\"" + res.encodeURL(req.getContextPath() + "/Servlet1") + "\">Executer Servlet1</a><br />");
   
	    out.println( "</body>" );
	    out.println( "</html>" );
	    
	    // Vider le flux
	    out.flush();
	    
	    // Fermeture du flux
	    out.close();
	}
  
	public void init(ServletConfig config) throws ServletException {
		
		// Si redéfinition de la méthode init(ServletConfig), vous devez soit mémoriser le servletConfig, 
		// Soit ctx = cfg.getServletContext();
		
		// ou appeler la méthode init() de la classe parents (HttpServlet)
		// Soit super.init(cfg);

		super.init(config);
	    cfg = config;
	}
	
	// Traitement d'un formulaire transmis par la méthode GET ou
	// Traitement d'un lien de type <a></a>
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// Traitement d'un formulaire transmis par la méthode POST
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
	        doProcess(request, response);
	}
}
