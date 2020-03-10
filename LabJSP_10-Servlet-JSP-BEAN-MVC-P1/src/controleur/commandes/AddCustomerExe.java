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
 * | @Author : @Fred || 3 mars 2020 || 16:11:19 | *
 *
 */
public class AddCustomerExe implements ICommand {
	// Manager qui permet de g�rer la liste des clients
	//ClientManager manager;
	// Liste des clients
	List<Client> customers;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addcustomerexe");
		// R�cup�ration par la requ�te des param�tres saisis
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String adresse = request.getParameter("address");
		String codepostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		//manager = (ClientManager) request.getServletContext().getAttribute("manager");
System.out.println(firstname);
		// Positionner la liste des clients comme attribut de requ�te
		// Attribut utilis� par la page jsp
		//	customers = (List<Client>) request.getServletContext().getAttribute("customers");
		ClientService serviceClient = new ClientService();
		try {
			serviceClient.addClient(firstname, lastname, adresse, codepostal, ville);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Ajout du client � la liste
		//manager.addCustomer(firstname, lastname, adresse);

		// R�cup�rer la liste des clients g�r�e par le manager
		try {
			customers = serviceClient.getListeClients();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Positionner la liste des clients comme attribut de requ�te
		// Attribut utilis� par la page jsp
		request.setAttribute("customers", customers);

		// Prochaine page JSP � retourner au navigateur
		String jspPage = "/pagesclient/afficherListeClientsSansJSTL.jsp";
		if (jspPage != null)
			request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);

		
		
	}
}
