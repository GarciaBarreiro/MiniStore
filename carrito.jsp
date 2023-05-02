<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ page import="java.util.*" %>


<html>
    <head>
        <title>Carrito de Compra</title>
        <link rel="stylesheet" href="./css/index.css">
    </head>
    <body> 
        <h1>Carrito de Compra</h1>
        <form action="eliminar"><table>
            <tr>
                <th>Artículo</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th></th>
            </tr>

            <c:forEach items="${carritoBean.carrito}" var="a">
            <tr>
                <td><c:out value="${a.nombre}" /></td>
                <td><c:out value="${a.cantidad}" /></td>
                <td><c:out value="${a.precio}" /></td>
                <td><input type="checkbox"></td>
            </tr>
                    </c:forEach>
                    <tr>
                        <td></td><td></td><td></td>
                        <td><input type="submit" value="Eliminar"</td>
                        <tr>
        </table></form>
        <div>
            <h2>Precio total: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${carritoBean.precioTotal}"/></h2>
        </div>
        <a href="./index.html">Atrás</a>
    </body>
</html>
