package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public final class SessionListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut ajout�");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());		
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut supprim�");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut modifi�");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());
    }  
}