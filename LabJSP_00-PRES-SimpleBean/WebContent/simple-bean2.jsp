<%@ page import="modele.SimpleBean" %>
<jsp:useBean id="simpleBean" class="modele.SimpleBean" scope="page" />

<jsp:setProperty name="simpleBean" property="firstName" value="Bob" />
<jsp:setProperty name="simpleBean" property="lastName" value="Marley" />
<jsp:setProperty name="simpleBean" property="phone" value="06 11 11 11 11" />
<jsp:setProperty name="simpleBean" property="email" value="bob.marley@afpa.fr" />

<!DOCTYPE html>
<html lang="fr">
  <head>
  	<meta charset="utf-8">
    <title>LabJSP_00-PRES-SimpleBean</title>
  </head>
  <body>
      <hr>
      <h3>Simple Bean : utilisation de pageContext.findAttribute()</h3>
      <hr />
      <%
      	SimpleBean bean = (SimpleBean) pageContext.findAttribute("simpleBean");
		if (bean != null)
			out.print (bean.getDateTime());
	  %>
      <table> 
      <tr>
        <td>Prénom :</td>
        <td>
        <%
		if (bean != null)
			out.print (bean.getFirstName());
		%>
		</td>
      </tr>
      <tr>
        <td>Nom :</td>
        <td><%
		if (bean != null)
			out.print (bean.getLastName());
		%>
		</td>
      </tr>
      <tr>
        <td>Téléphone :</td>
        <td><%
		if (bean != null)
			out.print (bean.getPhone());
		%>
		</td>
      </tr>
      <tr>
        <td>Mail :</td>
        <td><%
		if (bean != null)
			out.print (bean.getEmail());
		%>
		</td>
      </tr>
    </table> 
  </body>
</html>