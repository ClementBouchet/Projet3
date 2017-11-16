<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Modification du Secteur</title>
</head>
<body>
<p>
<a href ="EscaladeAccueil">Accueil</a>
</p>
<p>
Veuillez compléter les champs pour modifier le secteur <c:out value="${secteur.nom }"/>
</p>

<p>
	<form method = "post" action = "secteur2">
	
		<p>
		<label for="nom"> Nom du secteur : </label>
		<input type="text" value = "<c:out value ="${secteur.nom }" />" id="nom" name="nom"/>
		</p>
		
		<p>
		<label for="site"> Site sur lequel se trouve le secteur : </label>
		
            <select name="site" id="site">
            <c:forEach var="site" items="${ sites }">
       		<option value="<c:out value="${ site.nom }" />"<c:if test ="${ site.nom == secteur.site}"> selected </c:if>><c:out value="${ site.nom }" /></option>       		   
           	</c:forEach>      	
       	</select>
        
		</p>
		
		<p>
		<label for="rocher"> Rocher du secteur: </label>
		</br>
		<input type="text" value = "<c:out value ="${secteur.rocher }" />" id="rocher" name="rocher"/>
		</p>
		<p>
		<label for="id"></label>
		<input type="hidden" value = "<c:out value ="${secteur.num }" />" id="id" name="id"/>
		</p>
			
		<input type="submit" value = "Modifier"/>
	</form>
</p>


</body>
</html>