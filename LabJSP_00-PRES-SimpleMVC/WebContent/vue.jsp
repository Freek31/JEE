<jsp:useBean id="modelBean" class="modele.ModeleBean" scope="request" />
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <title>Simple MVC</title>
  </head>
  <body>
    <h2>Simple MVC</h2>  
    <form method="post" action="simple-mvc">
      <table>
        <tr>
          <td>Prénom :</td>
          <td>
            <input type="text" name="first_name"  value="${modelBean.firstName}" />
          </td>
        </tr>
        <tr>
          <td>Nom :</td>
          <td>
            <input type="text" name="last_name" value="${modelBean.lastName}" />
          </td>
        </tr>
        <tr>
          <td> Mail : </td>
          <td>
            <input type="text" name="email" value="${modelBean.email}" />
          </td>
        </tr>
        <tr>
          <td> Téléphone :</td>
          <td>
            <input type="text" name="phone"value="${modelBean.phone}" />
          </td>
        </tr>
        <tr>
          <td>
            <input type="submit" name="enter_button" value="Valider" />
          </td>
          <td>
          </td>
        </tr>
      </table>
    </form>
    
    <pre>
      <!-- Langage EL (Expression Language)
      La méthode getMessage() de la classe ModeleBean est appelée -->
      ${modelBean.message} 	<!-- Utilisation de l'opérateur point -->
    </pre>
    
    <pre>
      <!-- Langage EL (Expression Language)
      La méthode getMessage() de la classe ModeleBean est appelée -->
      ${modelBean['message']}	<!-- Utilisation de l'opérateur crochet -->
    </pre>
    
    <pre>
      <!-- Autre écriture : La méthode getMessage() de la classe ModeleBean est appelée 
           Attention : Il doit y avoir une balise jsp:useBean en début de document -->
      <jsp:getProperty name="modelBean" property="message" />
    </pre>
    
    <p>
      <!-- La méthode getLastName() de la classe ModeleBean est appelée -->
     Nom : ${modelBean.lastName}
      <!-- La méthode getFirstName() de la classe ModeleBean est appelée -->
      <br  />
     Prénom : ${modelBean.firstName}
    </p>
  </body>
</html>
