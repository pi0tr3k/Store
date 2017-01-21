package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = -1046807373430502836L;

    @Id
    @GeneratedValue
    private long customerOrderId;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @JsonIgnore
    @OneToOne
    private ShippingAddress shippingAddress;

    private String customerName;
    private Date date;
    private boolean paid;
    private boolean sent;
    private boolean confirmed;

}
