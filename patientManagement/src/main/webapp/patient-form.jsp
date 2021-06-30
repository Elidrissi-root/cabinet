<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #87CEFA">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> GESTION DE PATIENT </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">patients</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${patient != null}">
					<form action="update" method="post">
					
					<h2>
						<c:if test="${patient != null}">
            			Edit Patient
            		</c:if>
            		<c:if test="${patient == null}">
            			Fiche Patient
            		</c:if>
					</h2>
				

				<c:if test="${patient != null}">
					<input type="hidden" name="id" value="<c:out value='${patient.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${patient.nom}' />" class="form-control"
						name="nom" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Prenom</label> <input type="text"
						value="<c:out value='${patient.prenom}' />" class="form-control"
						name="prenom">
				</fieldset>

				<fieldset class="form-group">
					<label>Addresse</label> <input type="text"
						value="<c:out value='${patient.addresse}' />" class="form-control"
						name="addresse">
				</fieldset>
				
				<fieldset class="form-group">
					<label> DateNaissance</label> <input type="text"
						value="<c:out value='${patient.dateNaissance}' />" class="form-control"
						name="dateNaissance">
				</fieldset>
				
				<fieldset class="form-group">
					<label> NumTel</label> <input type="text"
						value="<c:out value='${patient.numTel}' />" class="form-control"
						name="numTel">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Sexe</label> <input type="text"
						value="<c:out value='${patient.sexe}' />" class="form-control"
						name="sexe">
				</fieldset>

				<button type="submit" class="btn btn-success">Sauvegarder</button>
				</form>
				</c:if>
				<c:if test="${patient == null}">
					<form action="insert" method="post">
					
					<h2>
						<c:if test="${patient != null}">
            			Edit Patient
            		</c:if>
            		<c:if test="${patient == null}">
            			Fiche Patient
            		</c:if>
					</h2>


				<c:if test="${patient != null}">
					<input type="hidden" name="id" value="<c:out value='${patient.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${patient.nom}' />" class="form-control"
						name="nom" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Prenom</label> <input type="text"
						value="<c:out value='${patient.prenom}' />" class="form-control"
						name="prenom">
				</fieldset>

				<fieldset class="form-group">
					<label>Addresse</label> <input type="text"
						value="<c:out value='${patient.addresse}' />" class="form-control"
						name="addresse">
				</fieldset>
				
				<fieldset class="form-group">
					<label> DateNaissance</label> <input type="text"
						value="<c:out value='${patient.dateNaissance}' />" class="form-control"
						name="dateNaissance">
				</fieldset>
				
				<fieldset class="form-group">
					<label> NumTel</label> <input type="text"
						value="<c:out value='${patient.numTel}' />" class="form-control"
						name="numTel">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Sexe</label> <input type="text"
						value="<c:out value='${patient.sexe}' />" class="form-control"
						name="sexe">
				</fieldset>

				<button type="submit" class="btn btn-success">Sauvegarder</button>
				</form>
				</c:if>

			
			</div>
		</div>
	</div>
</body>
</html>