package pl.edu.pw.javaee.store.dao;

import org.springframework.stereotype.Repository;
import pl.edu.pw.javaee.store.model.Cart;

/**
 * Created by chada on 05.11.2016.
 */

public interface CartDao {

    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
