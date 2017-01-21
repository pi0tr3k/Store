package pl.edu.pw.javaee.store.service;

import pl.edu.pw.javaee.store.model.Cart;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
public interface CartService {

    Cart getCartById (long cartId);
    void update(Cart cart);
}
