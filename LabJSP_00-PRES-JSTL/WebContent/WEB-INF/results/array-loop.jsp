<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Looping Down Arrays</title>
	<link rel="stylesheet" href="../../css/styles.css" type="text/css">
</head>
<body>

<p class="title">Looping Down Arrays</p>

<h2>Key Words:</h2>
<ul>
<c:forEach var="word" items="${words}">
  <li>${word}</li>
</c:forEach>
</ul>
<h2>Values of the test Parameter:</h2>
<ul>
<c:forEach var="val" 
           items="${paramValues.test}">
  <li>${val}</li>
</c:forEach>
</ul>
</body>
</html>