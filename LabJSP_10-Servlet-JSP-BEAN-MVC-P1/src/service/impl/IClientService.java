package service.impl;

import java.util.List;
import beans.Client;
import service.exceptions.ServiceException;

/**
 * 
 * @author Pascal
 * 
 */
public interface IClientService {
	public List<Client> getListeClients() throws ServiceException;
	public void addClient (String firstname, String lastname, 
			String address,  
			String codepostal,  String ville) throws ServiceException;
	public Client getClient(int id) throws ServiceException;
	public boolean delClient(int id) throws ServiceException;
	public boolean setClient(int id, String firstname, 
			String lastname, String address, 
			String codepostal, String ville) throws ServiceException;
}