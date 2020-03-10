<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>JSTL : Formatting Tags</title>
	<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
</head>

<body>
	<p class="title">JSTL : Formatting Tags</p>

     <h3>Number Format</h3>
      <c:set var = "now" value = "<%= new java.util.Date()%>" />

      <p>Formatted Date (1): <fmt:formatDate type = "time" 
         value = "${now}" /></p>
      
      <p>Formatted Date (2): <fmt:formatDate type = "date" 
         value = "${now}" /></p>
      
      <p>Formatted Date (3): <fmt:formatDate type = "both" 
         value = "${now}" /></p>
      
      <p>Formatted Date (4): <fmt:formatDate type = "both" 
         dateStyle = "short" timeStyle = "short" value = "${now}" /></p>
      
      <p>Formatted Date (5): <fmt:formatDate type = "both" 
         dateStyle = "medium" timeStyle = "medium" value = "${now}" /></p>
      
      <p>Formatted Date (6): <fmt:formatDate type = "both" 
         dateStyle = "long" timeStyle = "long" value = "${now}" /></p>
      
      <p>Formatted Date (7): <fmt:formatDate pattern = "yyyy-MM-dd" 
         value = "${now}" /></p>
         
      <h3>Set Locale</h3>
         
      <fmt:bundle basename = "pack2.Example">
         <fmt:message key = "count.one"/><br/>
         <fmt:message key = "count.two"/><br/>
         <fmt:message key = "count.three"/><br/>
      </fmt:bundle>

      <!-- Change the Locale -->
      <fmt:setLocale value = "es_ES"/>
      <fmt:bundle basename = "pack2.Example">
         <fmt:message key = "count.one"/><br/>
         <fmt:message key = "count.two"/><br/>
         <fmt:message key = "count.three"/><br/>
      </fmt:bundle>
      
       <!-- Change the Locale -->
      <fmt:setLocale value = "fr_FR"/>
      <fmt:bundle basename = "pack2.Example">
         <fmt:message key = "count.one"/><br/>
         <fmt:message key = "count.two"/><br/>
         <fmt:message key = "count.three"/><br/>
      </fmt:bundle>
         
   </body>
</html>