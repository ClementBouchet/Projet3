<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>D�tail du secteur</title>
</head>
<body>

<p>
Le Secteur � bien �t� modifi�!
</p>
<p>
<c:out value="${secteur.nom}"/> se situe dans le site   <c:out value = "${secteur.site }"/>
</br>L'identifiant de ce secteur est le num�ro <c:out value="${iden}"/>
</p>
<p>Rocher : </br>
<c:out value="${secteur.rocher }"/>
</p>


<a href = "ModifSecteur?secteur=<c:out value = "${secteur.num}"/>">Modifier </a>
</p>
<p><a href="AddSecteur">Retour ajout Secteurs</a></p>
</body>
</html>