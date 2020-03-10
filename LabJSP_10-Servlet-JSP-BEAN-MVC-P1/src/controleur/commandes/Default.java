/**
 * 
 */
package controleur.commandes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * | @Author : @Fred || 3 mars 2020 || 15:20:33 | *
 *
 */
public class Default implements ICommand {
	

	// request.setAttribute("manager", manager);
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPage = "/accueil/index.jsp";
		// Envoyer la page correspondante à la demande
		if (jspPage != null)
			request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);

	}
}
