<%--
  Created by IntelliJ IDEA.
  User: chada
  Date: 06.11.2016
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Rejestracja</h1>
                    <p>Twoja rejestracja się powiodła!</p>
                </div>
            </div>
        </section>

        <section class="container" >
        <p>
            <a href="<spring:url value="/product/productList" />" class="btn btn-default">Produkty</a>
        </p>
        </section>

    </div>



</div>

<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
