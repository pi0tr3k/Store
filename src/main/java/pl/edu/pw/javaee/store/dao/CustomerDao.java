package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.Customer;

import java.util.List;

/**
 * Created by chada on 09.11.2016.
 */
public interface CustomerDao {
    void addCustomer(Customer customer);
    Customer getCustomerById (int customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerByUsername(String username);
}
