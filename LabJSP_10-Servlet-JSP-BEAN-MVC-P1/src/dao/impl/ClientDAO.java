package dao.impl;

import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import beans.Client;
import dao.connexion.DBConnexion;
import dao.exceptions.DAOException;
import dao.utilitaires.DAOUtil;

/**
 * 
 * @author Pascal C create(Client p_client) R findByID(int id) findAll()
 *         findByCriteria(Client criteres) U update(Client p_client) D
 *         delete(int id)
 * 
 */
public class ClientDAO implements IDAO<Client> {

	final private String qry_insert = "INSERT INTO " + IDAO.t_client + " (firstname, "
			+ "lastname, address,codepostal,ville)" + " " + "VALUES(?,?,?,?,?)";

	final private String qry_findAll = "SELECT * FROM " + IDAO.t_client;

	final private String qry_findByid = "SELECT * FROM " + IDAO.t_client + " WHERE id = ?";

	final private String qry_deleteByid = "DELETE FROM " + IDAO.t_client + " WHERE id = ?";

	final private String qry_modifByid = "UPDATE " + IDAO.t_client
			+ " SET firstname = ?, lastname = ?, adress = ?, codepostal = ?, ville = ? WHERE id = ?";

	/**
	 * @param Client p_client : objet client à créer dans la base de données.
	 */

	public int create(Client p_client) throws DAOException {
		PreparedStatement st = null;

		int ret = -1;

		// You can use the try-with-resources statement
		// to make connection to database without explicitly
		// closing the connection
		// The try-with-resources statement automatically close
		// the resource (database connection) for you.
		try {
			st = connect.prepareStatement(qry_insert);
			// en spécifiant les types SQL cibles
			st.setObject(1, p_client.getFirstName());
			st.setObject(2, p_client.getLastName());
			st.setObject(3, p_client.getAddress());
			st.setObject(4, p_client.getCodePostal());
			st.setObject(5, p_client.getVille());
			st.execute();

		} catch (SQLException ex) {
			throw new DAOException("Problème lors de la création d'un client", ex);
		} finally {
			DAOUtil.closePreparedStatement(st);
		}

		return ret;
	}

	/**
	 * @param int id du client à rechercher dans la base de données.
	 */
	public Client findByID(int id) throws DAOException {

	
		PreparedStatement st = null;
		ResultSet rs = null;
		Client myclient = null;
		

		// You can use the try-with-resources statement
		// to make connection to database without explicitly
		// closing the connection
		// The try-with-resources statement automatically close
		// the resource (database connection) for you.

		

		try {
			st = connect.prepareStatement(qry_findByid);
			// en spécifiant les types SQL cibles
			st.setObject(1, id);
			st.execute();
			
				@SuppressWarnings("null")
				int i = rs.getInt("id");
				String fName = rs.getString("firstname");
				String lName = rs.getString("lastname");
				String address = rs.getString("address");
				String codePostal = rs.getString("codepostal");
				String ville = rs.getString("ville");

				// Assuming you have a user object
				myclient = new Client(i, fName, lName, address, codePostal, ville);

		} catch (SQLException ex) {
			throw new DAOException("Problème pendant la recherche par ID", ex);
		}

		finally {
			DAOUtil.closeStatement(st); //init : closePreparedStatement
		}

		return myclient;
	}

	/**
	 * 
	 */
//	public List<Client> findByCriteria(Client criteres) throws DAOException{
//		List<Client> lclients = null;
//		Statement st = null;
//		ResultSet rs = null;
//		Client myclient= null;
//		
//		try ()
//		{
//						
//		}
//		catch (SQLException ex) {
//			throw new DAOException("findByCriteria <exception> :", ex);
//		}
//		finally {
//			DAOUtil.closeStatement(st);
//		}	
//		return lclients;
//	}

	/**
	 * Renvoie une collection qui contient toutes les ville. La collection sera vide
	 * s'il n'existe aucune ville dans la base.
	 */

	public List<Client> findAll() throws DAOException {
		List<Client> lclients = new ArrayList<Client>();
		Statement st = null;
		ResultSet rs = null;
		Client myclient = null;

		try {
			st = connect.createStatement();
			rs = st.executeQuery(qry_findAll);
			while (rs.next()) {
				System.out.print("Colonne Ville renvoyée ");
				System.out.println(rs.getString(6));

				int i = rs.getInt("id");
				String fName = rs.getString("firstname");
				String lName = rs.getString("lastname");
				String address = rs.getString("address");
				String codePostal = rs.getString("codepostal");
				String ville = rs.getString("ville");

				// Assuming you have a user object
				myclient = new Client(i, fName, lName, address, codePostal, ville);

				lclients.add(myclient);
			}
		} catch (SQLException ex) {
			throw new DAOException("findAll <exception> :", ex);
		} finally {
			DAOUtil.closeStatement(st);
		}
		return lclients;
	}

	@Override
	public List<Client> findByCriteria(Client obj) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param Client p_client à modifier dans la base de données.
	 * @throws DaoException si mise à jour impossible
	 */
	public Client update(Client p_client) throws DAOException {
		PreparedStatement st = null;
		

		try {

			st = connect.prepareStatement(qry_modifByid);
			// en spécifiant les types SQL cibles
			st.setObject(1, p_client.getFirstName());
			st.setObject(2, p_client.getLastName());
			st.setObject(3, p_client.getAddress());
			st.setObject(4, p_client.getCodePostal());
			st.setObject(5, p_client.getVille());
			st.setObject(6, p_client.getId());

			st.execute();

		} catch (SQLException e) {
			throw new DAOException("update : erreur sur mise à jour");
		} finally {
			DAOUtil.closeStatement(st);
		}

		return p_client;
	}

	/**
	 * Suppression à partir de l'identifiant de l'objet
	 * 
	 * @param long id
	 */
	@SuppressWarnings("finally")
	public boolean delete(int id) throws DAOException {
		boolean bret = false;
		PreparedStatement st = null;

		try {
			st = connect.prepareStatement(qry_deleteByid);
			// en spécifiant les types SQL cibles
			st.setObject(1, id);
			st.execute();

		} catch (SQLException e) {
			throw new DAOException("delete : erreur sur suppression");
		} finally {
			DAOUtil.closeStatement(st);
			return bret;
		}
	}

	@Override
	public boolean delete(Client obj) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @param Client obj à supprimer dans la base de données.
	 * @throws DaoException si suppression impossible
	 */

//	@SuppressWarnings("finally")
//	public boolean delete(int id) throws DAOException   {
//		boolean bret = false;
//		PreparedStatement prepare = null;
//		
//		try () {
//			
//			
//			
//		} catch (SQLException e) {
//			throw new DAOException("delete : erreur sur suppression");
//		}
//		finally {
//			DAOUtil.closePreparedStatement(prepare);
//			return bret;
//		}
//	}
}
