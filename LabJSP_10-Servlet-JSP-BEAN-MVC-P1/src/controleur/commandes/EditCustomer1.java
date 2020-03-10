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
		// R�cup�rer l'id du client � �diter
		String id = request.getParameter("id");
		
		//recup manager
		manager = (ClientManager) request.getServletContext().getAttribute("manager");
		
		//recup de la session
		m_session = request.getSession(true);
		
		// R�cup�rer le bean client (objet m�tier) correspondant � l'id
		Client customer = manager.getCustomer(id);

		// Positionner le bean client comme attribut de requ�te
		// Attribut utilis� par la page jsp
		request.setAttribute("customer", customer);
		m_session.setAttribute("customer", customer);

		// Prochaine page JSP � retourner au navigateur
		String jspPage = "/pagesclient/editerClientSansJSTL.jsp";
		if (jspPage != null)
            request.getServletContext().getRequestDispatcher(jspPage).forward(request,response);
	}
}
