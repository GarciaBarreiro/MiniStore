<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>

<html>
    <head>
        <title>Iniciar sesión</title>
        
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1"> <!--Garantizar responsividad-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    
    <body>

        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="./index.html">Inicio</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="./registrarse.jsp">Registrarse</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./login.jsp">Iniciar Sesión</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./carrito.jsp">Mi Carrito</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

		<main>
			<div class="d-flex justify-content-center" style="min-height: 100vh;">
				<div class="container mt-5 mx-auto" style="max-width: 700px;">
					<h1 class="text-center mb-4">Iniciar Sesión</h1>
					<form action="login" class="border rounded p-4">
						<div class="form-group">
							<label for="correo">Correo Electrónico:</label>
							<input type="email" id="correo" name="correo" required class="form-control">
						</div>
						<div class="form-group">
							<label for="contraseña">Contraseña:</label>
							<input type="password" id="contraseña" name="clave" required class="form-control">
						</div>
						<button type="submit" class="btn btn-primary btn-block mt-4">Iniciar Sesión</button>
					</form>

					<form class="mt-4">
						<div class="text-right">
								<a href="./registrarse.jsp" class="btn btn-secondary">Registrarse</a>
					</form>
				</div>
			</div>
		</main>

		<%-- Mostrar mensaje de alerta si hay uno --%>
		<c:if test="${not empty errorMessageLogin}">
			<script>
				alert("Inicio de sesión fallido.");
			</script>
			
		</c:if>

	</body>

</html>