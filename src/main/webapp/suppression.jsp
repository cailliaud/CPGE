<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Suppression</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div class="container">

		<div class="starter-template">
			<h3>Suppression d'un étudiant</h3>
			<form method="post">
				<label>Nom et prénom de l'étudiant :</label> <select
					name="supetu">
					<c:forEach items="${etudiants}" var="etu">
						<option value="${etu.idEtudiant }">${etu.nomEtudiant }
							${etu.prenomEtudiant}</option>
					</c:forEach>
				</select> <input type=submit value="Supprimer" />
			</form>
		</div>

	</div>
	<br>

	<div class="container">

		<div class="starter-template">
			<h3>Suppression d'un évaluateur</h3>
			<form method="post">
				<label>Nom et prénom de l'évaluateur :</label> <select 
					name="supeval">
					<c:forEach items="${evaluateurs }" var="eval">
						<option value="${eval.idEvaluateur }">${eval.nomEvaluateur }
							${eval.prenomEvaluateur }</option>
					</c:forEach>
				</select> <input type=submit value="Supprimer" />
			</form>
		</div>

	</div>
	
	<div class="container">

		<div class="starter-template">
			<h3>Suppression d'une compétence</h3>
			<form method="post">
				<label>Nom de la compétence :</label> <select 
					name="supcomp">
					<c:forEach items="${competences }" var="comp">
						<option value="${comp.idCompetence }">${comp.nomCompetence }
							</option>
					</c:forEach>
				</select> <input type=submit value="Supprimer" />
			</form>
		</div>
		
		<c:if test="${!empty test }"><c:out value="${test }"></c:out></c:if>

	</div>
</body>
</html>