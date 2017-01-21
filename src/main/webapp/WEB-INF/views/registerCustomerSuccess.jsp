<%--
  - Author: Piotr Pluta
  - Description: Widok udanej rejestracji
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
            <a href="<spring:url value="/" />" class="btn btn-info">Powrót do strony głównej</a>
        </p>
        </section>

    </div>



</div>

<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
