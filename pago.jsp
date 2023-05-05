<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Pedido</title>

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
            <div class="container">
                <h1 class="text-center">Pedido</h1>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Artículo</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${empty compra}">
                        <p class="text-center fs-2">Tu carrito está vacío.</p>
                        </c:if>
                        <c:if test="${not empty compra}">
                        <c:forEach items="${compra}" var="a">
                        <tr>
                            <td><c:out value="${a.nombre}" /></td>
                            <td><c:out value="${a.cantidad}" /></td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${a.precio * a.cantidad}"/></td>
                        </tr>
                        </c:forEach>
                        </c:if>
                    </tbody>
                </table>

                <div class="text-center mt-3">
                    <h2>Precio total: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}"/></h2>
                </div>
                <div class="text-right mt-3">
                    <a href="./index.html" class="btn btn-secondary">Atrás</a>
                </div>
            </div>
        </main>
    </body>
</html>
