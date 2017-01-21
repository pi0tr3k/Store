package pl.edu.pw.javaee.store.service;

import pl.edu.pw.javaee.store.model.Cart;
import pl.edu.pw.javaee.store.model.CartItem;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
public interface CartItemService {

    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProductId(long productId);
}
