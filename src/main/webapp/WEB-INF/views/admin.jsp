<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="container wrapper">

    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Panel administracyjny</h1>
                </div>
            </div>
        </section>

        <a href="<c:url value="/admin/productInventory" />" class="btn btn-info">

            <h3>Asortyment</h3>
            <p>Dodawanie, usuwanie i edytowanie produktów</p>
        </a>


        <a href="<c:url value="/admin/customer" />" class="btn btn-success" >
            <h3>Zarządzanie klientami</h3>

            <p>Informacje o klientach</p>
        </a>

        <a href="<c:url value="/admin/order" />" class="btn btn-warning" >
            <h3>Zarządzanie zamówieniami</h3>

            <p>Lista zamówień, szczegóły, potwierdzanie opłacenia i wysyłki</p>
        </a>

<%@include file="/WEB-INF/views/template/footer.jsp"%>