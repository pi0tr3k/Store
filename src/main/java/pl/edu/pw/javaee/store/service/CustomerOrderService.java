package pl.edu.pw.javaee.store.service;

import pl.edu.pw.javaee.store.model.CustomerOrder;

import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
public interface CustomerOrderService {

    void addCustomerOrder (CustomerOrder customerOrder);
    double getCustomerOrderGrandTotal (long cartId);
    CustomerOrder getOrderById (long orderId);
    List<CustomerOrder> getAllConfirmedOrders();
}
