<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Détail du site</title>
</head>
<body>

<p>
Page du site 
</p>
<p>
<c:out value="${site.nom}"/> se situe dans les <c:out value = "${site.lieu }"/>
</br>L'identifiant de ce site est le numéro <c:out value="${iden}"/>
</p>
<p>Description : </br>
<c:out value="${site.description }"/>
</p>

<p>
Ce site contient les secteurs:  
<ul>
        <c:forEach var="secteur" items="${ secteurs }">
            <li><c:out value="${ secteur.nom }" /> </br>
            
            <a href = "SeSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>       
            </li>
        </c:forEach>
    </ul>

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
		<input type="hidden" value = "site" id="type_objet" name="type_objet"/>
		</p>
		
		<p>
		<label for="nom_objet"></label>
		<input type="hidden" value = "<c:out value = "${site.nom }"/>" id="nom_objet" name="nom_objet"/>
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
<a href = "ModifSite?site=<c:out value = "${site.num}"/>">Modifier </a>
</p>
<p><a href="AddSite">Retour ajout Sites</a></p>
</body>
</html>