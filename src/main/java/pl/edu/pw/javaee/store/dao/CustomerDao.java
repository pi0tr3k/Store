package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.Customer;

import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
public interface CustomerDao {
    void addCustomer(Customer customer);
    Customer getCustomerById (long customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerByUsername(String username);
}
