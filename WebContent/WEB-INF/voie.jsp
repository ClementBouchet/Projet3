<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>D�tail de la voie</title>
</head>
<body>

<p>
Page de la voie  :  <c:out value = "${nom }"/>
</p>

<p>
<c:out value="${voie.nom}"/> se situe dans les <c:out value = "${voie.secteur }"/>
</br>L'identifiant de cette voie est le num�ro <c:out value="${iden}"/>
</p>

<p>Longueur :    <c:out value="${voie.longueur }"/> m�tres</p>

<p>
Difficult�:  <c:out value ="${voie.cotation }"/>
</p>

<p>
<a href = "ModifVoie?voie=<c:out value = "${voie.num}"/>">Modifier </a>
</p>
<p><a href="AddVoie">Retour ajout Voies</a></p>
</body>
</html>