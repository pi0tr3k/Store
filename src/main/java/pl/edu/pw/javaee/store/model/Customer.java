package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private long customerId;

    @NotEmpty (message = "Proszę podać imię i nazwisko")
    private String customerName;

    @NotEmpty (message = "Proszę podać e-mail")
    private String customerEmail;
    private String customerPhone;

    @NotEmpty (message = "Proszę podać nazwę użytkownika")
    private String username;

    @NotEmpty (message = "Proszę podać hasło")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn (name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn (name = "cartId")
    @JsonIgnore
    private Cart cart;
}
