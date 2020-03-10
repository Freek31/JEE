package manager;

import java.util.ArrayList;
import java.util.List;

import beans.Client;



public class ClientManager
{	
	// Collection de clients
	private List<Client> rv = (List<Client>)new ArrayList<Client>(30);
	private static ClientManager manager = null;
	// Nombre de clients créés lors de la génération de la liste
	private static final int NBCLIENTS = 10;
	
	private ClientManager() {
		
	}
	
	public static ClientManager getInstance() {
		
		if(manager == null) {
			manager = new ClientManager();
		}
		return manager;
	}
	
	
	public List<Client> createCustomers()
	{
	    return generateCustomers();
	}
	/**
	 * 
	 * @return liste des clients
	 */
    public List<Client> getCustomers()
    {
        return rv;
    }

    private List<Client> generateCustomers()
    {
        for (int i = 0; i < NBCLIENTS; i++) {
            rv.add(getCustomerForCreate(i));
        }
        return rv;
    }

    public Client getCustomerForCreate(int id)
    {
        return new Client(id, "Bob " + id, "Marley " + id, "123 rue de la Jamaique"+ id, "31"+ id, "Toulouse");
    }
    
    public Client getCustomer(String id)
    {
    	Client id1 = (Client)rv.get(Integer.parseInt(id));
        return id1;
    }
    
    public void setCustomer(int id, String firstname, String lastname, 
    		String address)
    {
    	Client id1 = (Client)rv.get(id);
    	id1.setFirstName(firstname);
    	id1.setLastName(lastname);
    	id1.setAddress(address);
    }
    
    public void setCustomer(Client mycli)
    {
    	if (mycli != null)
    	{
	    	int id = (mycli.getId());
	    	Client hclient = (Client)rv.get(id);
	    	hclient.setFirstName(mycli.getFirstName());
	    	hclient.setLastName(mycli.getLastName());
	    	hclient.setAddress(mycli.getAddress());
	    	System.out.print("debug : setCustomer  " + mycli.getFirstName());
    	}
    }
    
    public void addCustomer(String firstname, String lastname, String address)
    {
    	System.out.println ("addCustomer()");
    	
    	int id=0;
    	for(Client current : rv) // pour chaque String current dans a
    	{
    	  System.out.println(current);
    	  if ((current.getId()) > id)
    	  	id = (current.getId());
    	}
    	id = id+1;
    	int sid = (id);
    	
    	Client id1 = new Client();	
    	id1.setId(sid);
    	id1.setFirstName(firstname);
    	id1.setLastName(lastname);
    	id1.setAddress(address);

    	rv.add(id1);
    }
	public List<Client> getRv() {
		return rv;
	}
	public void setRv(List<Client> rv) {
		this.rv = rv;
	}
}
