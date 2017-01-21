package pl.edu.pw.javaee.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author  Piotr Pluta
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue
    private long userId;

    private String username;
    private String password;
    private boolean enabled;
    private long customerId;
}
