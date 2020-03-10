<jsp:useBean id="simpleBean" class="modele.SimpleBean" scope="page" />

<jsp:setProperty name="simpleBean" property="firstName" value="Bob" />
<jsp:setProperty name="simpleBean" property="lastName" value="Marley" />
<jsp:setProperty name="simpleBean" property="phone" value="06 11 11 11 11" />
<jsp:setProperty name="simpleBean" property="email" value="bob.marley@afpa.fr" />

<!DOCTYPE html>
<html lang="fr">
  <head>
  	<meta charset="utf-8">
    <title>Simple Bean - Utilisation du langage EL</title>
  </head>
    <body>
      <hr>
      <h3>Simple Bean - Utilisation du langage EL</h3>
      <hr />
        ${simpleBean.dateTime} <!-- Utilisation de l'opérateur point -->
      <table> 
      <tr>
        <td>Prénom :</td>
        <td>${simpleBean['firstName']}</td>	<!-- Utilisation de l'opérateur crochet -->
      </tr>
      <tr>
        <td>Nom :</td>
        <td>${simpleBean.lastName}</td>
      </tr>
      <tr>
        <td>Téléphone :</td>
        <td>${simpleBean.phone}</td>
      </tr>
      <tr>
        <td>Mail :</td>
        <td>${simpleBean.email}</td>
      </tr>
    </table> 
  </body>
</html>