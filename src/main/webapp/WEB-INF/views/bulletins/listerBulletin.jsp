<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="icon" type="image/png"
	href="http://www.salaire-brut-en-net.fr/wp-content/uploads/favicon2.png" />
<title>SGP - App</title>
</head>

<body>

	<a href="../employes/lister" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user"></span> Employés</a>
	<a href="./lister" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-list"></span> Bulletins</a>


	<h1>Listes des bulletins</h1>

	<a href="./creer" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user" align="right"></span> Ajouter un
		bulletin</a>
	<br>
	<br>


	<table class="table table-bordered">

		<thead>
			<td>Date/heure creation</td>
			<td>Periode</td>
			<td>Matricule</td>
			<td>Salaire Brut</td>
			<td>Net Imposable</td>
			<td>Net à payer</td>
		</thead>

		<tbody>
			<c:forEach var="bulletins" items="${bulletins}">
				<td>${bulletins.dateForm()}</td>
				<td>${bulletins.periode.dateDebut}-
					${bulletins.periode.dateFin}</td>
				<td>${bulletins.remunerationEmploye.matricule}</td>
				<td>${calcul.get(bulletins.id-1).salaireBrut}</td>
				<td>${calcul.get(bulletins.id-1).netImposable}</td>
				<td>${calcul.get(bulletins.id-1).netAPayer}</td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>