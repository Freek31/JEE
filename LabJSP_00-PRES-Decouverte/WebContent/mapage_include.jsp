
	<hr />

	<%-- Scriplet --%>
	<%-- Cette balise contient un bloc de code Java qui est placé dans la méthode _jspService() 
		 de la Servlet générée.
		 Elle a accès aux attributs et méthodes définis par la balise déclaration <%! … %> 
		 et aux objets implicites.
	--%>

	<% for(int i=1; i<=3; i++) { %>
	    <h4 align="center">Page JSP incluse</h4>
	<% } %>
	
	<hr />