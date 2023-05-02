<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
	<title>Iniciar Sesión</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<h1>Iniciar Sesión</h1>
	<form action="login">
		<label for="correo">Correo Electrónico:</label>
		<input type="email" id="correo" name="correo" required style="width: 300px;"><br><br>
		<label for="contraseña">Contraseña:</label>
		<input type="password" id="contraseña" name="contraseña" required><br><br>
		<button type="submit">Iniciar Sesión</button>
	</form>
</body>
</html>