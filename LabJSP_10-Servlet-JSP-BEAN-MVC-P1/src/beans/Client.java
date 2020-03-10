package beans;

import java.io.Serializable;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 
 * @author Pascal
 *
 */

// HttpSessionBindingListener
// un objet peut �tre notifi� du fait qu'il a �t� ajout� � une session. 
// Il doit pour cela impl�menter l'interface HttpSessionBindingListener. 
// Cette interface expose deux m�thodes :
//		- valueBound(HttpSessionBindingEvent) : appel�e lorsque l'objet est attach� � une session.
//		- valueUnbound(HttpSessionBindingEvent) : appel�e lorsque l'objet est d�tach�e de la session.
// Ces deux m�thodes re�oivent en param�tre un objet de type HttpSessionBindingEvent. 
// Cet �v�nement expose les deux m�thodes classiques getName() et getValue(). 
// Il expose �galement getSession(), qui retourne la session � laquelle cet objet est attach�, 
// ou de laquelle il est d�tach�. 
public class Client implements Serializable, HttpSessionBindingListener{

	
	private static final long serialVersionUID = 6552720450742917972L;
	
	private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String codePostal;
    private String ville;


    public Client () {
    }

    /**
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     */
    // Si un constructeur autre que le constructeur par d�faut a �t� defini, il faut d�finir 
    // un constructeur par d�faut (sans parametre)
    public Client(int id, String firstName, String lastName, String address, String codePostal, String ville) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.codePostal = codePostal;
        this.ville=ville;
    }
    /**
     * 
     * @return	address	
     */
    public String getAddress()
    {
        return address;
    }
    /**
     * 
     * @param address
     */
    public void setAddress(String address)
    {
    	this.address = address;
    }

    public String getFirstName()
    {
        return firstName;
    }

    /**
     * 
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
    	this.firstName = firstName;
    }
    /**
     * 
     * @return	lastName	Pr�nom du client
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * 
     * @param lastName		Pr�nom du client
     */
    public void setLastName(String lastName)
    {
    	this.lastName = lastName;
    }

    /**
     * 
     * @return 
     * @return	id	Identifiant du client
     */
    public int getId()
    {
        return id;
    }

    /**
     * 
     * @param id	Identifiant du client
     */
    public void setId(int id)
    {
    	this.id = id;
    }
    
    // M�thode appel�e lorsque l'objet est attach� � une session.
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut li�");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());		
	}

	// M�thode appel�e lorsque l'objet est d�tach�e de la session.
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut non li�");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());	
	}
	
	public String toString() {
		String str = firstName + " " + lastName;
		return str;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


}