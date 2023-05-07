<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Carrito de Compra</title>
        
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
            <h1 class="text-center">Carrito de Compra</h1>
            <form action="eliminar">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Artículo</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty carritoBean.carrito}">
                        <p class="text-center fs-2">Tu carrito está vacío.</p>
                    </c:if>
                        <c:if test="${not empty carritoBean.carrito}">
                            <c:forEach items="${carritoBean.carrito}" var="a">
                                <tr>
                                    <td><c:out value="${a.nombre}" /></td>
                                    <td><c:out value="${a.cantidad}" /></td>
                                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${a.precio * a.cantidad}"/></td>
                                    <td><input type="checkbox" name="disk" value="${a.nombre}"></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
                <div class="text-center">
                    <c:if test="${not empty sessionScope.carritoBean.carrito}">
                        <input type="submit" class="btn btn-sm btn-danger mt-3" value="Eliminar">
                    </c:if>
                </div>
            </form>

            <c:choose>
                <c:when test="${not empty sessionScope.correo && not empty sessionScope.carritoBean.carrito}">
                    <form action="procesar_pago">
                        <div class="form-group mb-3 mx-auto" style="max-width: 400px;">
                            <label for="tipo_tarjeta">Tipo de tarjeta:</label>
                            <select class="form-control" name="tipo_tarjeta" id="tipo_tarjeta">
                                <option value="visa">Visa</option>
                                <option value="mastercard">Mastercard</option>
                                <option value="american_express">American Express</option>
                            </select>
                        </div>
                        <div class="form-group mb-3 mx-auto" style="max-width: 400px;">
                            <label for="numero_tarjeta">Número de tarjeta:</label>
                            <input type="text" class="form-control" name="numero_tarjeta" id="numero_tarjeta" pattern="[0-9\s]*" onkeyup="separarNumeroTarjeta()">
                        </div>
                        <div class="text-center mb-3">
                            <button type="submit" class="btn btn-primary">Procesar pago</button>
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <c:if test="${not empty sessionScope.carritoBean.carrito}">
                        <form action="comprar">
                            <div class="text-center mt-3">
                                <button type="submit" class="btn btn-primary">Comprar</button>
                            </div>
                        </form>
                    </c:if>
                </c:otherwise>
            </c:choose>
    
            <div class="text-center mt-3">
                <h2>Precio total: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${carritoBean.precioTotal}"/></h2>
            </div>
            <div class="text-right mt-3">
                <a href="./index.html" class="btn btn-secondary">Atrás</a>
            </div>
        </div>
    </main>

       <!-- Separa el numero de tarjeta en grupos de 4 -->
       <script>
        function separarNumeroTarjeta() {
        var numeroTarjeta = document.getElementById('numero_tarjeta').value;
        var numeroTarjetaFormateado = numeroTarjeta.replace(/\s+/g, '').replace(/[^0-9]/gi, '').replace(/(.{4})/g, '$1 ');
        document.getElementById('numero_tarjeta').value = numeroTarjetaFormateado;
        }
        </script>


    </body>
</html>
