<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>LabJSP_00-PRES-JSTL</title>
</head>

<body>
	<h1>Vos choix</h1>
	
	<span>Forme du gâteau :</span>
	<c:out value="${param.shape}"/>
	 
	 <br />
	<span>Garniture(s) :</span> 
	
	<c:forEach var="aGarni" items="${paramValues.garni}">
	 <c:out value="${aGarni}"/>
	</c:forEach>
	<br/>	
	
	<a href="index.jsp">Retour à la sélection</a>
</body>
</html>
