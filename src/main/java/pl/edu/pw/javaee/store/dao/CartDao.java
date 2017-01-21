package pl.edu.pw.javaee.store.dao;

import org.springframework.stereotype.Repository;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CustomerOrder;

import java.io.IOException;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
public interface CartDao {
    Cart getCartById (long cartId);
    void update(Cart cart);
}
