package pl.edu.pw.javaee.store.dao;

import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;
import pl.edu.pw.javaee.store.model.CustomerOrder;

import java.io.IOException;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProductId(long productId);

}
