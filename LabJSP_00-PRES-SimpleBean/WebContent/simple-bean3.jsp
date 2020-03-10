<jsp:useBean id="simpleBean" class="modele.SimpleBean" scope="request" />

<jsp:useBean id="simpleBean1" class="modele.SimpleBean" scope="request" />

<jsp:useBean id="simpleBean2" class="modele.SimpleBean" scope="request" />
<jsp:setProperty name="simpleBean2" property="firstName" value="Stevie" />
<jsp:setProperty name="simpleBean2" property="lastName" value="Wonder" />
<jsp:setProperty name="simpleBean2" property="phone" value="06 11 11 11 11" />
<jsp:setProperty name="simpleBean2" property="email" value="stevie.wonder@afpa.fr" />

<!DOCTYPE html>
<html lang="fr">
  <head>
  	<meta charset="utf-8">
    <title>LabJSP_00-PRES-SimpleBean</title>
  </head>
    <body>
      <hr>
      <h3>Bean positionné par la servlet</h3>
      <hr>
      <h1 align="center">Hash code du bean : <%= simpleBean.hashCode() %></h1>
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
    
    <hr>
      <h3>Bean NON positionné par la servlet</h3>
    <hr>
    <h1 align="center">Hash code du bean : <%= simpleBean1.hashCode() %></h1>
      <jsp:getProperty name="simpleBean1" property="dateTime" />
      <table> 
      <tr>
        <td>Prénom :</td>
        <td><jsp:getProperty name="simpleBean1" property="firstName" />
      </tr>
      <tr>
        <td>Nom :</td>
        <td><jsp:getProperty name="simpleBean1" property="lastName" />
      </tr>
      <tr>
        <td>Téléphone :</td>
        <td><jsp:getProperty name="simpleBean1" property="phone" />
      </tr>
      <tr>
        <td>Mail :</td>
        <td><jsp:getProperty name="simpleBean1" property="email" />
      </tr>
    </table> 
    
    
     <hr>
      <h3>Bean NON positionné par la servlet avec des valeurs par défaut</h3>
    <hr>
    <h1 align="center">Hash code du bean : <%= simpleBean2.hashCode() %></h1>
      <jsp:getProperty name="simpleBean2" property="dateTime" />
      <table> 
      <tr>
        <td>Prénom :</td>
        <td><jsp:getProperty name="simpleBean2" property="firstName" />
      </tr>
      <tr>
        <td>Nom :</td>
        <td><jsp:getProperty name="simpleBean2" property="lastName" />
      </tr>
      <tr>
        <td>Téléphone :</td>
        <td><jsp:getProperty name="simpleBean2" property="phone" />
      </tr>
      <tr>
        <td>Mail :</td>
        <td><jsp:getProperty name="simpleBean2" property="email" />
      </tr>
    </table> 
  </body>
</html>