package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.CartItemDao;
import pl.edu.pw.javaee.store.dao.CustomerOrderItemDao;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;
import pl.edu.pw.javaee.store.model.CustomerOrderItem;

import java.util.List;

/**
 * Created by chada on 11.11.2016.
 */
@Repository
@Transactional
public class CustomerOderItemDaoImpl implements CustomerOrderItemDao {

    @Autowired
    SessionFactory sessionFactory;

    public void addCustomerOrderItem(CustomerOrderItem customerOrderItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrderItem);
        session.flush();
    }

    public List<CustomerOrderItem> getCustomerOrderItemListByOrderId(long customerOrderId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrderItem where customerOrderId = ?");
        query.setLong(0, customerOrderId);
        List<CustomerOrderItem> orderItems = query.list();
        return orderItems;
    }
}
