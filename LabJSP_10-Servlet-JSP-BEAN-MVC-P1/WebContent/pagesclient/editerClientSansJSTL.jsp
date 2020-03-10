<jsp:useBean id="customer" class="beans.Client" scope="request" />
<jsp:setProperty name="customer" property="*" />
<%-- 
<jsp:setProperty name="customer" property="firstName" />
<jsp:setProperty name="customer" property="lastName" />
<jsp:setProperty name="customer" property="address" />
<jsp:setProperty name="customer" property="id" />
--%>

<body>
<form action="controleur" method="post">
<table cellspacing="3" cellpadding="3" border="1" width="60%">
<input type="hidden" name="id" value="<%=customer.getId()%>" />	
<input type="hidden" name="action" value="editcustomerexe" />
<tr>
<td><b>Prénom :</b> 
  <td><input type="text" name="firstname" value="<%=customer.getFirstName() %>" />
  </td>
</tr>
<tr>
	<td><b>Nom :</b> 
  <td><input type="text" name="lastname" value="<%=customer.getLastName() %>" /></td>
</tr>
<tr>
	<td><b>Adresse :</b> 
  <td><input type="text" size="50" name="address" value="<%=customer.getAddress() %>" /></td>
</tr>
<tr>
	<td><b>Code Postal :</b> 
  <td><input type="text" size="50" name="address" value="<%=customer.getCodePostal() %>" /></td>
</tr>
<tr>
	<td><b>Ville :</b> 
  <td><input type="text" size="50" name="address" value="<%=customer.getVille() %>" /></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Valider"></td>
</tr>
</table>
</form>
<jsp:include page="/jspf/piedDePage.jsp" flush="true" />