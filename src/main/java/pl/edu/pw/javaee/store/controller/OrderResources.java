package pl.edu.pw.javaee.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.javaee.store.model.*;
import pl.edu.pw.javaee.store.service.*;

import java.util.List;

/**
 * Created by chada on 11.11.2016.
 */
@Controller
@RequestMapping("/rest/order")
public class OrderResources {
    @Autowired
    private CustomerOrderService orderService;

    @RequestMapping("/{orderId}")
    public @ResponseBody
    CustomerOrder getOrderById (@PathVariable(value = "orderId") long orderId) {
        return orderService.getOrderById(orderId);
    }

    @RequestMapping("/orderList")
    public @ResponseBody
    List<CustomerOrder> getOrderList () {
        List<CustomerOrder> orderList = orderService.getAllConfirmedOrders();
        return orderList;
    }

    @RequestMapping(value = "/sent/{orderId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void confirmSent(@PathVariable(value = "orderId") long orderId) {
        CustomerOrder order = getOrderById(orderId);
        order.setSent(true);
        orderService.addCustomerOrder(order);
    }

    @RequestMapping(value = "/paid/{orderId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void confirmPaid(@PathVariable(value = "orderId") long orderId) {
        CustomerOrder order = getOrderById(orderId);
        order.setPaid(true);
        orderService.addCustomerOrder(order);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request")
    public void handleClientErrors(Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Internal server error")
    public void handleServerErrors(Exception e) {}


}
