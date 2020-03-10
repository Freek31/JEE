<%@ page errorPage = "/erreurs/afficherErreurServeur.jsp" %>
<jsp:useBean id="customer" class="beans.Client" scope="request" />

<body>
<table cellspacing="3" cellpadding="3" border="1" width="60%">
<tr>
	<td colspan="2"><b>Client :</b>
	<%=customer.getFirstName() %> <%=customer.getLastName() %>
	</td>
</tr>
<tr>
	<td><b>Identifiant</b></td>
	<td><%=customer.getId() %></td>
</tr>
<tr>
	<td><b>Prénom</b></td>
	<td><%=customer.getFirstName() %></td>
</tr>
<tr>
	<td><b>Nom</b></td>
	<td><%=customer.getLastName() %></td>
</tr>
<tr>
	<td><b>Adresse</b></td>
	<td><%=customer.getAddress() %></td>
</tr>
<tr>
	<td colspan="2">
	    <a href="controleur?action=editcustomer&id=<%=customer.getId() %>">Editer avec JSTL</a>
	    <a href="controleur?action=editcustomer1&id=<%=customer.getId() %>">Editer sans JSTL</a>
	    <a href="controleur?action=editcustomer2&id=<%=customer.getId() %>">Editer sans JSTL avec EL</a>
	</td>
</tr>
</table>
<%@ include file = "/jspf/piedDePage.jsp" %>