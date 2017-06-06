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

	<form method="post" class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>
				<h1 align="center">Ajouter un Employé</h1>
			</legend>

			<!-- Input Matricule -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Matricule</label>
				<div class="col-md-4">
					<input id="textinput" name="matricule" type="text" placeholder=""
						class="form-control input-md">
				</div>
			</div>


			<!-- Select Entreprise -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Entreprise</label>
				<div class="col-md-4">

					<select id="selectbasic" name="entreprise" class="form-control">
						<c:forEach var="entreprise" items="${entreprise}">
							<option value="${entreprise.id}">${entreprise.denomination}</option>
						</c:forEach>
					</select>

				</div>
			</div>

			<!-- Select Profil -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Profil</label>
				<div class="col-md-4">

					<select id="selectbasic" name="profil" class="form-control">
						<c:forEach var="profil" items="${profil}">
							<option value="${profil.id}">${profil.code}</option>
						</c:forEach>
					</select>

				</div>
			</div>

			<!-- Select Grade -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Grade</label>
				<div class="col-md-4">

					<select id="selectbasic" name="grade" class="form-control">
						<c:forEach var="grade" items="${grade}">
							<option value="${grade.id}">${grade.code}</option>
						</c:forEach>
					</select>

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary">Ajouter</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>