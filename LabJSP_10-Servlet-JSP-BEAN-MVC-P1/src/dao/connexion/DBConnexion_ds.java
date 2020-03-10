package dao.connexion;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe permmettant de gérer l'ouverture/fermeture d'une connexion
 * @author Pascal
 * 
 */
public class DBConnexion_ds
{
	private static DataSource ds;
	
	// Objet Connection
	private static Connection connexion;
	
	private static final Logger logger 
    = LoggerFactory.getLogger(DBConnexion_ds.class);

	// Le constructeur déclaré private
	private DBConnexion_ds (){}

	/**
	 * 
	 */
	public static void cloreConnexion ()
	{
		logger.info("DBConnexion_ds : FERMETURE DE LA CONNEXION"); 
		
		try
		{
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}
		catch (SQLException ex)
		{
			logger.error("Classe non trouvée " + ex.getMessage ());
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Connection getConnexion ()
	{
		logger.info("DBConnexion_ds : OUVERTURE D'UNE CONNEXION");

		// Localisation JNDI...
		try {
			
			//ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/authen");
			
			Context initialContext = new InitialContext();
			Context localContext = (Context)
			initialContext.lookup("java:comp/env/");
			ds = (DataSource) localContext.lookup("jdbc/authen");
			
		} catch (NamingException ex) {
			logger.error("Problème de data source " + ex.getMessage ());
		}
		
		// Obtenir une connexion
		try {
			connexion = ds.getConnection();
		} catch (SQLException ex) {
			logger.error("Impossible de se connecter à la BD " + ex.getMessage ());;
		}
		
		return connexion;
	}
}
