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
 * | @Author : @Fred || 3 mars 2020 || 16:25:27 | *
 *
 */
public class DisplayCustomer implements ICommand{
	//ClientManager manager;
	// Liste des clients
	List<Client> customers;
	Client customer;
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//manager = (ClientManager) request.getServletContext().getAttribute("manager");

		// Positionner la liste des clients comme attribut de requête
		// Attribut utilisé par la page jsp
		//customers = (List<Client>) request.getServletContext().getAttribute("customers");
		// Récupérer l'id du client a afficher
		int id = Integer.parseInt(request.getParameter("id")) ;
        
        ClientService serviceClient = new ClientService();
		// Positionner le bean client comme attribut de requête
		// Attribut utilisé par la page jsp
       
		try {
			customer =serviceClient.getClient(id);
			System.out.println(customer);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Positionner le bean client comme attribut de requête 
        // Attribut utilisé par la page jsp
        request.setAttribute("customer", customer);
        System.out.println(customer);
        // Prochaine page JSP à retourner au navigateur
        String jspPage = "/pagesclient/afficherClientAvecJSTL.jsp";
        
        if (jspPage != null)
			request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);

	}
}
