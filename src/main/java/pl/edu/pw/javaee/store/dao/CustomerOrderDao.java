package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.CustomerOrder;

import java.io.IOException;
import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
public interface CustomerOrderDao {

    void addCustomerOrder (CustomerOrder customerOrder);
    CustomerOrder getOrderById(long id);
    List<CustomerOrder> getAllConfirmedOrders();
    CustomerOrder validateOrder(long orderId) throws IOException;
    void confirmOrder (CustomerOrder order) throws IOException;
}
