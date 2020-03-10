<%@ page import="java.util.ArrayList, beans.*" %>
<%
ArrayList maliste = (ArrayList)request.getAttribute("customers");
%>


<body>
<table cellspacing="3" cellpadding="3" border="1" width="500">
<tr>
	<td colspan="7"><b>Liste des clients sans JSTL</b></td>
</tr>
<tr>
	<td><b>Identifiant</b></td>
	<td><b>Prénom</b></td>
	<td><b>Nom</b></td>
	<td><b>Adresse</b></td>
	<td><b>Code Postal</b></td>
	<td><b>Ville</b></td>
</tr>

<%
for (int i=0; i < maliste.size();i++) {
	Client cli = (Client)maliste.get(i);
%>
<tr>
	<td>
		<a href="controleur?action=displaycustomer1&id=<%= cli.getId() %>"><%= cli.getId() %></a>
	</td>
	<td><%= cli.getFirstName() %></td>
	<td><%= cli.getLastName() %></td>
	<td><%= cli.getAddress() %></td>
	<td><%= cli.getCodePostal() %></td>
	<td><%= cli.getVille() %></td>
		<td>
		<a href="controleur?action=removecustomer&id=${customer.id}">
			Supprimer
		</a>
	</td>
</tr>
<%
}
%>
</table>
<a href="controleur?action=addcustomer">Ajouter un client</a>
<a href="controleur?action=accueil">Retour à la page d'accueil</a>
<jsp:include page="/jspf/piedDePage1.jsp" flush="true" >
	<jsp:param name="titre" value="Afficher la liste des clients"/>
</jsp:include>