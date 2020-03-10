/**
 * 
 */
package test.java;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import beans.Client;
import manager.ClientManager;




/**
 * | @Author : @Fred || 5 mars 2020 || 14:57:57 | *
 *
 */


@TestMethodOrder(OrderAnnotation.class)
public class TestManager {
    private static StringBuilder output = new StringBuilder("");
    private static ClientManager manager; 
    private static List <Client> customers;
    
    @BeforeAll
    @Disabled
    public static void avantTout() {
    	manager = ClientManager.getInstance();
    	customers = manager.createCustomers();
    }
    
    @Test
    @Disabled
    @Order(1)    
    public void firstTest() {
        assertNotNull(customers);
    }
  
    @Test
    @Disabled
    @Order(2)    
    public void secondTest() {
    			
    			Client customer1 = customers.get(1);
    			Client customer2 = customers.get(2);
    			String action = "createlist";
    			assertSame(customer1, customer2);		
    }
  
}