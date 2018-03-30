<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<title>connexion</title>
	<link rel="stylesheet" href="css/bootstrap.css"  type="text/css">
	<link rel="stylesheet" href="css/starter-template.css"  type="text/css">
	
</head>
<body>
	<div id="header">
    <jsp:include page="header.jsp"/> <!--Permet de pas réécrire le header à chaque fois-->
</div>


<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
        <form method="post" action="Connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Login<span class="requis">*</span></label>
                <input type="text" id="login" name="login" value="<c:out value="${utilisateur.login}"/>" size="20" maxlength="60" /><br/>
                <span class="erreur">${form.erreurs['login']}</span><br/>
                

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /><br/>
                <span class="erreur">${form.erreurs['motdepasse']}</span><br/>


                <input type="submit" value="Connexion" class="sansLabel" />
                
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Verification of the user object --%>
                <!--<c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- if session exist then input of the id --%>
                    <p class="succes">ID : ${sessionScope.sessionUtilisateur.id}</p>
                </c:if>-->
            </fieldset>
        </form>
        </div>
</body>
</html>