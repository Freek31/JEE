<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Token Loop</title>
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

<p class="title">JSTL (Core Tags) : tag forTokens</p>

<ul>
<c:forTokens var="color"
    items="(red (orange) yellow)(green)((blue) violet)"
    delims="()">
  <li>${color}</li>
</c:forTokens>
</ul>
</body>
</html>