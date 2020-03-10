<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>LabJSP_00-PRES-JSTL</title>
</head>

<body>
<h1>LabJSP_00-PRES-JSTL</h1>
<form action="maforme.jsp" method="post">
	<table>
		<tr>
		 <td colspan="2"><h3>Elaborer un gâteau</h3></td>
		</tr>
		<tr>
		<td>Forme du gâteau :</td>
		<td>
		  <select name="shape">
		     <option>rond</option>
		     <option>carré</option>
		     <option>forme de coeur</option>
		   </select>
		</td>
		</tr>
		<tr>
		<td valign="top">Garniture</td>
		<td>
		  <input type="checkbox" name="garni" value="chocolat" />Chocolat<br/>
		  <input type="checkbox" name="garni" value="sucre" />Sucre de canne<br/>
		  <input type="checkbox" name="garni" value="poivre" />Poivre<br/>
		</td>
		</tr>
		
		<tr>
		<td colspan="2">
		  <input type="submit" value="Send"/>
		</td>
		</tr>
	</table>
</form>
</body>
</html>
