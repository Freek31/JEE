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
import manager.ClientManager;
/**
 * | @Author : @Fred || 3 mars 2020 || 10:09:18 | *
 *
 */
public class CreateList implements ICommand  {
	/**
	 * 
	 */
	
	// Manager qui permet de g�rer la liste des clients
	ClientManager manager, manager1;
//	// Liste des clients
	List<Client> customers;
	int cpt;
	//private static final Logger logger = LoggerFactory.getLogger("compteur");
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
     	// Cr�ation du manager qui g�re la liste des clients
        //manager =ClientManager.getInstance();
        //manager1 = ClientManager.getInstance();
       // request.getServletContext().setAttribute("manager", this.manager);
        
        
        // G�n�rer la liste des clients
       // customers = manager.createCustomers();
        request.getServletContext().setAttribute("customers", this.customers);
        System.out.println(customers);
        
       
        //  logger.info( "Hashcode :" + manager.hashCode());
        // logger.info( "Hashcode :" + manager1.hashCode());
		// Prochaine page JSP � retourner au navigateur
		String jspPage = "/accueil/index.jsp";
		// Envoyer la page correspondante � la demande
		if (jspPage != null)
		request.getServletContext().getRequestDispatcher(jspPage).forward(request, response);

		// request.setAttribute("modelBean", modelBean);
		// ServletContext context = request.getServletContext();
		// context.getRequestDispatcher(jspPage).forward(request, response);
	}

}
