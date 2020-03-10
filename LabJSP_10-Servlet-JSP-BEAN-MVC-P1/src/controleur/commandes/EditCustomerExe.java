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
 * | @Author : @Fred || 3 mars 2020 || 16:28:36 | *
 *
 */
public class EditCustomerExe implements ICommand {
	ClientManager manager;
	// Liste des clients
	List<Client> customers;

	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		manager = (ClientManager) request.getServletContext().getAttribute("manager");

		// Positionner la liste des clients comme attribut de requ�te
		// Attribut utilis� par la page jsp
		customers = (List<Client>) request.getServletContext().getAttribute("customers");
		// R�cup�rer les donn�es du formulaire
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String adresse = request.getParameter("address");

		// Ajouter le nouveau client � la liste des clients g�r�e par le
		// manager
		manager.setCustomer(id, firstname, lastname, adresse);

		/*
		 * En passant les param�tres au manager par l'interm�diaire d'un bean Client
		 * mycust = new Client(); mycust.setId(request.getParameter("id"));
		 * mycust.setFirstName(firstname); mycust.setLastName(lastname);
		 * mycust.setAddress(adresse); manager.setCustomer(mycust);
		 */

		// R�cup�rer la liste des clients g�r�e par le manager
		customers = manager.getCustomers();

		// Positionner la liste des clients comme attribut de requ�te
		// Attribut utilis� par la page jsp
		request.setAttribute("customers", customers);

		// Prochaine page JSP � retourner au navigateur
		String jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp";
		 if (jspPage != null)
				request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);
	}
}
