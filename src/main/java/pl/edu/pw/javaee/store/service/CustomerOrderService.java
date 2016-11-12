package pl.edu.pw.javaee.store.service;

import pl.edu.pw.javaee.store.model.CustomerOrder;

/**
 * Created by chada on 11.11.2016.
 */
public interface CustomerOrderService {

    void addCustomerOrder (CustomerOrder customerOrder);
    double getCustomerOrderGrandTotal (long cartId);
}
