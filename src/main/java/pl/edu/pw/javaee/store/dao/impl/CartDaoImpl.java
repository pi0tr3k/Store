package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.CartDao;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.service.CustomerOrderService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chada on 05.11.2016.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, id);
    }

    public void update(Cart cart){
        long cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    public Cart validate(long cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }
}
