package service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import beans.Client;
import dao.exceptions.DAOException;
import dao.impl.ClientDAO;
import dao.impl.IDAO;
import service.exceptions.ServiceException;

/**
 * 
 * @author Pascal
 * 
 */
public class ClientService extends AService implements IClientService{
	
	List<Client> lclients = null;
	IDAO<Client> myDao = null;
	
	// Créer un logger
	private static final Logger logger 
    = LoggerFactory.getLogger(ClientService.class);
	
	public ClientService() {
		this.myDao = new ClientDAO();
	}
	
	/**
	 * 
	 */
	public List<Client> getListeClients() throws ServiceException {
		
		try {
			lclients = myDao.findAll();
		} catch (DAOException ex) {
			logger.error("Problème lors de la recherche d'un client", ex);
			throw new ServiceException("Problème lors de la recherche d'un client", ex);
		}
		
		return lclients;
	}
	
	/**
	 * Ajout d'un client
	 */
	public void addClient(String firstname, String lastname, String address, 
			String codepostal, String ville) throws ServiceException
    {   	
 
    	Client hClient = new Client();	
    	hClient.setFirstName(firstname);
    	hClient.setLastName(lastname);
    	hClient.setAddress(address);
    	hClient.setCodePostal(codepostal);
    	hClient.setVille(ville);
    	
    	try {
			myDao.create(hClient);
		} catch (DAOException ex) {
			throw new ServiceException("Problème lors de l'ajout d'un client", ex);
		}	
    }
	
	/**
	 * Suppression d'un client à partir de l'id passé en paramètre
	 */
	public boolean delClient(int id) throws ServiceException
    {   	
		boolean bret = false;
		
    	try {
			bret = myDao.delete(id);
		} catch (DAOException ex) {
			throw new ServiceException("Problème lors de la suppression d'un client", ex);
		}	
		return bret;
    }
	
	/**
	 * Création d'un Client à partir de son id
	 */
	public Client getClient(int id) throws ServiceException
    { 
    	Client hClient = null;
    	try {
			System.out.println("findbyid : " +myDao.findByID(id));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hClient = myDao.findByID(id);
		} catch (DAOException ex) {
			throw new ServiceException("Problème lors de la récupétration d'un client", ex);
		}
		
    	return hClient;
    }
	
	/**
	 * Création d'un Client à partir de des paramètres
	 */
	public boolean setClient(int id, String firstname, String lastname, String address, 
			String codepostal, String ville) throws ServiceException
    { 

    	Client hClient = new Client();
    	hClient.setId(id);
    	hClient.setFirstName(firstname);
    	hClient.setLastName(lastname);
    	hClient.setAddress(address);
    	hClient.setCodePostal(codepostal);
    	hClient.setVille(ville);
    	
    	myDao = new ClientDAO();
    	try {
			myDao.update(hClient);
		} catch (DAOException ex) {
			throw new 
			ServiceException("Problème lors de la création d'un client", ex);
		}
		
    	return true;
    }


	
}