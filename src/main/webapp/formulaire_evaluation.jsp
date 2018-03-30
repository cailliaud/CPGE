<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Nouvelle évaluation</title>

<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

<div class="container">

        <div class="starter-template">
            <form method="post">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Etudiant</th>
                        <th>Evaluateur</th>
                        <th >Sujet</th>
                        <th width=33%><textarea name='nomSujet' id='nomSujet' rows="1" cols="50" placeholder="Veuillez entrer le nom du sujet "></textarea></th>
                        <th >Points</th>
                        <th>Max Points</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th><select name="idEtudiant">
                            <c:forEach items="${etudiants}" var="etu">
                                <option value="${etu.idEtudiant}">${etu.nomEtudiant } ${etu.prenomEtudiant}</option>
                            </c:forEach>
                            </select>
                        </th>
	                    <th><select name="idEvaluateur">
                            <c:forEach items="${evaluateurs}" var="evaluateur">
                                <option value="${evaluateur.idEvaluateur}">${evaluateur.nomEvaluateur } ${evaluateur.prenomEvaluateur}</option>
                            </c:forEach>
                            </select>
                        </th>
	                    
                        
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
                        <th> <input type="date" id="dateEvaluation" name="dateEvaluation"  "/> </th>
                        <th> </th>
                    </tr>
                    
                    <tr>
                        <th rowspan=3> Pole Exposé </th>
                        <th> Organisation des idées</th>
                        <th><input max="3" min="0" type="number" id="curseurOrganisationIdees" name="curseurOrganisationIdees" /> </th>
                        <th><textarea name='commentaireOrganisationIdees' id='commentaireOrganisationIdees' rows="3" cols="50" placeholder="Veuillez entrer un commentaire "></textarea></th>
                        <th><input  max="4" min="0" type="number" id="pointsOrganisationIdees" name="pointsOrganisationIdees"/></th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th> Connaissances scientifiques </th>
                        <th><input type="number" max="3" min="0" id="curseurConnaissancesScientifiques" name="curseurConnaissancesScientifiques"/> </th>
                        <th><textarea name='commentaireConnaissancesScientifiques' id='commentaireConnaissancesScientifiques' rows="3" cols="50" placeholder="Veuillez entrer un commentaire "></textarea></th>
                        <th><input max="10" min="0"type="number" id="pointsConnaissancesScientifiques" name="pointsConnaissancesScientifiques"/></th>
                        <th> 10 </th>
                    </tr>
                    
                    <tr>
                        <th> Entretien sur l'exposé</th>
                        <th><input type="number" max="3" min="0" id="curseurEntretienExpose" name="curseurEntretienExpose"/> </th>
                        <th><textarea name='commentaireEntretienExpose' id='commentaireEntretienExpose' rows="3" cols="50" placeholder="Veuillez entrer un commentaire "></textarea></th>
                        <th><input max="4" min="0"type="number" id="pointsEntretienExpose" name="pointsEntretienExpose"/></th>
                        <th> 4 </th>                    
                    </tr>
                    
                    <tr>
                        <th> Pôle étude de documents</th>
                        <th> Analyse et intégration de documents</th>
                        <th><input type="number" max="3" min="0" id="curseurAnalyseDoc" name="curseurAnalyseDoc"/> </th>
                        <th><textarea name='commentaireAnalyseDoc' id='commentaireAnalyseDoc' rows="3" cols="50" placeholder="Veuillez entrer un commentaire "></textarea></th>
                        <th><input max="4" min="0"type="number" id="pointsAnalyseDoc" name="pointsAnalyseDoc"/></th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th rowspan=2> Communication</th>
                        <th> Communication orale </th>
                        <th><input type="number" max="3" min="0" id="curseurComOrale" name="curseurComOrale"/> </th>
                        <th><textarea name='commentaireComOrale' id='commentaireComOrale' rows="3" cols="50" placeholder="Veuillez entrer un commentaire "></textarea></th>
                        <th><input max="4" min="0" type="number" id="pointsComOrale" name="pointsComOrale"/></th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th> Communication écrite </th>
                        <th><input type="number" max="3" min="0" id="curseurComEcrite" name="curseurComEcrite"/> </th>
                        <th><textarea name='commentaireComEcrite' id='commentaireComEcrite' rows="3" cols="50" placeholder="Veuillez entrer un commentaire "></textarea></th>
                        <th><input max="4" min="0" type="number" id="pointsComEcrite" name="pointsComEcrite"/></th>
                        <th> 4 </th>
                    </tr>
                    
                    <tr>
                        <th> </th>
                        <th colspan=2> Commentaire global</th>
                        <th><textarea name='commentaireGlobal' id='commentaireGlobal' rows="3" cols="50" placeholder="Veuillez entrer un commentaire global "></textarea></th>
                        <th> </th>
                        <th> </th>
                    </tr>
                </tbody>
            </table>
            <button type="submit" class="btn btn-primary">Valider</button>
            </form>
        </div>
    
    </div>
    <br/>
    
    

</body>
</html>