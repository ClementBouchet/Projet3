<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Page 1</title>
</head>
<body>
<p>Bonjour et bemvindo</p>
<p>


Voici le nom du site : ${sites.nom }</br>
Posté par : ${sites.auteur } le ${sites.date }</br>
</br>
${sites.description }

</p>

<p>

	<form method = "post" action = "page1">
		<label for="nom"> Nom : </label>
		<input type="text" id="nom" name="nom"/>
		<input type="submit"/>
	</form>

</p>
<c:if test="${!empty nom }">
<p>
Vous vous appelez <c:out value="${nom}"/>
</p>
</c:if>
</body>
</html>