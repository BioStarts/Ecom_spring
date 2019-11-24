<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
    </head>

    <body>
        <h1>Привет страница</h1>
        <h2>Index:</h2>
        <br>
        <a href="${pageContext.request.contextPath}/showSimpleForm">Show Simple Form Page</a>
        <br>
        <a href="${pageContext.request.contextPath}/students/showForm">Show Students Form Page</a>
    </body>
</html>