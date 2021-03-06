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

	<a href="./lister" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user"></span> Employés</a>
	<a href="../bulletins/lister" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-list"></span> Bulletins</a>


	<h1>Listes des employés</h1>

	<a href="./creer" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user" align="right"></span> Ajouter un
		employe</a>
	<br>
	<br>


	<table class="table table-bordered">

		<thead align="center">
			<td>Date/heure creation</td>
			<td>Matricule</td>
			<td>Grade</td>
		</thead>

		<tbody align="center">
			<c:forEach var="employes" items="${employes}">
				<td>${employes.dateForm()}</td>
				<td>${employes.matricule}</td>
				<td>${employes.grade.code}</td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>