package pl.edu.pw.javaee.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
@Entity
@Getter
@Setter
public class ShippingAddress implements Serializable{

    private static final long serialVersionUID = -5406278810766673733L;

    @Id
    @GeneratedValue
    private long shippingAddressId;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String country;
    private String zipCode;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return streetName + " " + apartmentNumber + ", " + zipCode + " " + city + ", " + country;
    }
}
