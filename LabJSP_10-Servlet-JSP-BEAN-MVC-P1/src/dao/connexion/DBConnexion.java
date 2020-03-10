package dao.connexion;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Pascal
 * 
 */
public class DBConnexion
{
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String chaineConnexion = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String login = "temp";
	private static String password = "afpa123";
	
	// Objet Connection
	private static Connection connexion;
	
	// Créer un logger
	private static final Logger logger 
    = LoggerFactory.getLogger(DBConnexion.class);

	// Le constructeur déclaré private
	private DBConnexion (){}

	/**
	 * 
	 */
	public static void cloreConnexion ()
	{
		logger.info("DBConnexion : FERMETURE DE LA CONNEXION");  
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
		logger.info("OUVERTURE D'UNE CONNEXION");
		try
		{
			if (connexion == null || connexion.isClosed())
			{
				Class.forName (driver);
				if (login != null)
					connexion = DriverManager.getConnection (chaineConnexion, login, password);
				else
					connexion = DriverManager.getConnection (chaineConnexion);
			}
			return connexion;
		}
		catch (ClassNotFoundException ex)
		{
			logger.error ("Classe non trouvée " + ex.getMessage());
			return connexion;
		}
		catch (SQLException ex)
		{
			logger.error ("Ouverture connexion impossible. " + ex.getMessage ());
			return connexion;
		}	
	}
}
