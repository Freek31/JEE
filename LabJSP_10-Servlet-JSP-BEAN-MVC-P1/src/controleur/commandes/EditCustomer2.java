/**
 * 
 */
package controleur.commandes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import manager.ClientManager;

/**
 * | @Author : @Fred || 4 mars 2020 || 15:40:07 | *
 *
 */
public class EditCustomer2 implements ICommand {
	ClientManager manager;
	// Liste des clients
	List<Client> customers;

	HttpSession m_session;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recup manager
		manager = (ClientManager) request.getServletContext().getAttribute("manager");
		
		// R�cup�rer l'id du client � �diter
		String id = request.getParameter("id");

		// R�cup�rer le bean client (objet m�tier) correspondant � l'id
		Client customer = manager.getCustomer(id);

		// Positionner le bean client comme attribut de requ�te
		// Attribut utilis� par la page jsp
		request.setAttribute("customer", customer);

		// Prochaine page JSP � retourner au navigateur
		String jspPage = "/pagesclient/editerClientSansJSTLavecEL.jsp";
		if (jspPage != null)
            request.getServletContext().getRequestDispatcher(jspPage).forward(request,response);
	}
}
