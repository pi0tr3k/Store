package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CartItem implements Serializable {


    private static final long serialVersionUID = -7536313425637744312L;
    @Id
    @GeneratedValue
    private long cartItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    private int quantity;
    private double totalPrice;

    public CartItem (Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
    }
}
