<%@ page errorPage = "/erreurs/afficherErreurServeur.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="customer" value="${requestScope.customer}"/>

<body>
<table cellspacing="3" cellpadding="3" border="1" width="60%">
<tr>
	<td colspan="2"><b>Client :</b> 
     ${customer.firstName}	${customer.lastName}
	</td>
</tr>
<tr>
	<td><b>Identifiant</b></td>
	<td>${customer.id}</td>
</tr>
<tr>
	<td><b>Prénom</b></td>
	<td>${customer.firstName}</td>
</tr>
<tr>
	<td><b>Nom</b></td>
	<td>${customer.lastName}</td>
</tr>
<tr>
	<td><b>Adresse</b></td>
	<td>${customer.address}</td>
</tr>
<tr>
	<td><b>Code Postal</b></td>
	<td>${customer.codePostal}</td>
</tr>
<tr>
	<td><b>Ville</b></td>
	<td>${customer.ville}</td>
</tr>
<tr>
	<td colspan="1">
	    <a href="controleur?action=editcustomer&id=${customer.id}">Editer avec JSTL</a>
	</td>
	<td colspan="1">
	    <a href="controleur?action=editcustomer1&id=${customer.id}">Editer sans JSTL</a>
	</td>
</tr>
</table>
<%@ include file = "/jspf/piedDePage.jsp" %>