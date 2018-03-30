<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification des évaluateurs</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

		<c:out value="${idEval }"></c:out>

	<br>
	<div class="col-md-6">
		<table class="table table-striped" style="text-align: center;"">
			<thead>
				<tr>
					<th>Identifiant
					<th>Nom</th>
					<th>Prénom</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${evaluateurs }" var="eval">
					<tr>
						<td>${eval.idEvaluateur }</td>
						<td>${eval.nomEvaluateur}</td>
						<td>${eval.prenomEvaluateur}</td>
						
						<td><div class="btn-group" role="group">
								<button type="button" class="btn btn-info"
									data-toggle="collapse" data-target="#eval${eval.idEvaluateur }">
									<span class="caret"></span>
								</button>
								<br>
								<div class="collapse" id="eval${eval.idEvaluateur }" name="idEval">
									<div class="starter-template">
										<form method="post">
											<label> Identifiant : ${eval.idEvaluateur } </label> <br/>
											<input type="hidden" id="idEval" name="idEval" value="${eval.idEvaluateur }">
											<label> Prénom : </label> 
											<input type="text" id="prenomeval" name="prenomeval" value="<c:out value="${eval.prenomEvaluateur}"/>" /> <br /> 
											<label>	Nom : </label> 
											<input type="text" id="nomeval" name="nomeval" value="<c:out value="${eval.nomEvaluateur}"/>"/> <br /> 
											<label> Est admin : </label> 
											<select name="estadmin">
												<option value="1">Est Admin</option>
												<option value="0">N'est pas admin</option>
											</select> <br/>
											<label>Login : </label> 
											<input type="text" id="logineval" name="logineval" value="<c:out value="${eval.loginEvaluateur}"/>"/> <br /> 
											<label>Mot de passe : </label> 
											<input type="password" id="mdpeval" name="mdpeval" value="<c:out value="${eval.mdpEvaluateur}"/>" /> <br /> 
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