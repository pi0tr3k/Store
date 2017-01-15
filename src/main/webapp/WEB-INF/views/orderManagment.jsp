<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container wrapper">

    <div class="container-fluid">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Zarządzanie zamówieniami</h1>
                </div>
            </div>
        </section>

        <section class="container-fluid" ng-app="orderApp">
            <div ng-controller = "orderCtrl" ng-init = "initOrderList('${orderList}')">


        <table class="table table-striped table-hover">
            <tr class="success">
                <th>Klient</th>
                <th>Data zamówienia</th>
                <th>Opłacone</th>
                <th>Wysłane</th>
                <th>Szczegóły zamówienia</th>
            </tr>

            <tr ng-repeat = "order in orderList">
                    <td>{{order.customerName}}</td>
                    <td>{{order.date}}</td>
                    <td>{{order.paid && 'TAK' || 'NIE'}} <a class="btn btn-default" ng-click="confirmPaidById(order.customerOrderId)" >Potwierdź</a></td>
                    <td>{{order.sent && 'TAK' || 'NIE'}} <a class="btn btn-default" ng-click="confirmSentById(order.customerOrderId)">Potwierdź</a></td>
                    <td><a href="<spring:url value="/viewOrder/{{order.customerOrderId}}" />">
                        <span class="glyphicon glyphicon-info-sign"></span> </a> </td>
            </tr>

        </table>

            </div>
        </section>

<script src="<c:url value="/resources/js/orderController.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>