<body>
<form name="FormName" action="controleur" method="post">
<table cellspacing="3" cellpadding="3" border="1" width="60%">
<input type="hidden" name="action" value="addcustomerexe" />
<tr>
<td><b>Prénom :</b> 
  <td><input type="text" name="firstName" />
  </td>
</tr>
<tr>
	<td><b>Nom :</b> 
  <td><input type="text" name="lastName" /></td>
</tr>
<tr>
	<td><b>Adresse :</b> 
  <td><input type="text" size="50" name="address" /></td>
</tr>
<tr>
	<td><b>Code Postal :</b> 
  <td><input type="text" size="50" name="codePostal" /></td>
</tr>
<tr>
	<td><b>Ville :</b> 
  <td><input type="text" size="50" name="ville" /></td>
</tr>

<tr>
	<td colspan="2"><input type="button" value="Valider" onclick="Verifier(FormName)"></td>
</tr>
</table>
</form>
<jsp:include page="/jspf/piedDePage.jsp" flush="true" />