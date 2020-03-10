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
      <h3>Simple Bean (utilisation des balises jsp:getProperty)</h3>
      <hr />
      <jsp:getProperty name="simpleBean" property="dateTime" />
      <table> 
      <tr>
        <td>Prénom :</td>
        <td><jsp:getProperty name="simpleBean" property="firstName" />
      </tr>
      <tr>
        <td>Nom :</td>
        <td><jsp:getProperty name="simpleBean" property="lastName" />
      </tr>
      <tr>
        <td>Téléphone :</td>
        <td><jsp:getProperty name="simpleBean" property="phone" />
      </tr>
      <tr>
        <td>Mail :</td>
        <td><jsp:getProperty name="simpleBean" property="email" />
      </tr>
    </table> 
  </body>
</html>