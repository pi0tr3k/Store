package pl.edu.pw.javaee.store.dao;

import org.springframework.stereotype.Repository;
import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CustomerOrder;

import java.io.IOException;

/**
 * Created by chada on 05.11.2016.
 */

public interface CartDao {
    Cart getCartById (long cartId);
    void update(Cart cart);
}
