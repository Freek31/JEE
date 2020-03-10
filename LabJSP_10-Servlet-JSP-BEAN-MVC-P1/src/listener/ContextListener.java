package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("\nLabJSP_10-Servlet-JSP-BEAN-MVC : Contexte supprimé");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("\nLabJSP_10-Servlet-JSP-BEAN-MVC : Contexte initialisé");
		
	} 
}