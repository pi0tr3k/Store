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
 * DAO - Database Access Object
 * Jest to tzw. Encja, co oznacza, że obiekt tej klasy będzie przechowywany w bazie danych w postaci wiersza w tabeli.
 * Odpowiednikiem tej klasy w bazie danych jest tabela.
 * Wszelkie zmiany na tym obiekcie będą miały odzwierciedlenie w bazie danych.
 * Klasa zawiera pola będące właściwościami produktu.
 * Ma miejsce tutaj walidacja poprawności wprowadzanych przez użytkownika danych w formularzu.
 *
 * @author  Piotr Pluta
 * @version 1.0
 *
 */
@Getter
@Setter
@Entity
public class Product implements Serializable{

    /**
     * Serializacja
     */
    private static final long serialVersionUID = 6206417089308276694L;

    /**
     * Adnotacja @Id oznacza, że pole to w bazie danych pełni funkcję klucza głównego (PrimaryKey)
     * Adnotacja @GeneratedValue oznacza, że identyfikator dla kolejnych tworzonych obiektów będzie nadawany automatycznie.
     */
    @Id
    @GeneratedValue
    private long productId;

    /**
     * Nazwa produktu jest walidowana, tak aby nie można było wprowadzić wartości pustej
     */
    @NotEmpty (message = "Podaj nazwę produktu")
    private String productName;

    /**
     * Cena jest walidowana, tak aby nie można było podać ceny < 0
     */
    @Min(value = 0, message = "Cena produktu nie może być mniejsza niż zero")
    private double productPrice;

    /**
     * Opis produktu
     */
    private String productDescription;

    /**
     * Marka produktu
     */
    private String productManufacturer;

    /**
     * Kategoria produktu
     */
    private String productCategory;

    /**
     * Liczba sztuk jest walidowana, tak aby nie można było wprowadzić wartości < 0
     */
    @Min(value = 0, message = "Liczba sztuk produktu nie może być mniejsza niż zero")
    private int unitsInStock;

    /**
     * To pole zostanie zignorowane przez Hibernate'a - nie chcemy przechowywać obrazka w bazie danych,
     * tylko w katalogu w systemie plików.
     */
    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;
}
