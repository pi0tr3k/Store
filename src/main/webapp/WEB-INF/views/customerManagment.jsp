<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container-fluid">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Zarządzanie klientami</h1>
                </div>
            </div>
        </section>

        <table class="table table-striped table-hover">
            <tr class="success">
                <th>Imię i nazwisko</th>
                <th>E-mail</th>
                <th>Telefon</th>
                <th>Nazwa użytkownika</th>
                <th>Odblokowany</th>
            </tr>

            <c:forEach items="${customerList}" var="customer">

                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                </tr>

            </c:forEach>

        </table>

<%@include file="/WEB-INF/views/template/footer.jsp"%>