package pl.edu.pw.javaee.store.service;


import pl.edu.pw.javaee.store.model.Customer;

import java.util.List;

/**
 * Created by chada on 09.11.2016.
 */
public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById (long customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerByUsername(String username);
}
