<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@page session="true" %>
<%@ page import="java.util.*" %>


<html>
<head>
    <title>Carrito de Compra</title>
</head>
<body> 
    <h1>Carrito de Compra</h1>
    <table>
        <tr>
            <th>Artículo</th>
            <th>Cantidad</th>
            <th>Precio</th>
        </tr>
        
        <c:forEach items="${carritoBean.carrito}" var="a">
        <tr>
            <td><c:out value="${a.nombre}" /></td>
            <td><c:out value="${a.cantidad}" /></td>
            <td><c:out value="${a.precio}" /></td>
        </tr>
        </c:forEach>
    </table>
    <div>
        <h2>Precio total: <c:out value="${carritoBean.precioTotal}" /></h2>
    </div>
</body>
</html>