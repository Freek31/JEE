/**
 * 
 */
package controleur;

import javax.servlet.*;
import javax.servlet.http.*;

import controleur.commandes.AddCustomer;
import controleur.commandes.AddCustomerExe;
import controleur.commandes.CreateList;
import controleur.commandes.Default;
import controleur.commandes.DisplayCustomer;
import controleur.commandes.DisplayCustomer1;
import controleur.commandes.DisplayList;
import controleur.commandes.DisplayList1;
import controleur.commandes.EditCustomer;
import controleur.commandes.EditCustomer1;
import controleur.commandes.EditCustomer2;
import controleur.commandes.EditCustomerExe;
import controleur.commandes.ICommand;
import controleur.commandes.RemoveCustomer;
import dao.exceptions.DAOException;

import java.io.*;
import java.util.Map;
import java.util.HashMap;



/**
 * | @Author : @Fred || 3 mars 2020 || 09:52:13 | *
 *
 */

@SuppressWarnings("serial")
public class PatternCommand extends HttpServlet {

	// Manager qui permet de gérer la liste des clients
	//ClientManager manager;
	
	// Liste des clients
	//List<Client> customers;
	// Collection de commandes
	// Remplie lors de la phase d'initialisation de la servlet
	private Map<String, ICommand> commands = new HashMap<String, ICommand>();
	

	public void init() {

		// Ajouter les commandes à la collection de commandes
		this.commands.put("createlist", new CreateList());
		this.commands.put("displaylist", new DisplayList());
		this.commands.put("displaylist1", new DisplayList1());
		this.commands.put("accueil", new Default());
		this.commands.put("addcustomer", new AddCustomer());
		this.commands.put("addcustomerexe", new AddCustomerExe());
		this.commands.put("editcustomer", new EditCustomer());
		this.commands.put("editcustomerexe", new EditCustomerExe());
		this.commands.put("editcustomer1", new EditCustomer1());
		this.commands.put("editcustomer2", new EditCustomer2());
		this.commands.put("displaycustomer", new DisplayCustomer());
		this.commands.put("displaycustomer1", new DisplayCustomer1());
		this.commands.put("removecustomer", new RemoveCustomer());

		
	}

	public void processCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DAOException {

		HttpSession m_session;
    	
    	// Récupération de la session
    	m_session = request.getSession(true);
    	// Durée de la session = 1H
    	m_session.setMaxInactiveInterval(3600);
    	
    	// Récupération du contexte
    	//ServletContext context = this.getServletContext();
    	
    	// Récupération de l'action demandée
        String action = request.getParameter("action");
 
        // Récupérer la commande dans la table des commandes
        ICommand command = (ICommand)commands.get(action); 
        if(command == null){
        	// Lever une exception
            throw new IllegalArgumentException(
                "No command for form action : " + action);
        }
        
        
		// Exécuter la commande correspondante
		command.execute(request, response);

		
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			processCommand(request, response);
		} catch (ServletException | IOException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			processCommand(request, response);
		} catch (ServletException | IOException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}