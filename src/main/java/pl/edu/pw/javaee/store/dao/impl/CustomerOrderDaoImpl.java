package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.CustomerOrderDao;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CustomerOrder;

/**
 * Created by chada on 11.11.2016.
 */
@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

}
