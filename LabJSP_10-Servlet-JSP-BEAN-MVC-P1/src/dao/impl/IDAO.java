package dao.impl;

import java.sql.Connection;
import java.util.List;

import dao.connexion.DBConnexion;
import dao.connexion.DBConnexion_ds;
import dao.exceptions.DAOException;

// Depuis JSE 5, il existe la généricité. 
// Une classe ou une interface peut être générique <T>

/**
 * 
 * @author Pascal
 * 
 */
public interface IDAO<T> {
	
	// Déclaration des nom des tables
	public static final String t_client = "T_CLIENT";
	
	// Récupérer une connexion à la base
	public Connection connect = DBConnexion.getConnexion();
	
	/**
	* Permet de récupérer un objet via son ID
	* @param id
	* @return
	*/
	public abstract T findByID(int id)throws DAOException;
	
	/**
	* Permet de récupérer tous les objets
	* @param id
	* @return
	*/
	public abstract List<T> findAll()throws DAOException;
	
	/**
	* Permet de récupérer une liste d'objets via des critères
	* @param id
	* @return
	*/
	public abstract List<T> findByCriteria(T obj) throws DAOException;
	
	/**
	* Permet de créer une entrée dans la base de données
	* par rapport à un objet
	* @param obj
	*/
	public abstract int create(T obj) throws DAOException;

	/**
	* Permet de mettre à jour les données d'une entrée dans la base
	* @param obj
	*/
	public abstract T update(T obj) throws DAOException;
	
	/**
	* Permet la suppression d'une entrée de la base à partir de l'objet métier
	* @param obj
	*/
	public abstract boolean delete(T obj) throws DAOException;
	
	/**
	* Permet la suppression d'une entrée de la base à partir de 
	* l'identifiant de l'objet métier
	* @param obj
	*/
	public abstract boolean delete(int id) throws DAOException;
}