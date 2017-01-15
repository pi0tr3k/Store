package pl.edu.pw.javaee.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kara on 2016-10-15.
 */
@Getter
@Setter
@Entity
public class Product implements Serializable{

    private static final long serialVersionUID = 6206417089308276694L;
    @Id
    @GeneratedValue
    private long productId;
    @NotEmpty (message = "Podaj nazwę produktu")
    private String productName;
    @Min(value = 0, message = "Cena produktu nie może być mniejsza niż zero")
    private double productPrice;
    private String productDescription;
    private String productManufacturer;
    private String productCategory;
    @Min(value = 0, message = "Liczba sztuk produktu nie może być mniejsza niż zero")
    private int unitsInStock;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;


}
