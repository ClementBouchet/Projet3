<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Page 1</title>
</head>
<body>
<p>Bonjour et bemvindo</p>
<p>
        <jsp:useBean id="secteur" class="com.escalade.beans.Secteur" />
        <!-- Initialisation de sa propriété 'nom' : -->
        <jsp:setProperty name="secteur" property="nom" value="Wile E."/>
        <!-- Et affichage de sa valeur : -->
        <jsp:getProperty name="secteur" property="nom" />
        </br>
Le nom du site est <strong>${sites.nom }</strong></br>
Il est situé dans le ${sites.lieu }</br>
Il possède ${sites.nbrVoies } voies</br>
La roche du site est en ${sites.rocher }</br>
On y trouve notamment le secteur ${secteurs.nom }
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