package controleur;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import manager.ClientManager;

/**
 * 
 * @author Pascal
 *
 */
@SuppressWarnings("serial")
public class SimpleControleur extends HttpServlet
{
	// Manager qui permet de gérer la liste des clients
	ClientManager manager;
	
	// Liste des clients
	List<Client> customers;

    protected void doProcess(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    { 	 
    	HttpSession m_session;
    	
    	// Récupération de la session
    	m_session = request.getSession(true);
    	// Durée de la session = 1H
    	m_session.setMaxInactiveInterval(3600);
    	
    	// Récupération du contexte
    	//ServletContext context = this.getServletContext();
    	
    	// Récupération de l'action demandée
        String action = request.getParameter("action");
        
        // Par défaut page d'accueil
        String jspPage = "/accueil/index.jsp";

        // SI aucune action définie dans la requête 
        // ALORS action=default
        if ((action.isEmpty())){
            action = "default";
        }

        if ("default".equals(action)){
        	// Prochaine page JSP à retourner au navigateur
            jspPage = "/accueil/index.jsp";
        }
        // Demande d'affichage de la liste des clients avec JSTL
        else if ("displaylist".equals(action))
        {
        	// Si le manager a été créé
        	if (manager != null) {
        		// Récupérer la liste des clients gérée par le manager
        		customers = manager.getCustomers();
        		
                // Positionner la liste des clients comme attribut de requête 
                // Attribut utilisé par la page jsp
        		request.setAttribute("customers", customers);
        		
        		// Prochaine page JSP à retourner au navigateur
        		jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp"; 
        	}
        	else
        		// Prochaine page JSP à retourner au navigateur
        		jspPage = "/erreurs/afficherErreurListe.jsp";
        }
        // Demande d'affichage de la liste des clients sans JSTL
        else if ("displaylist1".equals(action))
        {
        	if (manager != null) {
        		// Récupérer la liste des clients gérée par le manager
        		customers = manager.getCustomers();
        		
                // Positionner la liste des clients comme attribut de requête 
                // Attribut utilisé par la page jsp
        		request.setAttribute("customers", customers);
        		
        		// Prochaine page JSP à retourner au navigateur
        		jspPage = "/pagesclient/afficherListeClientsSansJSTL.jsp";
        	}
        	else
        		// Prochaine page JSP à retourner au navigateur
        		jspPage = "/erreurs/afficherErreurListe.jsp";
        }
        // Demande de création de la liste des clients
        else if ("createlist".equals(action))
        {
        	// Création du manager qui gère la liste des clients
        	manager =ClientManager.getInstance();
            
            // Générer la liste des clients
            customers = manager.createCustomers();
            
            // Positionner la liste des clients comme attribut de requête 
            // Attribut utilisé par la page jsp
            //request.setAttribute("customers", customers);

            // Prochaine page JSP à retourner au navigateur
            jspPage = "/accueil/index.jsp";
        }
        // Demande d'affichage des informations d'un client (Avec JSTL)
        else if ("displaycustomer".equals(action))
        {
        	// Récupérer l'id du client a afficher
            String id = request.getParameter("id");
            
            // Récupérer le bean client (objet métier) correspondant à l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requête 
            // Attribut utilisé par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/afficherClientAvecJSTL.jsp";
        }
        // Demande d'affichage des informations d'un client (Sans JSTL)
        else if ("displaycustomer1".equals(action))
        {
        	// Récupérer l'id du client a afficher
            String id = request.getParameter("id");
            
            // Récupérer le bean client (objet métier) correspondant à l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requête 
            // Attribut utilisé par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/afficherClientSansJSTL.jsp";
        }
        // Demande d'édition des informations d'un client (avec JSTL)
        else if ("editcustomer".equals(action))
        {
        	// Récupérer l'id du client à éditer
            String id = request.getParameter("id");
            
            // Récupérer le bean client (objet métier) correspondant à l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requête 
            // Attribut utilisé par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/editerClientAvecJSTL.jsp";            
        }
        // Demande d'édition des informations d'un client (sans JSTL)
        else if ("editcustomer1".equals(action))
        {
        	// Récupérer l'id du client à éditer
            String id = request.getParameter("id");
            
            // Récupérer le bean client (objet métier) correspondant à l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requête 
            // Attribut utilisé par la page jsp
            request.setAttribute("customer", customer);
            m_session.setAttribute("customer", customer);
            
            // Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/editerClientSansJSTL.jsp";  
        }
        // Demande d'édition des informations d'un client (sans JSTL et avec notation EL)
        else if ("editcustomer2".equals(action))
        {
        	// Récupérer l'id du client à éditer
            String id = request.getParameter("id");
            
            // Récupérer le bean client (objet métier) correspondant à l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requête 
            // Attribut utilisé par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/editerClientSansJSTLavecEL.jsp";  
        }
        else if ("addcustomer".equals(action))
        {
        	// Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/ajouterClientSansJSTL.jsp";
        }
        // Demande de modification des informations d'un client
        else if ("editcustomerexe".equals(action))
        {
        	// Récupérer les données du formulaire
        	int id = Integer.parseInt(request.getParameter("id"));
        	String firstname = request.getParameter("firstname");
        	String lastname = request.getParameter("lastname");
        	String adresse = request.getParameter("address");
        	
          	// Ajouter le nouveau client à la liste des clients gérée par le
        	// manager
        	manager.setCustomer(id, firstname, lastname, adresse);
        	
        	/* En passant les paramètres au manager par l'intermédiaire d'un bean
        	Client mycust = new Client();
        	mycust.setId(request.getParameter("id"));
        	mycust.setFirstName(firstname);
        	mycust.setLastName(lastname);
        	mycust.setAddress(adresse);
        	manager.setCustomer(mycust); 
        	*/

        	// Récupérer la liste des clients gérée par le manager
        	customers = manager.getCustomers();
        	
            // Positionner la liste des clients comme attribut de requête 
            // Attribut utilisé par la page jsp
        	request.setAttribute("customers", customers);
        	
        	// Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp";
        }
        // Demande d'ajout d'un client
        else if ("addcustomerexe".equals(action))
        {
        	System.out.println ("addcustomerexe");
        	// Récupération par la requête des paramètres saisis
        	String firstname = request.getParameter("firstName");
        	String lastname = request.getParameter("lastName");
        	String adresse = request.getParameter("address");   	
        	
        	// Ajout du client à la liste
        	manager.addCustomer(firstname, lastname, adresse);
        		
        	// Récupérer la liste des clients gérée par le manager
        	customers = manager.getCustomers();
        	
            // Positionner la liste des clients comme attribut de requête 
            // Attribut utilisé par la page jsp
        	request.setAttribute("customers", customers);
        	
        	// Prochaine page JSP à retourner au navigateur
            jspPage = "/pagesclient/afficherListeClientsSansJSTL.jsp";
        }
        // Envoyer la page correspondante à la demande
        dispatch(jspPage, request, response);
    }
    /**
     * 
     * @param jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void dispatch(String jsp, HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
    	// SI une page jsp a été définie
        if (jsp != null)
            getServletContext().getRequestDispatcher(jsp).forward(request,response);
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
    	doProcess(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    	doProcess(request, response);
    }
}
