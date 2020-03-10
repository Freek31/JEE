package wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class MyServletRequestWrapper extends HttpServletRequestWrapper{

    private Map<String, String> headerMap;
    
    // Constructeur
    public MyServletRequestWrapper(HttpServletRequest request){
        super(request);
        headerMap = new HashMap<String, String>();
    }
    
    // Ajouter le paramètre à l'en-tête
    public void addHeader(String name, String value){
        headerMap.put(name, new String(value));
    }

    // Surcharge la méthode getHeaderNames() de HttpServletRequest
    public Enumeration<String> getHeaderNames(){
    	
        HttpServletRequest request = (HttpServletRequest)getRequest();
        
        List list = new ArrayList<String>();
        
        for (Enumeration e = request.getHeaderNames() ; e.hasMoreElements() ;)
            list.add(e.nextElement().toString());
        
        for (Iterator i = headerMap.keySet().iterator() ; i.hasNext() ;){
            list.add(i.next());
        }
        
        return Collections.enumeration(list);
    } 
    
    // Surcharge la méthode getHeader() de HttpServletRequest
    public String getHeader(String name){
        Object value;
        
        // SI le paramètre de l'en-tête est 
        if ((value = headerMap.get(""+name)) != null)
            return value.toString();
        else
            return ((HttpServletRequest)getRequest()).getHeader(name);
        
    }
}