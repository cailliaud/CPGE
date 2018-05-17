<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CPGE</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	
	<div class="container">

		<div class="starter-template">
			<br>
			<br>
			<h1><strong> Bienvenue sur la plateforme CPGE !</strong></h1>
			<h4>   <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes"> Vous êtes connecté avec le compte de ${sessionScope.sessionUtilisateur.login} </p>
                </c:if> </h4>
			
			<br>
			<br> 
			<img src="logo-barthou.png" height="200" width="400" class="img-fluid" alt="Responsive image">
			
			
		</div>

	</div>
	
</body>
</html>