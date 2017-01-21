package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -8286349071474552969L;
    @Id
    @GeneratedValue
    private long cartId;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn (name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

}
