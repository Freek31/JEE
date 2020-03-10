<body>
<a href="controleur?action=createlist" target="_self">Générer la liste des clients</a><br> 
<a href="controleur?action=displaylist" target="_self">Visualiser la liste des clients avec JSTL</a><br> 
<a href="controleur?action=displaylist1" target="_self">Visualiser la liste des clients sans JSTL</a> 
<jsp:include page="/jspf/piedDePage1.jsp" flush="true" >
	<jsp:param name="titre" value="Accueil"/>
</jsp:include>