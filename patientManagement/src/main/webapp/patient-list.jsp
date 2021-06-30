<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
font-family: montserrat;
background: #AFEEEE;

}
nav{
	height: 100px;
	width: 100%;
	background-color:#E0FFFF
;
}
label.logo{
	font-size: 40px;
	font-weight: bold;
	color: #32CD32 ;
	padding: 0 100px;
	line-height: 80px;
}

nav ul{
	float:right;
	margin-right: 40px; 
}

nav li{
	display: inline-block;
	margin: 0 8px;
	line-height: 80px;


}


nav a{
	color: #20B2AA;
	font-size: 18px;
	font-weight: bold;
	text-transform: uppercase;
	border:1px solid transparent;
	padding: 7px 10px;
	border-radius: 3px;

}

a.active,a:hover{
border:2px solid	#0052cc ;
transition: .5s;
}
</style>
<meta charset="ISO-8859-1">
<title>Patient Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
<nav>
<label class="logo">DentalApp</label>
<ul>

<li> <a  href="#"> accueil</a></li>
<li> <a class="active" href="#"> patient</a></li>
<li> <a href="#">  rendez-vous</a></li>
<li> <a href="#"> dossiers </a></li>
<li> <a href="#">  deconnexion</a></li>

</ul>
</nav>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #87CEFA">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> GESTION DE PATIENT
					 </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">liste Des Patients</a></li>
			
			</ul>
		</nav>
	</header>
		<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Liste des Patients</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajouter
					Nouveau Patient</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Addresse</th>
						<th>Sexe</th>
						<th>numTel</th>
						<th>dateNaissance</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
						
					<c:forEach var="patient" items="${listPatient}">

						<tr>
							<td><c:out value="${patient.id}" /></td>
							<td><c:out value="${patient.nom}" /></td>
							<td><c:out value="${patient.prenom}" /></td>
							<td><c:out value="${patient.addresse}" /></td>
							<td><c:out value="${patient.sexe}" /></td>
							<td><c:out value="${patient.numTel}" /></td>
							<td><c:out value="${patient.dateNaissance}" /></td>
							
							<td><a href="edit?id=<c:out value='${patient.id}' />">Modifier</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${patient.id}' />">Supprimer</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>