package pl.edu.pw.javaee.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.javaee.store.dao.CustomerDao;
import pl.edu.pw.javaee.store.model.Customer;
import pl.edu.pw.javaee.store.service.CustomerService;

import java.util.List;

/**
 * Created by chada on 09.11.2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById (int id) {
        return customerDao.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
