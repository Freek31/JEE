/**
 * 
 */
package controleur.commandes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import beans.Client;
import controleur.PatternCommand;
import dao.exceptions.DAOException;
import dao.impl.ClientDAO;
import manager.ClientManager;
import service.exceptions.ServiceException;
import service.impl.ClientService;

/**
 * | @Author : @Fred || 3 mars 2020 || 10:43:37 | *
 *
 */
public class DisplayList implements ICommand {
	//ClientManager manager;
	List<Client> customers;
	private static final Logger logger = LoggerFactory.getLogger(DisplayList.class);
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
		
		//manager = (ClientManager) request.getServletContext().getAttribute("manager");
		ClientService serviceClient = new ClientService();
		try {
			customers= serviceClient.getListeClients();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Positionner la liste des clients comme attribut de requête
		// Attribut utilisé par la page jsp
		//customers = (List<Client>) request.getServletContext().getAttribute("customers");

		request.setAttribute("customers", customers);

		// Prochaine page JSP à retourner au navigateur
		String jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp";

		// request.setAttribute("manager", manager);
		 logger.info("createlist :" + customers);
		// Envoyer la page correspondante à la demande
		if (jspPage != null)
			request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);

	}
}
