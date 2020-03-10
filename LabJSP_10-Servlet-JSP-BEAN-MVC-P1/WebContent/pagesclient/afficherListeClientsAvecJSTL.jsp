<%@ page errorPage = "/erreurs/afficherErreurServeur.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<table cellspacing="3" cellpadding="3" border="1" width="500">
<tr>
	<td colspan="7"><b>Liste des clients avec JSTL</b></td>
</tr>
<tr>
	<td><b>Identifiant</b></td>
	<td><b>Prénom</b></td>
	<td><b>Nom</b></td>
	<td><b>Adresse</b></td>
	<td><b>Code Postal</b></td>
	<td><b>Ville</b></td>
	<td><b></b></td>
</tr>
<c:forEach var="customer" items="${requestScope.customers}">
<tr>
	<td>
		<a href="controleur?action=displaycustomer&id=${customer.id}">
			${customer.id}
		</a>
	</td>
	<td>${customer.firstName}</td>
	<td>${customer.lastName}</td>
	<td>${customer.address}</td>
	<td>${customer.codePostal}</td>
	<td>${customer.ville}</td>
	<td>
		<a href="controleur?action=removecustomer&id=${customer.id}">
			Supprimer
		</a>
	</td>
</tr>
</c:forEach>
</table>
<a href="controleur?action=addcustomer">Ajouter un client</a>
<a href="controleur?action=accueil">Retour à la page d'accueil</a>
<jsp:include page="/jspf/piedDePageAvecParametre.jsp" flush="true" >
	<jsp:param name="titre" value="Afficher la liste des clients"/>
</jsp:include>