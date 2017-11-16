<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Connexion</title>
</head>
<body>
<p>
<a href ="EscaladeAccueil?utilisateur=<c:out value ="${utilisateur.identifiant }"/>">Accueil</a>
</p>
<p>
<strong>Se Connecter</strong>
</p>

<p>
	<form method = "post" action = "connexion">
	
		<p>
		<label for="identifiant"> Identifiant : </label>
		<input type="text" id="identifiant" name="identifiant" required/>   <c:if test ="${validation.ident == 'notok' }">Cet identifiant n'existe pas</c:if>
		</p>
			
		<p>
		<label for="password"> Mot de passe : </label>
		<input type="password" id="password" name="password" required/>
		</p>
			
		<input type="submit" value="Connexion"/>
	</form>
</p>
<p>
<c:if test ="${validation.pass == 'ok'}">Vous vous êtes bien connecté</br>
Bienvenue sur le site, <strong><c:out value = "${utilisateur.identifiant }"/></strong>
</c:if>
<c:if test ="${validation.pass == 'notok' }">Mot de passe incorrect</c:if>
</p>

</body>
</html>