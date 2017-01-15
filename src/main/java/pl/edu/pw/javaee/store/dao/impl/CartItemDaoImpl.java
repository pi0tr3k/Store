package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.CartItemDao;
import pl.edu.pw.javaee.store.dao.CustomerOrderDao;
import pl.edu.pw.javaee.store.dao.ProductDao;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;
import pl.edu.pw.javaee.store.model.CustomerOrder;
import pl.edu.pw.javaee.store.model.Product;

import java.io.IOException;
import java.util.List;

/**
 * Created by chada on 11.11.2016.
 */
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    ProductDao productDao;

    @Autowired
    CustomerOrderDao orderDao;

    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem: cartItems) {
            removeCartItem(cartItem);
        }
    }

    public CartItem getCartItemByProductId(long productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ?");
        query.setLong(0, productId);
        return (CartItem) query.uniqueResult();
    }



}
