<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>SGP - App</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7/
dist/css/bootstrap.css">

<style>
body {
	width: 100%;
	margin: 40px;
}
</style>

</head>

<body>
	<div class="container">
		<h3>Nouveau collaborateur</h3>

		<form action="<%=request.getContextPath()%>/collaborateurs/nouveau"
			method="post" class="form-horizontal">
			<div class="form-group">

				<label class="control-label col-sm-2"> Nom </label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control"
						required="required">
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-2">Prenom </label>
				<div class="col-sm-10">
					<input type="text" name="prenom" class="form-control"
						required="required">
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-2">Date de Naissance </label>
				<div class="col-sm-10">
					<input type="date" name="dateNaissance" class="form-control"
						required="required">
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-2"> Adresse </label>
				<div class="col-sm-10">
					<textarea name="adresse" class="form-control" required="required" maxlength="140" ></textarea>
				</div>
			</div>

			<div class="form-group">

				<label class="control-label col-sm-2">Numéro de sécurité </label>
				<div class="col-sm-10">
					<input type="number" name="secu" class="form-control"
						required="required" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==15) return false;" title="15 chiffres">
				</div>
			</div>

			<button type="submit" class="btn btn-default">Créer</button>
		</form>
	</div>



</body>

</html>