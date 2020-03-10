<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Loop Status</title>
	<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
	<script src="./scripts/ajax-utils.js" type="text/javascript"></script>
</head>

<body>
<div align="center">
	<p class="title">JSTL (Core Tags): Loop Status</p>
	<fieldset>
	  <legend>Test</legend>
	  <% String[] names = {"Joe", "Jane", "Juan", "Juana"};
	     request.setAttribute("names", names); %>
	  <h2>Names: 
	  <c:forEach var="name" items="${names}" varStatus="status">
	    ${name}<c:if test="${!status.last}">,</c:if>
	  </c:forEach>
	  </h2>
	</fieldset>
</div>
</body>
</html>