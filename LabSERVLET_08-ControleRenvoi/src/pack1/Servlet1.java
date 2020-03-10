package pack1;
/**
	Collaboration de servlets : partage de contr�le
	Distribuer un renvoi
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Servlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		// Positionner un attribut sur la requ�te
		// Cet attribut sera lu par la servlet Servlet2
		req.setAttribute("attribut1", "200");
		
		// Ne pas effectuer de modification sur la r�ponse avant un renvoi par forward()
		
		/* getRequestDispatcher (path) : Returns a RequestDispatcher object that acts as a wrapper for the resource
		located at the given path. A RequestDispatcher object can be used to forward
		a request to the resource or to include the resource in a response. The
		resource can be dynamic (servlet, jsp) or static (page HTML). */

		// Retourne une instance de type RequestDispatcher par rapport � la servletServlet2
		// Passer un attribut � la servlet. Cet attribut sera lu par la servlet Servlet2
		RequestDispatcher disp = req.getRequestDispatcher("/Servlet2?attribut2=ok");

		/* The forward method of the RequestDispatcher interface may be called by the
		calling servlet only when no output has been committed to the client. If output data
		exists in the response buffer that has not been committed, the content must be
		cleared before the target servlet�s service method is called. If the response has been
		committed, an IllegalStateException must be thrown.*/
		
		/* forward(ServletRequest request, ServletResponse response) 
		Rediriger la requ�te vers une autre ressource sur le m�me serveur
		Cette ressource peut �tre une Servlet, une page JSP ou une simple page HTML . */
		disp.forward(req,res);
		
		// Apres le forward, ne rien faire sur req (requ�te) et res(r�ponse)
	}
}

