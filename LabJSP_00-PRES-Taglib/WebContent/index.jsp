<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt" %> 

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>LabJSP_00-PRES-DATETIME</title>
</head>

<body>

	<p>La date en millisecondes est <dt:currentTime/></p> 
	<p>Date au format français 
	<dt:format pattern="dd/MM/yyyy hh:mm"><dt:currentTime/></dt:format>
	</p>

</body>
</html>