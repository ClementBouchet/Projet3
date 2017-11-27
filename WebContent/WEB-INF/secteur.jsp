<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Accueil</title>
</head>
<body>
<p>
<a href ="EscaladeAccueil">Accueil</a>
</p>
<p>
Page du secteur
</p>
<p>
<c:out value="${secteur.nom}"/> se situe dans le site <c:out value = "${secteur.site }"/>
</br>L'identifiant de ce secteur est le numéro <c:out value="${iden}"/>
</p>
<p>Rocher : </br>
<c:out value="${secteur.rocher }"/>
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
		<input type="hidden" value = "secteur" id="type_objet" name="type_objet"/>
		</p>
		
		<p>
		<label for="nom_objet"></label>
		<input type="hidden" value = "<c:out value = "${secteur.nom }"/>" id="nom_objet" name="nom_objet"/>
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
<a href = "ModifSecteur?secteur=<c:out value = "${secteur.num}"/>">Modifier </a>
</p>
<p><a href="AddSecteur">Retour</a></p>
</body>
</html>