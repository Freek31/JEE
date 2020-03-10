<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Simple Loop</title>
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>
<p class="title">JSTL (Core Tags) : tag forEach</p>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="i" begin="1" end="10">
  <li>${i}</li>
</c:forEach>
</ul>
</body>
</html>