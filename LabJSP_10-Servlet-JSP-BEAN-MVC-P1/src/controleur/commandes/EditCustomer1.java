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
 * | @Author : @Fred || 4 mars 2020 || 15:18:38 | *
 *
 */
public class EditCustomer1 implements ICommand {

	ClientManager manager;
	// Liste des clients
	List<Client> customers;
	
	HttpSession m_session;


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer l'id du client à éditer
		String id = request.getParameter("id");
		
		//recup manager
		manager = (ClientManager) request.getServletContext().getAttribute("manager");
		
		//recup de la session
		m_session = request.getSession(true);
		
		// Récupérer le bean client (objet métier) correspondant à l'id
		Client customer = manager.getCustomer(id);

		// Positionner le bean client comme attribut de requête
		// Attribut utilisé par la page jsp
		request.setAttribute("customer", customer);
		m_session.setAttribute("customer", customer);

		// Prochaine page JSP à retourner au navigateur
		String jspPage = "/pagesclient/editerClientSansJSTL.jsp";
		if (jspPage != null)
            request.getServletContext().getRequestDispatcher(jspPage).forward(request,response);
	}
}
