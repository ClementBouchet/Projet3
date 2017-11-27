<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Détail de la voie</title>
</head>
<body>

<p>
Page de la voie  :  <c:out value = "${nom }"/>
</p>

<p>
<c:out value="${voie.nom}"/> se situe dans les <c:out value = "${voie.secteur }"/>
</br>L'identifiant de cette voie est le numéro <c:out value="${iden}"/>
</p>

<p>Longueur :    <c:out value="${voie.longueur }"/> mètres</p>

<p>
Difficulté:  <c:out value ="${voie.cotation }"/>
</p>

<p>Commentaires</p>

<p>
Ajouter un commentaire : 
</p>

<p>

	<form method = "post" action = "addcom">
		
		<p>
		<label for="description"> </label>
		</br>
		<textarea id="description" name="description" rows="6" cols="50"/></textarea>
		</p>
		
		<p>
		<label for="type_objet"></label>
		<input type="hidden" value = "voie" id="type_objet" name="type_objet"/>
		</p>
		
		<p>
		<label for="nom_objet"></label>
		<input type="hidden" value = "<c:out value = "${voie.nom }"/>" id="nom_objet" name="nom_objet"/>
		</p>
		
		<p>
		<label for="id_objet"></label>
		<input type="hidden" value = "<c:out value = "${iden }"/>" id="id_objet" name="id_objet"/>
		</p>
			
		<input type="submit" value = "Ajouter le commentaire"/>
	</form>
	
</p>

<p>
<ul>
	<c:forEach var="com" items="${coms }">
	<li>Posté par : <i><c:out value = "${com.auteur }"/></i></br>
	"<c:out value = "${com.description }"/>"</li>
	</c:forEach>
</ul>
</p>

<p>
<a href = "ModifVoie?voie=<c:out value = "${voie.num}"/>">Modifier </a>
</p>
<p><a href="AddVoie">Retour ajout Voies</a></p>
</body>
</html>