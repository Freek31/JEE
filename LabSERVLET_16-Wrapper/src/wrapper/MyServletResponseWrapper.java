package wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.util.*;

public class MyServletResponseWrapper extends HttpServletResponseWrapper{

    private Map<String, String> headerMap;
    
    // Constructeur
    public MyServletResponseWrapper(HttpServletResponse response){
        super(response);
        headerMap = new HashMap<String, String>();
    }

}