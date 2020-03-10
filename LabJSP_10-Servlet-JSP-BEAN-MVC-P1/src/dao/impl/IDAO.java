package dao.impl;

import java.sql.Connection;
import java.util.List;

import dao.connexion.DBConnexion;
import dao.connexion.DBConnexion_ds;
import dao.exceptions.DAOException;

// Depuis JSE 5, il existe la g�n�ricit�. 
// Une classe ou une interface peut �tre g�n�rique <T>

/**
 * 
 * @author Pascal
 * 
 */
public interface IDAO<T> {
	
	// D�claration des nom des tables
	public static final String t_client = "T_CLIENT";
	
	// R�cup�rer une connexion � la base
	public Connection connect = DBConnexion.getConnexion();
	
	/**
	* Permet de r�cup�rer un objet via son ID
	* @param id
	* @return
	*/
	public abstract T findByID(int id)throws DAOException;
	
	/**
	* Permet de r�cup�rer tous les objets
	* @param id
	* @return
	*/
	public abstract List<T> findAll()throws DAOException;
	
	/**
	* Permet de r�cup�rer une liste d'objets via des crit�res
	* @param id
	* @return
	*/
	public abstract List<T> findByCriteria(T obj) throws DAOException;
	
	/**
	* Permet de cr�er une entr�e dans la base de donn�es
	* par rapport � un objet
	* @param obj
	*/
	public abstract int create(T obj) throws DAOException;

	/**
	* Permet de mettre � jour les donn�es d'une entr�e dans la base
	* @param obj
	*/
	public abstract T update(T obj) throws DAOException;
	
	/**
	* Permet la suppression d'une entr�e de la base � partir de l'objet m�tier
	* @param obj
	*/
	public abstract boolean delete(T obj) throws DAOException;
	
	/**
	* Permet la suppression d'une entr�e de la base � partir de 
	* l'identifiant de l'objet m�tier
	* @param obj
	*/
	public abstract boolean delete(int id) throws DAOException;
}