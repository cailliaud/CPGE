<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
<title>Évaluateurs</title>
</head>
<body>
	<div id="header">
    <jsp:include page="header.jsp"/> <!--Permet de pas réécrire le header à chaque fois-->
</div>


	 


        <div class="col-md-6">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Nom de l'évaluateur</th>
                <th>Prénom de l'évaluateur</th>
              </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${evaluateur}" var="evaluateur">
				<tr>
				<td> ${evaluateur.nomEvaluateur}</td>
				<td>${evaluateur.prenomEvaluateur}</td>
				<td><div class="btn-group" role="group">
    				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      				<span class="caret"></span>
    				</button>
    					<ul class="dropdown-menu">
      					<li><a href="<c:url value='/AffichageEvaluation' > 
                   <c:param name="idEtudiant" value="${evaluations.idEtudiant}" />
                   <c:param name="idEvaluateur" value="${evaluations.idEvaluateur}" />
                   <c:param name="idEvaluation" value="${evaluations.idEvaluation}" />
                   <c:param name="comComOrale" value="${evaluations.comComOrale}" /> 
                   <c:param name="comComOrale" value="${evaluations.comComEcrite}" /> 
                   <c:param name="comCompSc" value="${evaluations.comCompSc}" /> 
                   <c:param name="comEntretien" value="${evaluations.comEntretien}" /> 
                   <c:param name="comGlobal" value="${evaluations.comGlobal}" /> 
                   <c:param name="comOrgaIdee" value="${evaluations.comOrgaIdee}" />
                   <c:param name="curseurAnaDoc" value="${evaluations.curseurAnaDoc}" />
                   <c:param name="curseurComEcrite" value="${evaluations.curseurComEcrite}" />
                   <c:param name="curseurComOrale" value="${evaluations.curseurComOrale}" />
                   <c:param name="curseurCompSc" value="${evaluations.curseurCompSc}" />
                   <c:param name="curseurEntretien" value="${evaluations.curseurEntretien}" />
                   <c:param name="curseurOrgaIdee" value="${evaluations.curseurOrgaIdee}" />
                   <c:param name="dateEvaluation" value="${evaluations.dateEvaluation}" />
                   <c:param name="nomSujet" value="${evaluations.nomSujet}" />
                   <c:param name="pointsAnaDoc" value="${evaluations.pointsAnaDoc}" />
                   <c:param name="pointsComEcrite" value="${evaluations.pointsComEcrite}" />
                   <c:param name="pointsComOrale" value="${evaluations.pointsComOrale}" />
                   <c:param name="pointsCompSc" value="${evaluations.pointsCompSc}" />
                   <c:param name="pointsEntretien" value="${evaluations.pointsEntretien}" />
                   <c:param name="pointsOrgaIdee" value="${evaluations.pointsOrgaIdee}" />
                   <c:param name="pointsTotal" value="${evaluations.pointsTotal}" />                 
               </c:url>
               "">Voir ses évaluations</a></li>
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