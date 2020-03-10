/**
 * 
 */
package controleur.commandes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import manager.ClientManager;

/**
 * | @Author : @Fred || 4 mars 2020 || 15:07:51 | *
 *
 */
public class DisplayCustomer1 implements ICommand {
	ClientManager manager;
	// Liste des clients
	List<Client> customers;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		manager = (ClientManager) request.getServletContext().getAttribute("manager");
		// R�cup�rer l'id du client a afficher
		String id = request.getParameter("id");

		// R�cup�rer le bean client (objet m�tier) correspondant � l'id
		Client customer = manager.getCustomer(id);

		// Positionner le bean client comme attribut de requ�te
		// Attribut utilis� par la page jsp
		request.setAttribute("customer", customer);
		
		// Prochaine page JSP � retourner au navigateur
		String jspPage = "/pagesclient/afficherClientSansJSTL.jsp";
		  if (jspPage != null)
				request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);
	}
}
