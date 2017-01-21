package pl.edu.pw.javaee.store.service;


import pl.edu.pw.javaee.store.model.Customer;

import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById (long customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerByUsername(String username);
}
