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
                    <h1>Dziękujemy za złożenie zamówienia!</h1>
                    <p>Twoje zamówienie zostanie dostarczone w ciągu dwóch dni roboczych</p>
                </div>
            </div>
        </section>

        <section class="container" >
            <p>
                <a href="<spring:url value="/" />" class="btn btn-default">OK</a>
            </p>
        </section>

    </div>



</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
