<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Modification du Site</title>
</head>
<body>
<p>
<a href ="EscaladeAccueil">Accueil</a>
</p>
<p>
Veuillez compléter les champs pour modifier le site <c:out value="${site.nom }"/>
</p>

<p>
	<form method = "post" action = "site2">
	
		<p>
		<label for="nom"> Nom du site : </label>
		<input type="text" value = "<c:out value ="${site.nom }" />" id="nom" name="nom"/>
		</p>
		
		<p>
		<label for="lieu"> Lieu ou se trouve le site: </label>
		<input type="text" value = "<c:out value ="${site.lieu }" />" id="lieu" name="lieu"/>
		</p>
		
		<p>
		<label for="description"> Description du site: </label>
		</br>
		<textarea id="description" name="description" rows="10" cols="50"><c:out value ="${site.description }" /> </textarea>
		</p>
		<p>
		<label for="id"></label>
		<input type="hidden" value = "<c:out value ="${site.num }" />" id="id" name="id"/>
		</p>
			
		<input type="submit" value = "Modifier"/>
	</form>
</p>


</body>
</html>