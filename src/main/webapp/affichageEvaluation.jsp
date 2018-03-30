<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
  <head>
	<title>connexion</title>
</head>
<body>
	<div id="header">
    <jsp:include page="header.jsp"/> <!--Permet de pas réécrire le header à chaque fois-->
</div>
<!--  C'est la page d'affichage des évaluations 

 evaluation n° 
 				   <p>${param.id}</p><br>
 				   <p>${param.idEvaluation}</p><br>
				   <p>${param.comComOrale}</p><br>
                   <p>${param.comCompSc}</p><br> 
                   <p>${param.comEntretien}</p><br> 
                   <p>${param.comGlobal}</p><br> 
                   <p>${param.comOrgaIdee}</p><br>
                   <p>${param.curseurAnaDoc}</p><br>
                   <p>${param.curseurComEcrite}</p><br>
                   <p>${param.curseurComOrale}</p><br>
                   <p>${param.curseurCompSc}</p><br>
                   <p>${param.curseurEntretien}</p><br>
                   <p>${param.curseurOrgaIdee}</p><br>
                   <p>${param.dateEvaluation}</p><br>
                   <p>${param.nomSujet}</p><br>
                   <p>${param.pointsAnaDoc}</p><br>
                   <p>${param.pointsComEcrite}</p><br>
                   <p>${param.pointsComOrale}</p><br>
                   <p>${param.pointsCompSc}</p><br>
                   <p>${param.pointsEntretien}</p><br>
                   <p>${param.pointsOrgaIdee}</p><br>
                   <p>${param.pointsTotal}</p><br> -->


<div class="container">

        <div class="starter-template">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Etudiant</th>
                        <th>Evaluateur</th>
                        <th >Sujet</th>
                        <th width=33%>${param.nomSujet}</th>
                        <th >Points</th>
                        <th>Max Points</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th> ${param.IdEtudiant}  </th>
                        <th> ${param.IdEvaluateur} </th>
                        
                        
                        <th> </th>
                        <th> </th>
                        <th> </th>
                        <th> </th>                   
                    </tr>
                    
                    <tr>
                        <th> </th>
                        <th> </th>
                        <th>Curseur <br>0 1 2 3 </th>
                        <th>Commentaire </th>
                        <th> ${param.dateEvaluation} </th>
                        <th> </th>
                    </tr>
                    
                    <tr>
                        <th rowspan=3> Pole Exposé </th>
                        <th> Organisation des idées</th>
                        <th> ${param.curseurOrgaIdee}</th>
                        <th>${param.comOrgaIdee}</th>
                        <th>${param.pointsOrgaIdee}</th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th> Connaissances scientifiques </th>
                        <th>${param.curseurCompSc} </th>
                        <th>${param.comCompSc}</th>
                        <th>${param.pointsCompSc}</th>
                        <th> 10 </th>
                    </tr>
                    
                    <tr>
                        <th> Entretien sur l'exposé</th>
                        <th>${param.curseurEntretien} </th>
                        <th>${param.comEntretien}</th>
                        <th>${param.pointsEntretien}</th>
                        <th> 4 </th>                    
                    </tr>
                    
                    <tr>
                        <th> Pôle étude de documents</th>
                        <th> Analyse et intégration de documents</th>
                        <th>${param.curseurAnaDoc} </th>
                        <th>${param.comAnaDoc}</th>
                        <th>${param.pointsAnaDoc}</th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th rowspan=2> Communication</th>
                        <th> Communication orale </th>
                        <th>${param.curseurComOrale} </th>
                        <th>${param.comComOrale}</th>
                        <th>${param.pointsComOrale}</th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th> Communication écrite </th>
                        <th>${param.curseurComEcrite} </th>
                        <th>${param.comComEcrite}</th>
                        <th>${param.pointsComEcrite}</th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th> </th>
                        <th colspan=2> Commentaire global</th>
                        <th>${param.comGlobal}</th>
                        <th> </th>
                        <th> ${param.pointsTotal}</th>
                    </tr>
                </tbody>
            </table>
            
        </div>
    
    </div>

</body>
</html>