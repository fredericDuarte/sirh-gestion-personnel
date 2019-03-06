<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
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
.fiche {
	border-top: 1px solid blue;
	width: 100%;
}

.panel-body {
	padding: 15px 0px;
}
</style>
</head>

<body>
	<h1>Les collaborateurs</h1>



	<div class="container">
		<form action="<%=request.getContextPath()%>/collaborateurs/nouveau"
			method="post" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-20">
					<label class="control-label col-sm-2"> rechercher un nom ou
						un prénom qui commence par : </label>
				</div>
				<div class="col-sm-10">
					<input type="text" name="recherche" class="form-control"
						required="required">
					<button type="submit" class="btn btn-default">Chercher</button>

				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<label class="control-label" for="filtre"> Filtrer par
						département :</label>
				</div>
				<div class="col-sm-10">

					<select class="form-control" id="filtre">
						<%
							List<Departement> listeDpt = (List<Departement>) request.getAttribute("listeDpt");
							for (Departement dpt : listeDpt) {
						%>
						<option><%=dpt.getNom()%>
						</option>

						<%
							}
						%>
					</select>

				</div>
			</div>
		</form>
	</div>

	<%
		List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");
		for (Collaborateur user : listeNoms) {
	%>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<%=user.getNom()%>
				<%=user.getPrenom()%>
				<table class="fiche">
					<tr>
						<td rowspan=4>
						  <img src="<%=user.getPhoto()%>"  width="50%"/>
						</td>
						<td>Fonction</td>
						<td><%=user.getAdresse()%></td>
					</tr>
					<tr>

						<td>Département</td>
						<td><%=user.getDateDeNaissance()%></td>
					</tr>
					<tr>

						<td>Email</td>
						<td><%=user.getEmailPro()%></td>
					</tr>
					<tr>

						<td>Téléphone</td>
						<td>06-06-06-06-06</td>
					</tr>

				</table>


			</div>
		</div>



	</div>

	<%
		}
	%>

</body>

</html>