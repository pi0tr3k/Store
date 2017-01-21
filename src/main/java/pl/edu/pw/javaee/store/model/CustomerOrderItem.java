package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author  Karolina Chadaj
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class CustomerOrderItem implements Serializable {


    private static final long serialVersionUID = 4562977354445202203L;
    @Id
    @GeneratedValue
    private long orderItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerOrderId")
    @JsonIgnore
    private CustomerOrder customerOrder;

    private int quantity;

}
