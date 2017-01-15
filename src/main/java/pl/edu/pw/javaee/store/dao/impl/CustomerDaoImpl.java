package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.CustomerDao;
import pl.edu.pw.javaee.store.model.Authorities;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.Customer;
import pl.edu.pw.javaee.store.model.Users;

import java.util.List;

/**
 * Created by chada on 09.11.2016.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        customer.getShippingAddress().setCustomer(customer);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(cart);

        session.flush();
    }
    public Customer getCustomerById (long customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);
        return (Customer) query.uniqueResult();
    }

}

