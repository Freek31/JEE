<%-- Cette directive permet de définir les attributs spécifiques à une page --%>
<%@ page language="Java" import="java.util.*" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>LabJSP_00-PRES-Decouverte</title>
</head>
<body>
	<%-- Éléments de scripting de type expression --%>
	<%-- Cette balise est utilisée pour évaluer une expression 
		 et renvoyer sa valeur. --%> 
	
	<h1 align="center">Date : <%= new Date() %></h1>

	<hr />


	<%-- Scriplet --%>
	<%-- Cette balise contient un bloc de code Java qui est placé dans la méthode _jspService() 
		 de la Servlet générée.
		 Elle a accès aux attributs et méthodes définis par la balise déclaration <%! … %> 
		 et aux objets implicites.
	--%>

	<% for(int i=1; i<=3; i++) { %>
	    <h4 align="center">Cool cette JSP</h4>
	<% } %>
	
	<hr />
	
	
	<%-- Déclarations		<%!       %> 
	Cette balise permet d’insérer du code dans la classe de la Servlet. 
	Elle peut être utilisée pour déclarer un attribut de classe ou 
	pour spécifier et implémenter des méthodes. --%>
	
	<%!
  		int i;
  		int inc(int j) { 
  			return j+1; 
  		}
	%>
	
	
	<%-- Éléments de scripting de type expression --%>
	<%-- Cette balise est utilisée pour évaluer une expression et renvoyer sa valeur. 
		 Une expression retourne une valeur String.
		 Elle correspond à un scriptlet <% out.println(…) ; %>.
	--%>
	<h4 align="center">Compteur : <%= inc(2) %></h4>
	
	
	<%-- Les actions JSP sont des balises qui agissent sur le déroulement de l'exécution.
		 Elles permettent de faire des traitements au moment où la page est demandée par le client :
			•	inclure dynamiquement un fichier <jsp:include   />,
			•	rediriger vers une autre page <jsp:forward   />,
			•	utiliser des JavaBeans <jsp:useBean   />,
			•	générer du code HTML pour une applet <jsp:plugin    />.
	--%>
	<jsp:include page="mapage_include.jsp" flush="true" />
	
</body>
</html>