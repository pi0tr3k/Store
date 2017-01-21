<%--
  - Author: Karolina Chadaj
  - Description: Widok logowania ...
  --%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Koszyk nieprawidłowy</h1>
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

<%@include file="/WEB-INF/views/template/footer.jsp"%>
