package pl.edu.pw.javaee.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chada on 07.11.2016.
 */
@Getter
@Setter
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = -1046807373430502836L;

    @Id
    @GeneratedValue
    private int customerOrderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

}
