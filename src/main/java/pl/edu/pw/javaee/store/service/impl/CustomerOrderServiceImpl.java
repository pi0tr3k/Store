package pl.edu.pw.javaee.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.javaee.store.dao.CustomerOrderDao;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;
import pl.edu.pw.javaee.store.model.CustomerOrder;
import pl.edu.pw.javaee.store.service.CartService;
import pl.edu.pw.javaee.store.service.CustomerOrderService;

import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderDao customerOrderDao;
    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(long cartId) {
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItemList = cart.getCartItems();
        double grandTotal = 0;
        for (CartItem cartItem: cartItemList) {
            grandTotal += cartItem.getTotalPrice();
        }
        return grandTotal;
    }

    public CustomerOrder getOrderById (long id) {
        return customerOrderDao.getOrderById(id);
    }

    public List<CustomerOrder> getAllConfirmedOrders() {
        return customerOrderDao.getAllConfirmedOrders();
    }
}
