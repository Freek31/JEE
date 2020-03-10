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
          <td>Pr�nom :</td>
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
          <td> T�l�phone :</td>
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
      La m�thode getMessage() de la classe ModeleBean est appel�e -->
      ${modelBean.message} 	<!-- Utilisation de l'op�rateur point -->
    </pre>
    
    <pre>
      <!-- Langage EL (Expression Language)
      La m�thode getMessage() de la classe ModeleBean est appel�e -->
      ${modelBean['message']}	<!-- Utilisation de l'op�rateur crochet -->
    </pre>
    
    <pre>
      <!-- Autre �criture : La m�thode getMessage() de la classe ModeleBean est appel�e 
           Attention : Il doit y avoir une balise jsp:useBean en d�but de document -->
      <jsp:getProperty name="modelBean" property="message" />
    </pre>
    
    <p>
      <!-- La m�thode getLastName() de la classe ModeleBean est appel�e -->
     Nom : ${modelBean.lastName}
      <!-- La m�thode getFirstName() de la classe ModeleBean est appel�e -->
      <br  />
     Pr�nom : ${modelBean.firstName}
    </p>
  </body>
</html>
