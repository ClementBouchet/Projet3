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
Veuillez compléter les champs pour ajouter un nouveau secteur.
</p>

<p>
	<form method = "post" action = "addsecteur">
	
		<p>
		<label for="nom"> Nom du secteur : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="site"> Site sur lequel se trouve le secteur : </label>
		
            <select name="site" id="site">
            <c:forEach var="site" items="${ sites }">
       		<option value="<c:out value="${ site.nom }" />"><c:out value="${ site.nom }" /></option>       		   
           	</c:forEach>      	
       	</select>
        
		</p>
			
		<p>
		<label for="rocher"> Rocher du secteur : </label>
		<input type="text" id="rocher" name="rocher"/>
		</p>
			
		<input type="submit"/>
	</form>
</p>

<p>
<ul>
        <c:forEach var="secteur" items="${ secteurs }">
            <li><c:out value="${ secteur.nom }" />  qui se trouve dans le site :  <c:out value="${ secteur.site }" />
                 </br>
            
            <a href = "SeSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>
			<p>
            <a href = "Delete?secteur=<c:out value = "${secteur.num}"/>">Supprimer ce secteur </a>
            </p>      
            </li>
        </c:forEach>
    </ul>
</p>

</body>
</html>