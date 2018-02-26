<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<title>Bienvenue sur le projet CPGE</title>
	<link rel="stylesheet" href="css/bootstrap.css"  type="text/css">
	<link rel="stylesheet" href="css/starter-template.css"  type="text/css">
	
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<li><a href="ajout.jsp">Ajout</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h3>Affichage des étudiants et de leurs pseudos</h3>
				<c:forEach items="${etudiants }" var="eval">
					<p>${eval.prenomEtudiant }${eval.nomEtudiant } a pour login ${eval.loginEtudiant }</p>
				</c:forEach>
		</div>

	</div>
	<br>
	<div class="container">

		<div class="starter-template">
			<h3>Affichage des évaluateurs et de leurs pseudos</h3>
			<c:forEach items="${evaluateurs }" var="eval">
				<p>${eval.prenomEvaluateur }${eval.nomEvaluateur } a pour login ${eval.loginEvaluateur }</p>
			</c:forEach>
		</div>

	</div>
	<br>
	
	<c:if test="${!empty prenomE && (!empty nomE) && (!empty loginE) && (!empty mdpE)}"><p><c:out value=" résultat du boolean : ${okay }" /></p></c:if> 
	
	<div class="container">

		<div class="starter-template">
			<h3>Ajouter un nouvel étudiant  </h3>
			<form method="post">
				<label> Prénom de l'étudiant : </label>
				<input type="text" id="prenometu" name="prenometu"/>
				<br/>
				<label> Nom de l'étudiant : </label>
				<input type="text" id="nometu" name="nometu"/>
				<br/>
				<label>Login : </label>
				<input type="text" id="loginetu" name="loginetu"/>
				<br/>
				<label>Mot de passe : </label>
				<input type="password" id="mdpetu" name="mdpetu"/>
				<br/>
				<input type=submit value="Valider"/>
			</form>
		</div>

	</div>
	
	<c:if test="${!empty prenomEval && (!empty nomEval) && (!empty loginEval) && (!empty mdpEval)}"><p><c:out value=" Nom : ${nomEval }, Prénom : ${prenomEval }, Admin : ${estAdmin }, Login : ${loginEval } et Mdp : ${mdpEval }" /></p></c:if> 
	
	<div class="container">

		<div class="starter-template">
			<h3>Ajouter un nouvel évaluateur  </h3>
			<form method="post">
				<label> Prénom de l'évaluateur : </label>
				<input type="text" id="prenomeval" name="prenomeval"/>
				<br/>
				<label> Nom de l'évaluateur : </label>
				<input type="text" id="nomeval" name="nomeval"/>
				<br/>
				<label> Est admin (0 = non | 1 = oui) : </label>
				<select name="estadmin">
					<option value="1">Est Admin</option>
        			<option value="0">N'est pas admin</option>
				</select>			
				<br/>
				<label>Login : </label>
				<input type="text" id="logineval" name="logineval"/>
				<br/>
				<label>Mot de passe : </label>
				<input type="password" id="mdpeval" name="mdpeval"/>
				<br/>
				<input type=submit value="Valider"/>
			</form>
		</div>

	</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>