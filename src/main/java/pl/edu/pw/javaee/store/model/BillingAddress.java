package pl.edu.pw.javaee.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chada on 07.11.2016.
 */
@Entity
@Getter
@Setter
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = -5406278810766673733L;

    @Id
    @GeneratedValue
    private int billingAddressId;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String country;
    private String zipCode;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "BillingAddress{" +
                "streetName='" + streetName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
