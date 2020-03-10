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
	// Manager qui permet de g�rer la liste des clients
	ClientManager manager;
	
	// Liste des clients
	List<Client> customers;

    protected void doProcess(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    { 	 
    	HttpSession m_session;
    	
    	// R�cup�ration de la session
    	m_session = request.getSession(true);
    	// Dur�e de la session = 1H
    	m_session.setMaxInactiveInterval(3600);
    	
    	// R�cup�ration du contexte
    	//ServletContext context = this.getServletContext();
    	
    	// R�cup�ration de l'action demand�e
        String action = request.getParameter("action");
        
        // Par d�faut page d'accueil
        String jspPage = "/accueil/index.jsp";

        // SI aucune action d�finie dans la requ�te 
        // ALORS action=default
        if ((action.isEmpty())){
            action = "default";
        }

        if ("default".equals(action)){
        	// Prochaine page JSP � retourner au navigateur
            jspPage = "/accueil/index.jsp";
        }
        // Demande d'affichage de la liste des clients avec JSTL
        else if ("displaylist".equals(action))
        {
        	// Si le manager a �t� cr��
        	if (manager != null) {
        		// R�cup�rer la liste des clients g�r�e par le manager
        		customers = manager.getCustomers();
        		
                // Positionner la liste des clients comme attribut de requ�te 
                // Attribut utilis� par la page jsp
        		request.setAttribute("customers", customers);
        		
        		// Prochaine page JSP � retourner au navigateur
        		jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp"; 
        	}
        	else
        		// Prochaine page JSP � retourner au navigateur
        		jspPage = "/erreurs/afficherErreurListe.jsp";
        }
        // Demande d'affichage de la liste des clients sans JSTL
        else if ("displaylist1".equals(action))
        {
        	if (manager != null) {
        		// R�cup�rer la liste des clients g�r�e par le manager
        		customers = manager.getCustomers();
        		
                // Positionner la liste des clients comme attribut de requ�te 
                // Attribut utilis� par la page jsp
        		request.setAttribute("customers", customers);
        		
        		// Prochaine page JSP � retourner au navigateur
        		jspPage = "/pagesclient/afficherListeClientsSansJSTL.jsp";
        	}
        	else
        		// Prochaine page JSP � retourner au navigateur
        		jspPage = "/erreurs/afficherErreurListe.jsp";
        }
        // Demande de cr�ation de la liste des clients
        else if ("createlist".equals(action))
        {
        	// Cr�ation du manager qui g�re la liste des clients
        	manager =ClientManager.getInstance();
            
            // G�n�rer la liste des clients
            customers = manager.createCustomers();
            
            // Positionner la liste des clients comme attribut de requ�te 
            // Attribut utilis� par la page jsp
            //request.setAttribute("customers", customers);

            // Prochaine page JSP � retourner au navigateur
            jspPage = "/accueil/index.jsp";
        }
        // Demande d'affichage des informations d'un client (Avec JSTL)
        else if ("displaycustomer".equals(action))
        {
        	// R�cup�rer l'id du client a afficher
            String id = request.getParameter("id");
            
            // R�cup�rer le bean client (objet m�tier) correspondant � l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ�te 
            // Attribut utilis� par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/afficherClientAvecJSTL.jsp";
        }
        // Demande d'affichage des informations d'un client (Sans JSTL)
        else if ("displaycustomer1".equals(action))
        {
        	// R�cup�rer l'id du client a afficher
            String id = request.getParameter("id");
            
            // R�cup�rer le bean client (objet m�tier) correspondant � l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ�te 
            // Attribut utilis� par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/afficherClientSansJSTL.jsp";
        }
        // Demande d'�dition des informations d'un client (avec JSTL)
        else if ("editcustomer".equals(action))
        {
        	// R�cup�rer l'id du client � �diter
            String id = request.getParameter("id");
            
            // R�cup�rer le bean client (objet m�tier) correspondant � l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ�te 
            // Attribut utilis� par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/editerClientAvecJSTL.jsp";            
        }
        // Demande d'�dition des informations d'un client (sans JSTL)
        else if ("editcustomer1".equals(action))
        {
        	// R�cup�rer l'id du client � �diter
            String id = request.getParameter("id");
            
            // R�cup�rer le bean client (objet m�tier) correspondant � l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ�te 
            // Attribut utilis� par la page jsp
            request.setAttribute("customer", customer);
            m_session.setAttribute("customer", customer);
            
            // Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/editerClientSansJSTL.jsp";  
        }
        // Demande d'�dition des informations d'un client (sans JSTL et avec notation EL)
        else if ("editcustomer2".equals(action))
        {
        	// R�cup�rer l'id du client � �diter
            String id = request.getParameter("id");
            
            // R�cup�rer le bean client (objet m�tier) correspondant � l'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ�te 
            // Attribut utilis� par la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/editerClientSansJSTLavecEL.jsp";  
        }
        else if ("addcustomer".equals(action))
        {
        	// Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/ajouterClientSansJSTL.jsp";
        }
        // Demande de modification des informations d'un client
        else if ("editcustomerexe".equals(action))
        {
        	// R�cup�rer les donn�es du formulaire
        	int id = Integer.parseInt(request.getParameter("id"));
        	String firstname = request.getParameter("firstname");
        	String lastname = request.getParameter("lastname");
        	String adresse = request.getParameter("address");
        	
          	// Ajouter le nouveau client � la liste des clients g�r�e par le
        	// manager
        	manager.setCustomer(id, firstname, lastname, adresse);
        	
        	/* En passant les param�tres au manager par l'interm�diaire d'un bean
        	Client mycust = new Client();
        	mycust.setId(request.getParameter("id"));
        	mycust.setFirstName(firstname);
        	mycust.setLastName(lastname);
        	mycust.setAddress(adresse);
        	manager.setCustomer(mycust); 
        	*/

        	// R�cup�rer la liste des clients g�r�e par le manager
        	customers = manager.getCustomers();
        	
            // Positionner la liste des clients comme attribut de requ�te 
            // Attribut utilis� par la page jsp
        	request.setAttribute("customers", customers);
        	
        	// Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/afficherListeClientsAvecJSTL.jsp";
        }
        // Demande d'ajout d'un client
        else if ("addcustomerexe".equals(action))
        {
        	System.out.println ("addcustomerexe");
        	// R�cup�ration par la requ�te des param�tres saisis
        	String firstname = request.getParameter("firstName");
        	String lastname = request.getParameter("lastName");
        	String adresse = request.getParameter("address");   	
        	
        	// Ajout du client � la liste
        	manager.addCustomer(firstname, lastname, adresse);
        		
        	// R�cup�rer la liste des clients g�r�e par le manager
        	customers = manager.getCustomers();
        	
            // Positionner la liste des clients comme attribut de requ�te 
            // Attribut utilis� par la page jsp
        	request.setAttribute("customers", customers);
        	
        	// Prochaine page JSP � retourner au navigateur
            jspPage = "/pagesclient/afficherListeClientsSansJSTL.jsp";
        }
        // Envoyer la page correspondante � la demande
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
    	// SI une page jsp a �t� d�finie
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
