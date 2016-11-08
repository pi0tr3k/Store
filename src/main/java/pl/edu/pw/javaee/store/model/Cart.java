package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chada on 05.11.2016.
 */
@Getter
@Setter
@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -8286349071474552969L;
    @Id
    @GeneratedValue
    private String cartId;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn (name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;
/*
    private Cart() {
        cartItems = new HashMap<String, CartItem>();
        grandTotal = 0;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem (CartItem item) {
        String productId = item.getProduct().getProductId();

        if (cartItems.containsKey(productId)){
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, item);
        }

        updateGrandTotal();
    }

    public void removeCartItem (CartItem item){
        String productId = item.getProduct().getProductId();
        cartItems.remove(productId);

        updateGrandTotal();
    }

    public void updateGrandTotal(){
        grandTotal = 0;
        for (CartItem item: cartItems.values()){
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }
    */
}
