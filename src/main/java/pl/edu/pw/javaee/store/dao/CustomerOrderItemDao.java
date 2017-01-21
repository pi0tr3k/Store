package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;
import pl.edu.pw.javaee.store.model.CustomerOrderItem;

import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
public interface CustomerOrderItemDao {
    void addCustomerOrderItem(CustomerOrderItem customerOrderItem);
    List<CustomerOrderItem> getCustomerOrderItemListByOrderId(long customerOrderId);
}
