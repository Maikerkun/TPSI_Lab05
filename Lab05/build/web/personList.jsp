<%-- 
    Document   : personList.jsp
    Created on : 2020-04-06, 15:04:25
    Author     : dm41347
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person List</title>
        <style>
        table, th, td {
          border: 1px solid black;
        }
        </style>
    </head>
    <body>
        <table border:1>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${listaosob}" var="osoba">
                <tr>
                    <th>${osoba.getFirstName()}</th>
                    <th>${osoba.getLastName()}</th>
                    <th>${osoba.getEmail()}</th>   
                </tr>
            </c:forEach>
        </table>
        <h3>Liczba wejść w czasie sesji: ${sessionScope.licznik}</h3>
    </body>
</html>