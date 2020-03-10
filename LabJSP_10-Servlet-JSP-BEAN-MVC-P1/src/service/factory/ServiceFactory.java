package service.factory;


import service.exceptions.ServiceFactoryException;
import service.impl.AService;
import service.impl.ClientService;

public class ServiceFactory {

	public static AService newService(Class<? extends AService> p_class) { 
		if (p_class.equals(ClientService.class))
			return new ClientService();
		else
			throw new ServiceFactoryException("Impossible de créer le service demandé."); 
	}
}