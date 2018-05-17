<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
<title>Etudiants</title>
</head>
<body>
	<div id="header">
    <jsp:include page="header.jsp"/> <!--Permet de pas réécrire le header à chaque fois-->
</div>

        <div class="col-md-6">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Nom de l'étudiant</th>
                <th>Prénom de l'étudiant</th>
              </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${etudiants }" var="etu">
				<tr>
				<td> ${etu.nomEtudiant}</td>
				<td>${etu.prenomEtudiant}</td>
				<td><div class="btn-group" role="group">
    				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      				<span class="caret"></span>
    				</button>
    					<ul class="dropdown-menu">
      					<li><a href="./ListEvalEtu">Voir ses évaluations</a></li>
    					</ul>
  					</div>
  				</td>
				</tr>
			</c:forEach>
		  </tbody>
          </table>
        </div>
</body>
</html>