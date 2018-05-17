<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"  type="text/css">
<link rel="stylesheet" href="css/starter-template.css"  type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.5/js/mdb.min.js"></script>
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
			<a class="navbar-brand" href="./index">CPGE</a>
		</div> 
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<c:if test="${empty sessionScope.sessionUtilisateur}">
          		<li class="active"><a href="./Connexion">LogIn</a></li>
          		</c:if>
          		<c:if test="${!empty sessionScope.sessionUtilisateur}">
          		<li class="active"><a href="./deconnexion">LogOut</a></li>
          		</c:if>
          		
          		<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<c:if test="${sessionScope.sessionUtilisateur.profil == 'Etudiant'}">
					<li class="active"><a href="./ListEvalEtu">Mes Évaluations</a></li>
					</c:if>
				</c:if>	
				
				<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<c:if test="${sessionScope.sessionUtilisateur.profil == 'Evaluateur'}">
						<li class="dropdown">
          					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consulter<span class="caret"></span></a>
         					<ul class="dropdown-menu">
           							<li><a href="./GestionEtudiants">Les étudiants</a></li>
          					</ul>
						<li class="dropdown">
						 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Évaluation<span class="caret"></span></a>
         				<ul class="dropdown-menu">
           					<li><a href="./ListEvalEvaluateur">Mes Évaluations</a></li>
            				<li class="active"><a href="./formulaireServlet">Nouvelle Evaluation</a></li>
          				</ul>
          				
					</c:if>
				</c:if>	
				
				<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<c:if test="${sessionScope.sessionUtilisateur.profil == 'Administrateur'}">
					<li class="dropdown">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consulter<span class="caret"></span></a>
         				<ul class="dropdown-menu">
           					<li><a href="./GestionEtudiants">Les étudiants</a></li>
            				<li><a href="./ListEvaluateurs">Les évaluateurs</a></li>
            				<li><a href="#">Les évaluations</a></li>
          				</ul>
          			<li class="dropdown">
						 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Évaluation<span class="caret"></span></a>
         				 <ul class="dropdown-menu">
           					<li><a href="http://localhost:8080/cpge/ListEvalEvaluateur">Mes Évaluations</a></li>
            				<li class="active"><a href="./formulaireServlet">Nouvelle Evaluation</a></li>
          				</ul>	
          			<li><a href="./ajout">Ajout</a></li>	
					<li class="dropdown">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Modification<span class="caret"></span></a>
         				<ul class="dropdown-menu">
           					<li><a href="./modificationEtudiant">Modification des étudiants</a></li>
            				<li><a href="./ModificationEvaluateurServlet">Modification des évaluateurs</a></li>
          				</ul>
          			<li class="active"><a href="./suppression">Suppression</a></li>
          		
          		
					</c:if>
				</c:if>	
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

</body>
</html>