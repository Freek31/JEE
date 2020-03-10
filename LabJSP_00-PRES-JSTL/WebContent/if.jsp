<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>The "if" Tag</title>
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>

<body>
<p class="title">JSTL (Core Tags) : Tag if</p>
<ul>
<c:forEach var="i" begin="1" end="10">
  <li>${i}
      <c:if test="${i > 7}">
      (greater than 7)
      </c:if>
   </li>
</c:forEach>
</ul>
</body>
</html>