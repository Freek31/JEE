<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>The "choose" Tag</title>
	<link rel="stylesheet"  href="css/styles.css" type="text/css">
</head>
<body>

<p class="title">JSTL : tag choose</p>

<ul>
<c:forEach var="i" begin="1" end="10">
  <li>${i}
    <c:choose>
      <c:when test="${i < 4}">
        (small)
      </c:when>
      <c:when test="${i < 8}">
        (medium)
      </c:when>
      <c:otherwise>
        (large)
    </c:otherwise>
      </c:choose>
</c:forEach>
</ul>
</body>
</html>