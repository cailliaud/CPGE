<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ajout</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	
	<script type="text/javascript">
	function valideretudiant(f){
	    // Si le nom est vide
	    if(!f.prenometu.value){
	        alert("Indiquer un prenom !");return false;}
	    // Si le prénom est vide 
	    else if (!f.nometu.value){
	        alert("Indiquer un nom");return false;}
	    else if (!f.loginetu.value){
	        alert("Indiquer un login");return false;}
	    else if (!f.mdpetu.value){
	        alert("Indiquer un mot de passe");return false;}
	    // Les deux champs existent 
	    else {
		    alert("L'étudiant a été ajouté");return true;}
	}

	function validerevaluateur(f){
	    // Si le nom est vide
	    if(!f.prenomeval.value){
	        alert("Indiquer un prenom !");return false;}
	    // Si le prénom est vide 
	    else if (!f.nomeval.value){
	        alert("Indiquer un nom");return false;}
	    else if (!f.logineval.value){
	        alert("Indiquer un login");return false;}
	    else if (!f.mdpeval.value){
	        alert("Indiquer un mot de passe");return false;}
	    // Les deux champs existent 
	    else {
		    alert("L'évaluateur a été ajouté");return true;}
	}
	function validercompetence(f){
	    // Si le nom est vide
	    if(!f.nomcompetence.value){
	        alert("Indiquer un nom pour la compétence !");return false;}
	    // Si le prénom est vide 
	    else if (!f.valcurseur.value){
	        alert("Indiquer une valeur de curseur");return false;}
	    else {
		    alert("La compétence à été ajoutée");return true;}
	}
</script>

	<br>
	<br>
	
	<div class="container">
		<div class="starter-template">
			<p>
				<a class="btn btn-primary" data-toggle="collapse"
					href="#collapseEtu" role="button" aria-expanded="false"
					aria-controls="collapseEtu"> Ajouter un nouvel étudiant </a>
			</p>
			<div class="collapse" id="collapseEtu">
				<div class="card card-body">
					<form method="post" name="ajoutetu" id="ajoutetu" onsubmit="return valideretudiant(this)">
						<label> Prénom de l'étudiant : </label> <input type="text"
							id="prenometu" name="prenometu" /> <br /> 
							<label> Nom
							de l'étudiant : </label> <input type="text" id="nometu" name="nometu" />
						<br /> <label>Login : </label> <input type="text" id="loginetu"
							name="loginetu" /> <br /> <label>Mot de passe : </label> <input
							type="password" id="mdpetu" name="mdpetu" /> <br /> 
							<!-- <input type=submit value="Valider" /> -->
							<button type="submit" class="btn btn-primary"> Ajouter</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="starter-template">
			<p>
				<a class="btn btn-primary" data-toggle="collapse"
					href="#collapseEval" role="button" aria-expanded="false"
					aria-controls="collapseEval"> Ajouter un nouvel évaluateur </a>
			</p>
			<div class="collapse" id="collapseEval">
				<div class="card card-body">
					<form method="post" onsubmit="return validerevaluateur(this)">
						<label> Prénom de l'évaluateur : </label> <input type="text"
							id="prenomeval" name="prenomeval" /> <br /> <label> Nom
							de l'évaluateur : </label> <input type="text" id="nomeval" name="nomeval" />
						<br /> <label> Est admin : </label> <select name="estadmin">
							<option value="1">Est Admin</option>
							<option value="0">N'est pas admin</option>
						</select> <br /> <label>Login : </label> <input type="text" id="logineval"
							name="logineval" /> <br /> <label>Mot de passe : </label> <input
							type="password" id="mdpeval" name="mdpeval" /> <br /> <input
							type=submit value="Valider" />
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="starter-template">
			<p>
				<a class="btn btn-primary" data-toggle="collapse"
					href="#collapseCompetence" role="button" aria-expanded="false"
					aria-controls="collapseCompetence"> Ajouter une nouvelle compétence </a>
			</p>
			<div class="collapse" id="collapseCompetence">
				<div class="card card-body">
					<form method="post" onsubmit="return validercompetence(this)"> 
						<label> Nom de la compétence : </label> <input type="text"
							id="nomcompetence" name="nomcompetence" /> <br /> <label>
							Valeur maximale du curseur : </label> <input type="number" min="1"
							max="4" id="valcurseur" name="valcurseur" /> <br /> <label>
							Nom de la sous-catégorie associée : </label> <select name="sscat">
							<c:forEach items="${souscategories }" var="souscat">
								<option value="${souscat.idSousCategorie }">${souscat.nomSousCategorie }</option>
							</c:forEach>
						</select> <br> <input type=submit value="Valider" />
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>