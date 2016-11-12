<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Panel administracyjny</h1>
            <p class="lead">To jest panel administracyjny</p>

        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Witaj: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Wyloguj</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory" />" >Asortyment</a>
        </h3>

        <p>Tutaj możesz dodawać, usuwać i edytować produkty</p>




        <h3>
            <a href="<c:url value="/admin/customer" />" >Zarządzanie klientami</a>
        </h3>

        <p>Możesz tu zobaczyć informacje o klientach.</p>

<%@include file="/WEB-INF/views/template/footer.jsp"%>