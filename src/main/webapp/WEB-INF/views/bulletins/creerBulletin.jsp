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

	<form method="post" class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>
				<h1 align="center">Créer un Bulletin</h1>
			</legend>

			<!-- Select Profil -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Période</label>
				<div class="col-md-4">

					<select id="selectbasic" name="periode" class="form-control">
						<c:forEach var="periode" items="${periode}">
							<option value="${periode.id}">${periode.dateDebut}-
								${periode.dateFin}</option>
						</c:forEach>
					</select>

				</div>
			</div>

			<!-- Select Grade -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Matricule</label>
				<div class="col-md-4">

					<select id="selectbasic" name="matricule" class="form-control">
						<c:forEach var="remun" items="${remun}">
							<option value="${remun.id}">${remun.matricule}</option>
						</c:forEach>
					</select>

				</div>
			</div>

			<!-- Input Periode -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Prime
					exceptionnelle</label>
				<div class="col-md-4">
					<input id="textinput" name="prime" type="text" placeholder=""
						class="form-control input-md">
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary">Créer</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>