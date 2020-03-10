<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Database example</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

<p class="title">JSTL : Database Example</p>

<sql:setDataSource
  driver="oracle.jdbc.OracleDriver"
  url="jdbc:oracle:thin:@localhost:1521:orcl"
  user="lab"
  password="lab123"/>
<sql:query var="hotels">
  SELECT * FROM HOTEL
</sql:query>
<ul>
<p>Contenu de la table MEDECIN </p>
<c:forEach var="row" items="${hotels.rows}">
  <li>${row.nuhotel}
      ${row.nomhotel}
      ${row.nutype}
  </li>
</c:forEach>
</ul>
</body>
</html>