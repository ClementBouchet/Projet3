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
Veuillez compléter les champs pour ajouter un nouveau site.
</p>

<p>
	<form method = "post" action = "addsite">
	
		<p>
		<label for="nom"> Nom du site : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="lieu"> Lieu ou se trouve le site: </label>
		<input type="text" id="lieu" name="lieu"/>
		</p>
		
		<p>
		<label for="description"> Description du site: </label>
		</br>
		<textarea id="description" name="description" rows="10" cols="50"/></textarea>
		</p>
			
		<input type="submit" value = "Ajouter le site"/>
	</form>
</p>

<p>
<ul>
        <c:forEach var="site" items="${ sites }">
            <li><c:out value="${ site.nom }" />  qui se trouve dans les <c:out value="${ site.lieu }" />
            </br>
            
            <a href = "SeSite?site=<c:out value = "${site.num}"/>">Check </a>
            <p>         </p>
            <p>
            <a href = "Delete?site=<c:out value = "${site.num}"/>">Supprimer ce site </a>
            </p>
            
            </li>
        </c:forEach>
    </ul>
</p>

</body>
</html>