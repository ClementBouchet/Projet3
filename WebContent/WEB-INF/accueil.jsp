<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Accueil</title>
</head>
<body>

<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }">Bienvienue, <strong><c:out value = "${sessionScope.utilisateur.identifiant }"/></strong></c:if>
</p>
<p>
<c:if test ="${sessionScope.utilisateur.identifiant == null }"><a href = "Connexion">Connexion</a></c:if>
</p>
<p>
Bonjour et bienvenue sur le site communautaire des grimpeurs!</br>

Consultez et partagez(bientôt) toutes les infos sur les meilleurs spots!
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
<p>
<a href = "AddSite">Ajouter un site</a>
</p>

<p>
<a href = "AddSecteur">Ajouter un secteur</a>
</p>

<p>
<a href = "AddVoie">Ajouter une voie</a>
</p>

<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "Deconnexion">Deconnexion</a></c:if>
</p>

</body>
</html>