<%@ page errorPage="/erreurs/afficherErreurServeur.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Mettre ${customer} dans l'attribut "customer" de la request -->
<c:set var="customer" value="${requestScope.customer}"/>

<body>
<form action="controleur" method="post" >
	<table cellspacing="3" cellpadding="3" border="1" width="60%">	
		<input type="hidden" name="id" value="${customer.id}">
		<input type="hidden" name="action" value="editcustomerexe">
		<tr>
			<td><b>Prénom :</b> 
		  <td><input type="text" name="firstname" value="${customer.firstName}" />
		  </td>
		</tr>
		<tr>
			<td><b>Nom :</b> 
		  <td><input type="text" name="lastname" value="${customer.lastName}" /></td>
		</tr>
		<tr>
			<td><b>Adresse :</b> 
		  <td><input type="text" size="50" name="address" value="${customer.address}" /></td>
		</tr>
		<tr>
			<td><b>Code Postal :</b> 
		  <td><input type="text" size="50" name="address" value="${customer.codePostal}" /></td>
		</tr>
		<tr>
			<td><b>Ville :</b> 
		  <td><input type="text" size="50" name="address" value="${customer.ville}" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Valider"></td>
		</tr>
	</table>
</form>
<jsp:include page="/jspf/piedDePage.jsp" flush="true" />