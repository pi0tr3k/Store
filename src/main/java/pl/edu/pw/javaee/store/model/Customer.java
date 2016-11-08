package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chada on 07.11.2016.
 */
@Getter
@Setter
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = -6545767588235401229L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty (message = "Nazwa klienta nie może być pusta")
    private String customerName;

    @NotEmpty (message = "Email klienta nie może być pusty")
    private String customerEmail;
    private String customerPhone;

    @NotEmpty (message = "Nazwa użytkownika nie może być pusta")
    private String username;

    @NotEmpty (message = "Hasło użytkownika nie może być puste")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn (name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn (name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn (name = "cartId")
    @JsonIgnore
    private Cart cart;
}
