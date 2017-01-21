<!--
- Author: Karolina Chadaj
- Description: Nagłówek
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
    <title>Rackethlon</title>
</head>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Carousel Template for Bootstrap</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"> </script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Rackethlon</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/" /> ">Strona główna</a></li>
                        <li><a href="<c:url value="/product/productList/tennis" /> ">Tenis ziemny</a></li>
                        <li><a href="<c:url value="/product/productList/tableTennis" /> ">Tenis stołowy</a></li>
                        <li><a href="<c:url value="/product/productList/clothes" /> ">Odzież i akcesoria</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                       <c:if test="${pageContext.request.userPrincipal.name != null}">
                           <li><a>Witaj: ${pageContext.request.userPrincipal.name}</a></li>
                           <li><a href="<c:url value="/j_spring_security_logout" />">Wyloguj się</a> </li>

                        <c:if test = "${pageContext.request.userPrincipal.name != 'admin'}">
                            <li><a href="<c:url value="/customer/cart"/> ">Koszyk</a> </li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                            <li><a href="<c:url value="/admin"/> ">Administrator</a></li>
                        </c:if>

                       </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li>
                            <a href="<c:url value="/login" />">Zaloguj się</a>
                        </li>
                        <li>
                            <a href="<c:url value="/register" />">Zarejestruj się</a>
                        </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>
