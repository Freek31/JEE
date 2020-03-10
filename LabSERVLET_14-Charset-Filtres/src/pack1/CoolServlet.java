package pack1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

@SuppressWarnings("serial")
public class CoolServlet extends HttpServlet {
	private ServletConfig cfg;
	
	public void doPost (HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
	  
		/* 
		String encoding = req.getCharacterEncoding();	
		if (encoding == null || !encoding.equals("UTF-8")) {
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
					System.err.println("HttpMultipartRequest - : " + e);
				}
		} */
	 

		// Positionnement du type Mime du corps de la réponse
        res.setContentType("text/html");
        
		PrintWriter out = res.getWriter();
		
	    out.println( "<html>" );
	    out.println( "<head>");
	    out.println( "<title>Page générée par une servlet</title>" );
	    out.println( "</head>" );
	    out.println( "<body >" );
	    out.println( "<h1>LabSERVLET_01 : héritage HttpServlet</h1>" );
	    out.println("<p>Nom de la servlet : " + cfg.getServletName() + "</p>");
	    
	    // Récupération du parametre positionné dans web.xml
	    out.println( "<p>Parametre d'initialisation : " + cfg.getInitParameter("param1") + "</p>");
	    
	    // ContextPath : le chemin du contexte de déploiement
	    // ServletPath : la section du chemin qui a déclenché le mapping
	    // PathInfo : la partie de la requête qui n’est ni le ContextPath ni le ServletPath

	    out.println("<p>Context Path : " +  req.getContextPath() +  "</p>");
	    out.println("<p>Servlet Path : " +  req.getServletPath() +  "</p>");
	    out.println("<p>Path Info : " +  req.getPathInfo() +  "</p>");

	    ServletContext scontext = cfg.getServletContext(); 
	    out.println("<p>Document root : " + scontext.getRealPath("/ ") + "</p>");
	    
	    out.println("<p>Nom et version du conteneur : " + scontext.getServerInfo() + "</p>");

	    out.println("<p>Version API Servlets : " + scontext.getMajorVersion() + "." + scontext.getMinorVersion() + "</p>");
	    out.println( "</body>" );
	    out.println( "</html>" );
	    out.close();
	}
  
	public void init(ServletConfig config) throws ServletException {
	     cfg = config;
	}
  
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	}
}
