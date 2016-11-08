package pl.edu.pw.javaee.store.dao;

import org.springframework.stereotype.Repository;
import pl.edu.pw.javaee.store.model.Cart;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chada on 05.11.2016.
 */
@Repository
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Nie można utworzyć. Koszyk z podanym id (%s) już " +
                    "istnieje. ", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Nie można zaktualizować. Koszyk z podanym id (%s) nie " +
                    "istnieje.", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);
    }

    public void delete (String cartId) {
        if (!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Nie można usunąć. Koszyk z podanym id (%s) nie " +
                    "istnieje ", cartId));
        }

        listOfCarts.remove(cartId);
    }
}
