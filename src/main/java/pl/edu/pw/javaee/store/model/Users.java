package pl.edu.pw.javaee.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by chada on 07.11.2016.
 */
@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue
    private int userId;
    private String username;
    private String password;
    private boolean enabled;
    private int customerId;
}
