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
<p>
<a href = "ModifSecteur?secteur=<c:out value = "${secteur.num}"/>">Modifier </a>
</p>
<p><a href="AddSecteur">Retour</a></p>
</body>
</html>