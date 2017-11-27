<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Affichage Base de Données</title>
</head>
<body>
<p>
<a href = "EscaladeAccueil">Retour Accueil</a>
</p>

<p>
	<form method = "post" action = "affichagebdd">
		<label for="recherche"> Recherche : </label>
		<input type="text" id="recherche" name="recherche"/>
		<p>
       	<label for="critere1">Sélectionnez le massif montagneux de votre choix :  </label>
       	<select name="critere1" id="critere1">
       		<option value="">Partout</option>
       		<option value="pyrennees">Pyrénnées</option>
           	<option value="alpes">Alpes</option>         	
       	</select>
		</p>
		<input type="submit" value = "Rechercher"/>
	</form>
</p>

<p>Resultat de la recherche</p>
<p>Recherche : <c:out value = "${mot}"/></p>
<p>Critere : <c:out value = "${mot2}"/></p>
<p>Page de résultat n° : <c:out value = "${page}"/></p>
<p>Sites trouvés :</p>
<p>
<ul>
        <c:forEach var="site" items="${ recherche.sites }">
            <li><c:out value="${ site.nom }" />  qui se trouve dans les <c:out value="${ site.lieu }" />
            </br>
            
            <a href = "SeSite?site=<c:out value = "${site.num}"/>">Check </a>

            </li>
        </c:forEach>
    </ul>
</p>
<p>
		<c:forEach var="a" items="${ recherche.nbrPages }">
                       
            <a href = "EscaladeBdd?page=<c:out value = "${a}"/>&recherche=<c:out value = "${mot}"/>&critere1=<c:out value = "${mot2}"/>">Page <c:out value="${ a }"/></a>      
            
        </c:forEach>
</p>
<p>Secteurs correspondants :</p>
<p>
<ul>
        <c:forEach var="secteur" items="${ secteurs }">
            <li><c:out value="${ secteur.nom }" />  qui se trouve dans le site <c:out value="${ secteur.site }" />
            </br>
            
            <a href = "SeSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>

            </li>
        </c:forEach>
    </ul>
</p>

</body>
</html>