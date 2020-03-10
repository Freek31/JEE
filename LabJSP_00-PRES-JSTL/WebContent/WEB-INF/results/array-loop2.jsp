<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<TITLE>Looping Down Arrays (2)</TITLE>
	<link rel="STYLESHEET" href="../../css/styles.css" type="text/css">
</head>

<body>
<p class="title">Looping Down Arrays (2)</p>
<center>
<ul>
<c:forEach var="name" items="${names}">
  <li>${name.firstName} ${name.lastName}</li>
</c:forEach>
</ul>

<h2>Comparing Apples and Oranges</h2>
<table BORDER="1">
  <tr><th>Year</th>
      <th>Apples Sold</th>
      <th>Oranges Sold</th></tr>
<c:forEach var="row" items="${sales}">
  <tr><c:forEach var="col" items="${row}">
        <td>${col}</td>
      </c:forEach>
</c:forEach>
</table>
</center>
</body>
</html>