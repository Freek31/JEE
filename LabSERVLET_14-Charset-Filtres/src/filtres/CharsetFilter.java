package filtres;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filtre sur les requetes pour les encoder en UTF-8  
**/
public class CharsetFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		// Message dans la console pour voir l'ordre d'exécution des filtres
		System.out.println ("Filtre CharsetFilter");
		
		// Positionner le type d'encodage sur la requête
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request,response);
	 }
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}
}