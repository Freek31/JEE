package filtres;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filtre qui permet de positionner le type d'encodage
 * Le type d'encodage est d�fini en param�tre dans le fichier web.xml
 * @author pascal
 *
 */
public class EncodingFilter implements Filter {
	private String encoding;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// R�cup�rer le type d'encodage dans le fichier web.xml
		this.encoding = filterConfig.getInitParameter("encoding");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		
		// Message dans la console pour voir l'ordre d'ex�cution des filtres
		System.out.println ("Filtre EncodingFilter");
		
		// Positionner le type d'encodage sur la requ�te
		request.setCharacterEncoding(encoding);
		
		// Appeler la servlet suivante
		filterChain.doFilter(request, response);
	}
	
	public void destroy() {
	}
}