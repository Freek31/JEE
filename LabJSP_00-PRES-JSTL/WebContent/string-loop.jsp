<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Looping Down Strings</title>
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>

<body>
<p class="title">JSTL (Core Tags): Looping Down Strings</p>
<ul>
<c:forEach var="country" 
           items="Australia,Canada,Japan,Philippines,Mexico,USA">
  <li>${country}</li>
</c:forEach>
</ul>
</body>
</html>