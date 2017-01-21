/**
 * Konsument serwisu REST-owego
 *
 * @author  Karolina Chadaj
 * @version 1.0
 */

var orderApp = angular.module ("orderApp", []);

orderApp.controller("orderCtrl", function ($scope, $http) {

    $scope.initOrderId = function (orderId) {
        $scope.orderId = orderId;
        $scope.refreshOrder(orderId);
    };

    $scope.initOrderList = function (orderList) {
        $scope.orderList = orderList;
        $scope.refreshOrders();
    };

    $scope.refreshOrder = function () {
        $http.get('/rest/order/'+$scope.orderId).success(function (data) {
            $scope.order=data;
        });

    };

    $scope.refreshOrders = function () {
        $http.get('/rest/order/orderList').success(function (data) {
            $scope.orderList=data;
        });

    };

    $scope.confirmPaid = function () {
        $http.put('/rest/order/paid/'+$scope.orderId).success(function (data) {
        });

    };

    $scope.confirmSent = function () {
        $http.put('/rest/order/sent/'+$scope.orderId).success(function (data) {
        });

    };

    $scope.confirmSentById = function (orderId) {
        $http.put('/rest/order/sent/'+orderId).success(function (data) {
            $scope.refreshOrders();
        });

    };

    $scope.confirmPaidById = function (orderId) {
        $http.put('/rest/order/paid/'+orderId).success(function (data) {
            $scope.refreshOrders();
        });
    };

});