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
import service.exceptions.ServiceException;
import service.impl.ClientService;

/**
 * | @Author : @Fred || 4 mars 2020 || 15:52:02 | *
 *
 */
public class RemoveCustomer implements ICommand {
	// Manager qui permet de g�rer la liste des clients
	ClientManager manager;
	// Liste des clients
	List<Client> customers;


	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//manager = (ClientManager) request.getServletContext().getAttribute("manager");

		// Positionner la liste des clients comme attribut de requ�te
		// Attribut utilis� par la page jsp
		//customers = (List<Client>) request.getServletContext().getAttribute("customers");
		ClientService serviceClient = new ClientService();
		
		// R�cup�ration par la requ�te des param�tres saisis
		int id = Integer.parseInt(request.getParameter("id")) ;
		// R�cup�rer le bean client (objet m�tier) correspondant � l'id
		//Client customer = manager.getCustomer(id);
		try {
			serviceClient.delClient(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Supprimer le bean client ave id de la list
		
		try {
			customers= serviceClient.getListeClients();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("customers", customers);
		

	// Prochaine page JSP � retourner au navigateur
	String jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp";
	if (jspPage != null)
		request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);

	}
}
