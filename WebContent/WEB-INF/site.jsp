<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Détail du site</title>
</head>
<body>

<p>
Page du site 
</p>
<p>
<c:out value="${site.nom}"/> se situe dans les <c:out value = "${site.lieu }"/>
</br>L'identifiant de ce site est le numéro <c:out value="${iden}"/>
</p>
<p>Description : </br>
<c:out value="${site.description }"/>
</p>

<p>
Ce site contient les secteurs:  
<ul>
        <c:forEach var="secteur" items="${ secteurs }">
            <li><c:out value="${ secteur.nom }" /> </br>
            
            <a href = "SeSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>       
            </li>
        </c:forEach>
    </ul>

</p>
<p>
<a href = "ModifSite?site=<c:out value = "${site.num}"/>">Modifier </a>
</p>
<p><a href="AddSite">Retour ajout Sites</a></p>
</body>
</html>