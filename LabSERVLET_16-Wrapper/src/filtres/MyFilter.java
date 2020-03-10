package filtres;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wrapper.MyServletRequestWrapper;
import wrapper.MyServletResponseWrapper;

public class MyFilter implements Filter {
    private ServletContext servletContext = null;
    
    public MyFilter(){
        super();
    }
    
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest req, ServletResponse res, 
                            FilterChain filterChain)
        throws IOException, ServletException {

    	// Encapsulation de req dans HttpServletResponseWrapper
        MyServletRequestWrapper httpReq  = new MyServletRequestWrapper((HttpServletRequest)req);
        
        MyServletResponseWrapper httpRes = new MyServletResponseWrapper((HttpServletResponse)res);
        //HttpServletResponse httpRes   = (HttpServletResponse)res;
        
        // Ajout d'entêtes personnalisés
        Date  date = new Date();
        httpReq.addHeader("MY-HEADER-X1", "header 1");
        httpReq.addHeader("MY-HEADER-X2", date.toString());

       //  Transfert à la suite de la chaîne : la servlet
        filterChain.doFilter(httpReq, httpRes);          
    }

    public void destroy(){
    }
}