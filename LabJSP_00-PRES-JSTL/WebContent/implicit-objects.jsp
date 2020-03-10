<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>JSTL Implicit Objects</title>
	<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>

<body>

<p class="title">JSTL (Core Tags) : Implicit Objects</p>

<ul>
  <li><b>Value of JSESSIONID Cookie: </b>${cookie.JSESSIONID.value}</li>
  <li><b>Request Parameter (test): </b>${param.test}</li>
  <%-- Using [] syntax because of dash in name! --%>
  <li><b>User-Agent Header: </b>${header["User-Agent"]}</li>
  <li><b>Max inactive interval: </b>${pageContext.session.maxInactiveInterval} secondes</li>
</ul>
</body>
</html>