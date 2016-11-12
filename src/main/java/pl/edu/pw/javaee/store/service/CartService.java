package pl.edu.pw.javaee.store.service;

import pl.edu.pw.javaee.store.model.Cart;

/**
 * Created by chada on 11.11.2016.
 */
public interface CartService {

    Cart getCartById (long cartId);
    void update(Cart cart);
}
