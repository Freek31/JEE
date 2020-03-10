/**
 * 
 */
package test.java;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import beans.Client;
import controleur.commandes.DisplayList;
import dao.exceptions.DAOException;
import dao.impl.ClientDAO;
import dao.impl.IDAO;
import manager.ClientManager;

/**
 * | @Author : @Fred || 10 mars 2020 || 09:35:30 | *
 *
 */

@TestMethodOrder(OrderAnnotation.class)
public class TestJdbc {
	private static IDAO<Client> dao = null;
	

	@BeforeAll
	public static void avantTout() {
		dao = new ClientDAO();
		
	}

	@Test
	@Order(1)
	public void firstTest() {
		try {
			System.out.println(dao.findAll().get(1).getLastName());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
