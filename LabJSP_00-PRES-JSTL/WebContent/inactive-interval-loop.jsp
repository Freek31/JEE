<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Session Timeout</title>
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>
<p class="title">JSTL (Core Tags) : Session Timeout</p>

<ul>
<c:forEach var="seconds" 
           begin="0" 
           end="${pageContext.session.maxInactiveInterval}"
           step="100">
  <li>${seconds}</li>
</c:forEach>
</ul>
</body>
</html>