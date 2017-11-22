<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Détail de la voie</title>
</head>
<body>

<p>
Page de la voie  :  <c:out value = "${nom }"/>
</p>

<p>
<c:out value="${voie.nom}"/> se situe dans les <c:out value = "${voie.secteur }"/>
</br>L'identifiant de cette voie est le numéro <c:out value="${iden}"/>
</p>

<p>Longueur :    <c:out value="${voie.longueur }"/> mètres</p>

<p>
Difficulté:  <c:out value ="${voie.cotation }"/>
</p>

<p>
<a href = "ModifVoie?voie=<c:out value = "${voie.num}"/>">Modifier </a>
</p>
<p><a href="AddVoie">Retour ajout Voies</a></p>
</body>
</html>