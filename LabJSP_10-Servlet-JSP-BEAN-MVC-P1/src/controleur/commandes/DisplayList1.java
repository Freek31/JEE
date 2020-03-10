/**
 * 
 */
package controleur.commandes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import manager.ClientManager;

/**
 * | @Author : @Fred || 3 mars 2020 || 11:13:17 | *
 *
 */
public class DisplayList1 implements ICommand{
	

	ClientManager manager;
	// Liste des clients
	List<Client> customers;
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		customers = (List<Client>)request.getServletContext().getAttribute("customers");	
    		
    		// Prochaine page JSP à retourner au navigateur
    		String jspPage = "/pagesclient/afficherListeClientsSansJSTL.jsp";
    		request.setAttribute("customers", customers);
	
		 // Envoyer la page correspondante à la demande
	  	if (jspPage != null)
            request.getServletContext().getRequestDispatcher(jspPage).forward(request,response);
		
		}
}
