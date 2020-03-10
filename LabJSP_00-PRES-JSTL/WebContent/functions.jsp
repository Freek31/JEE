<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>JSTL : functions</title>
	<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
</head>

<body>
	<p class="title">JSTL : functions</p>

      <c:set var = "string1" value = "Bob est génial."/>
      <c:set var = "string2" value = "${fn:toUpperCase(string1)}" />
      <p>Original string : ${string1}</p>
      <p>Final string : ${string2}</p>
      
      <c:set var = "string1" value = "Bob est génial."/>
      <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
      <c:set var = "string3" value = "${fn:join(string2, '-')}" />
      <p>Original String : ${string1}</p>
      <p>Final String : ${string3}</p>
   </body>
</html>