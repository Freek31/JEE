package dao.utilitaires;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.exceptions.DAOException;

// final : pas possible d'hériter de cette classe
public final class DAOUtil {
	
	// Constructeur en private -> pas d'instanciation
	private  DAOUtil (){
		
	}
	
	/**
	 * Fermeture d'un Statement
	 * @param stmt
	 * @throws DAOException
	 */
	public static void closeStatement(final Statement stmt) throws DAOException
	{
		// SI statement existe
		if (stmt != null)
		{
			 try
			 {
				// Fermeture du statement
				stmt.close();
			 }
			 catch (SQLException ex)
			 {
				 throw new DAOException("closeStatement <exception> :", ex);
			 }
		}
	}
	
	public static void closePreparedStatement(final PreparedStatement ps) throws DAOException
	{
		// SI statement existe
		if (ps != null)
		{
			 try
			 {
				// Fermeture du statement
				 ps.close();
			 }
			 catch (SQLException ex)
			 {
				 throw new DAOException("closePreparedStatement <exception> :", ex);
			 }
		}
	}

	/**
	 * Fermeture d'un ResultSet
	 * @param rs
	 * @throws DAOException
	 */
	public static void closeResultSet(final ResultSet rs) throws DAOException
	{
		// SI ResultSet existe
		if (rs != null)
		{
			 try
			 {
				 // Fermeture du ResultSet
				 rs.close();
			 }
			 catch (SQLException ex)
			 {
				 throw new DAOException("closeResultSet <exception> :", ex);
			 }
		}
	}
}
