<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification des étudiants</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	
	<c:out value="${idEtudiant }"></c:out>

	<br>
	<div class="col-md-6">
		<table class="table table-striped" style="text-align: center;"">
			<thead>
				<tr>
					<th>Nom de l'étudiant</th>
					<th>Prénom de l'étudiant</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${etudiants }" var="etu">
					<tr>
						<td id="idEtudiant">${etu.idEtudiant }</td>
						<td>${etu.nomEtudiant}</td>
						<td>${etu.prenomEtudiant}</td>
						
						<td><div class="btn-group" role="group">
								<button type="button" class="btn btn-info"
									data-toggle="collapse" data-target="#etu${etu.idEtudiant }">
									<span class="caret"></span>
								</button>
								<br>
								<div class="collapse" id="etu${etu.idEtudiant }" name="idEtu">
									<div class="starter-template">
										<form method="post">
											<label> Identifiant : ${etu.idEtudiant } </label> <br/>
											<input type="hidden" id="idE" name="idE" value="${etu.idEtudiant }">
											<label> Prénom : </label> 
											<input type="text" id="prenometu" name="prenometu" value="<c:out value="${etu.prenomEtudiant}"/>" /> <br /> 
											<label>	Nom : </label> 
											<input type="text" id="nometu" name="nometu" value="<c:out value="${etu.nomEtudiant}"/>"/> <br /> 
											<label>Login : </label> 
											<input type="text" id="loginetu" name="loginetu" value="<c:out value="${etu.loginEtudiant}"/>"/> <br /> 
											<label>Mot de passe : </label> 
											<input type="password" id="mdpetu" name="mdpetu" value="<c:out value="${etu.mdpEtudiant}"/>"/> <br /> 
										    <input type=submit value="Modifier" />
										 
										</form>
									</div>
								</div>
							</div></td>
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>