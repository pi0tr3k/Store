package pl.edu.pw.javaee.store.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.javaee.store.dao.CartDao;
import pl.edu.pw.javaee.store.dao.CartItemDao;
import pl.edu.pw.javaee.store.dao.CustomerOrderDao;
import pl.edu.pw.javaee.store.dao.ProductDao;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;
import pl.edu.pw.javaee.store.model.CustomerOrder;
import pl.edu.pw.javaee.store.model.Product;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Created by chada on 11.11.2016.
 */
@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private ProductDao productDao;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    public CustomerOrder getOrderById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CustomerOrder) session.get(CustomerOrder.class, id);
    }

    public List<CustomerOrder> getAllConfirmedOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where confirmed = ?");
        query.setBoolean(0,true);
        List<CustomerOrder> orders = query.list();
        return orders;
    }

    public CustomerOrder validateOrder(long orderId) throws IOException {
        CustomerOrder order = getOrderById(orderId);
        if (order.getCart() == null || order.getCart().getCartItems().size() == 0) {
            throw new IOException();
        }
        cartDao.update(order.getCart());
        return order;
    }

    public void confirmOrder(CustomerOrder order) throws IOException{
        Cart cart = order.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem: cartItems) {
            cartItemDao.removeCartItem(cartItem);
            Product product = cartItem.getProduct();
            int stock = product.getUnitsInStock() - cartItem.getQuantity();
            if (stock < 0) {
                throw new IOException();
            }
            product.setUnitsInStock(stock);
            product.getCartItemList().remove(cartItem);
            productDao.editProduct(product);
        }
        order.setConfirmed(true);
        java.util.Date utilDate = new java.util.Date();
        order.setDate(new Date(utilDate.getTime()));
        addCustomerOrder(order);
    }

}

