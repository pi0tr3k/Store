package pl.edu.pw.javaee.store.dao;

import org.springframework.stereotype.Repository;
import pl.edu.pw.javaee.store.model.Cart;

import java.io.IOException;

/**
 * Created by chada on 05.11.2016.
 */

public interface CartDao {

    Cart getCartById (long cartId);
    void update(Cart cart);
    Cart validate(long cartId) throws IOException;
}
