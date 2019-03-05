<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
</head>

<body>
	<h1>Nouveau collaborateur</h1>

	<form action="" method="post">
		<div class="form-group">

			<label> Nom </label>
			<input type="text" name="nom" />
		</div>
		<div class="form-group">

			<label>prenom </label> 
			<input type="text" name="prenom" />
		</div>
		<div class="form-group">

			<label>Date de Naissance </label> 
			<input type="text" name="nom" />
			</p>
			<div class="form-group">

				<label>	Adresse </label> 
				<input type="textarea" name="prenom" />
			</div>

			<div class="form-group">

				<label>Numéro de sécurité </label> 
				<input type="text" name="prenom" />
			</div>

			<button type="submit" class="btn btn-default">Créer</button>
	</form>

</body>

</html>